import java.time.LocalDate;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean borrowed;
    private LocalDate availableDate;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.borrowed = false;
        this.availableDate = LocalDate.now();
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return borrowed; }
    public LocalDate getAvailableDate() { return availableDate; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }

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
        return isbn + " | " + title + " | " + author +
                " | Borrowed: " + borrowed +
                " | Available: " + availableDate;
    }
}