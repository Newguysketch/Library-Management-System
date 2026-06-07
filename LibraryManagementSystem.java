import java.util.ArrayList;

class Book {
    String isbn;
    String title;
    String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return isbn + " | " + title + " | " + author;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        books.add(new Book("101", "Java Basics", "James"));
        books.add(new Book("102", "OOP Concepts", "Robert"));

        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}