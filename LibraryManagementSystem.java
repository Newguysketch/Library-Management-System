import java.time.LocalDate;
import java.util.ArrayList;

class Book {
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

    public String toString() {
        return isbn + " | " + title + " | " + author
                + " | Borrowed: " + borrowed
                + " | Available Date: " + availableDate;
    }
}

class Member {
    String memberId;
    String name;
    int borrowLimit;

    public Member(String memberId, String name, int borrowLimit) {
        this.memberId = memberId;
        this.name = name;
        this.borrowLimit = borrowLimit;
    }

    public String toString() {
        return memberId + " | " + name + " | Borrow Limit: " + borrowLimit;
    }
}

public class LibraryManagementSystem {

    public static void searchBook(ArrayList<Book> books, String keyword) {

        System.out.println("\nSearch Results:");

        boolean found = false;

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(keyword)
                    || book.author.equalsIgnoreCase(keyword)
                    || book.isbn.equalsIgnoreCase(keyword)) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        books.add(new Book("B001", "Java Basics", "James Gosling"));
        books.add(new Book("B002", "OOP Concepts", "Robert Martin"));

        members.add(new Member("M001", "Suyog Basukala", 3));
        members.add(new Member("M002", "Premium User", 6));

        books.get(0).borrowBook();
        books.get(0).returnBook();

        System.out.println("===== BOOKS =====");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\n===== MEMBERS =====");
        for (Member member : members) {
            System.out.println(member);
        }

        searchBook(books, "Java Basics");
    }
}