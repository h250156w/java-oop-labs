package lab11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ItemNotAvailableException extends Exception {
    public ItemNotAvailableException(String message) { super(message); }
}

class MemberLimitExceededException extends Exception {
    public MemberLimitExceededException(String message) { super(message); }
}

interface Borrowable {
    void borrowItem(Member member) throws ItemNotAvailableException, MemberLimitExceededException;
    void returnItem(Member member);
}

abstract class SystemItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    public SystemItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract int getLoanPeriodDays();
    public String toCsv() { return id + "," + title + "," + available; }
}

class BookItem extends SystemItem {
    public BookItem(String id, String title) { super(id, title); }
    @Override public int getLoanPeriodDays() { return 14; }

    @Override
    public void borrowItem(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!isAvailable()) {
            throw new ItemNotAvailableException("Item '" + getTitle() + "' is currently checked out.");
        }
        if (member.getBorrowedItems().size() >= ConfigurationManager.getInstance().getMaxBorrowLimit()) {
            throw new MemberLimitExceededException("Member " + member.getName() + " reached maximum borrowing limit.");
        }
        setAvailable(false);
        member.addLoan(this);
    }

    @Override
    public void returnItem(Member member) {
        setAvailable(true);
        member.removeLoan(this);
    }
}

class Member {
    private final String id;
    private final String name;
    private final List<SystemItem> borrowedItems = new ArrayList<>();

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<SystemItem> getBorrowedItems() { return borrowedItems; }

    public void addLoan(SystemItem item) { borrowedItems.add(item); }
    public void removeLoan(SystemItem item) { borrowedItems.remove(item); }
    public String toCsv() { return id + "," + name; }
}

public class LibrarySystem {
    private final Map<String, SystemItem> catalog = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    public void registerItem(SystemItem item) { catalog.put(item.getId(), item); }
    public void registerMember(Member member) { members.put(member.getId(), member); }

    public void processBorrow(String memberId, String itemId) {
        try {
            Member m = members.get(memberId);
            SystemItem item = catalog.get(itemId);

            if (m == null || item == null) {
                throw new IllegalArgumentException("Invalid Member ID or Item ID.");
            }

            item.borrowItem(m);
            System.out.println("Success: " + m.getName() + " borrowed '" + item.getTitle() + "'");
        } catch (ItemNotAvailableException | MemberLimitExceededException | IllegalArgumentException e) {
            System.err.println("Borrow Failed: " + e.getMessage());
        }
    }

    public List<SystemItem> searchByTitle(String query) {
        return catalog.values().stream()
            .filter(item -> item.getTitle().toLowerCase().contains(query.toLowerCase()))
            .sorted(Comparator.comparing(SystemItem::getTitle))
            .collect(Collectors.toList());
    }

    public void saveSystemState() {
        try {
            List<String> itemLines = catalog.values().stream().map(SystemItem::toCsv).toList();
            Files.write(Path.of("catalog_data.csv"), itemLines);

            List<String> memberLines = members.values().stream().map(Member::toCsv).toList();
            Files.write(Path.of("members_data.csv"), memberLines);

            System.out.println("\nSystem state persisted successfully to CSV files.");
        } catch (IOException e) {
            System.err.println("Failed to write persistence data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();

        System.out.println("=== " + ConfigurationManager.getInstance().getAppName() + " ===");

        BookItem b1 = new BookItem("B01", "Effective Java");
        BookItem b2 = new BookItem("B02", "Clean Code");
        BookItem b3 = new BookItem("B03", "Design Patterns");
        BookItem b4 = new BookItem("B04", "Refactoring");

        Member m1 = new Member("M101", "James Makamure");

        system.registerItem(b1);
        system.registerItem(b2);
        system.registerItem(b3);
        system.registerItem(b4);
        system.registerMember(m1);

        System.out.println("\n--- Processing Borrow Requests ---");
        system.processBorrow("M101", "B01");
        system.processBorrow("M101", "B02");
        system.processBorrow("M101", "B03");
        system.processBorrow("M101", "B04");

        System.out.println("\n--- Catalog Search Test ---");
        List<SystemItem> results = system.searchByTitle("java");
        results.forEach(item -> System.out.println("Found: " + item.getTitle() + " (Available: " + item.isAvailable() + ")"));

        system.saveSystemState();
    }
}
