import java.time.LocalDate;

public class Book {
    String isbn;
    String title;
    String author;
    boolean borrowed;
    LocalDate availableDate;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.borrowed = false;
        this.availableDate = LocalDate.now();
    }

    public void borrowBook() {
        borrowed = true;
        availableDate = LocalDate.now().plusDays(14);
    }

    public void returnBook() {
        borrowed = false;
        availableDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return isbn + " | " + title + " | " + author
                + " | Borrowed: " + borrowed
                + " | Available: " + availableDate;
    }
}