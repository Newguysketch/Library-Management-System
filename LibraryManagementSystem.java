import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String isbn;
    String title;
    String author;
    boolean borrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public void borrowBook() {
        borrowed = true;
    }

    public void returnBook() {
        borrowed = false;
    }

    public String toString() {
        return isbn + " | " + title + " | " + author + " | Borrowed: " + borrowed;
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

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        books.add(new Book("B001", "Java Basics", "James Gosling"));
        books.add(new Book("B002", "OOP Concepts", "Robert Martin"));

        members.add(new Member("M001", "Suyog Basukala", 3));
        members.add(new Member("M002", "Premium User", 6));

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Show Books");
            System.out.println("2. Show Members");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    showBooks();
                    break;

                case 2:
                    showMembers();
                    break;

                case 3:
                    borrowBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    searchBook();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void showBooks() {
        System.out.println("\nBooks:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void showMembers() {
        System.out.println("\nMembers:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public static void borrowBook() {

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        for (Book book : books) {

            if (book.isbn.equalsIgnoreCase(isbn)) {

                if (book.borrowed) {
                    System.out.println("Book already borrowed.");
                } else {
                    book.borrowBook();
                    System.out.println("Book borrowed successfully.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void returnBook() {

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        for (Book book : books) {

            if (book.isbn.equalsIgnoreCase(isbn)) {
                book.returnBook();
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void searchBook() {

        System.out.print("Enter title, author or ISBN: ");
        String keyword = input.nextLine();

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
}