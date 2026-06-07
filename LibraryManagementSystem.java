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

class Member {
    String memberId;
    String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String toString() {
        return memberId + " | " + name;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        books.add(new Book("B001", "Java Basics", "James Gosling"));
        books.add(new Book("B002", "OOP Concepts", "Robert Martin"));

        members.add(new Member("M001", "Suyog Basukala"));
        members.add(new Member("M002", "John Smith"));

        System.out.println("===== BOOKS =====");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\n===== MEMBERS =====");
        for (Member member : members) {
            System.out.println(member);
        }
    }
}