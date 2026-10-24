package lab11;

abstract class LibraryItem {
    private final String id;
    private final String title;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public abstract String getItemType();
}

class Book extends LibraryItem {
    public Book(String id, String title) { super(id, title); }
    @Override public String getItemType() { return "Book"; }
}

class Dvd extends LibraryItem {
    public Dvd(String id, String title) { super(id, title); }
    @Override public String getItemType() { return "DVD"; }
}

class ItemFactory {
    public static LibraryItem createItem(String type, String id, String title) {
        if (type.equalsIgnoreCase("BOOK")) {
            return new Book(id, title);
        } else if (type.equalsIgnoreCase("DVD")) {
            return new Dvd(id, title);
        }
        throw new IllegalArgumentException("Unknown item type: " + type);
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        LibraryItem item1 = ItemFactory.createItem("BOOK", "B101", "Design Patterns");
        LibraryItem item2 = ItemFactory.createItem("DVD", "D201", "Java Video Course");

        System.out.println("Created: " + item1.getTitle() + " (" + item1.getItemType() + ")");
        System.out.println("Created: " + item2.getTitle() + " (" + item2.getItemType() + ")");
    }
}
