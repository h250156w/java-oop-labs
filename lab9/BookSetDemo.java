package lab9;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ")";
    }
}

public class BookSetDemo {
    public static void main(String[] args) {
        Set<Book> library = new HashSet<>();
        library.add(new Book("978-0134685991", "Effective Java"));
        library.add(new Book("978-0134685991", "Effective Java (Duplicate)"));

        System.out.println("Unique Books in Set: " + library.size());
        System.out.println("Collection Content: " + library);
    }
}
