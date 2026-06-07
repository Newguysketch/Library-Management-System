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

    @Override
    public String toString() {
        return isbn + " | " + title + " | " + author;
    }
}

class Member {
    String memberId;
    String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    @Override
    public String toString() {
        return memberId + " | " + name;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {

        // Books
        books.add(new Book("B001", "Java Basics", "James Gosling"));
        books.add(new Book("B002", "OOP Concepts", "Robert Martin"));

        // Members
        members.add(new Member("M001", "Suyog Basukala"));
        members.add(new Member("M002", "John Smith"));

        System.out.println("===== LIBRARY BOOKS =====");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\n===== LIBRARY MEMBERS =====");
        for (Member member : members) {
            System.out.println(member);
        }
    }
}