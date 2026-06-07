import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
                + " | Available: " + availableDate;
    }
}

class Member {
    String memberId;
    String name;
    int borrowLimit;
    int borrowedCount;
    ArrayList<String> currentLoans;
    ArrayList<String> borrowingHistory;

    public Member(String memberId, String name, int borrowLimit) {
        this.memberId = memberId;
        this.name = name;
        this.borrowLimit = borrowLimit;
        this.borrowedCount = 0;
        this.currentLoans = new ArrayList<>();
        this.borrowingHistory = new ArrayList<>();
    }

    public boolean canBorrow() {
        return borrowedCount < borrowLimit;
    }

    public void addBorrowedBook(Book book) {
        borrowedCount++;
        currentLoans.add(book.title);
        borrowingHistory.add(book.title + " borrowed on " + LocalDate.now());
    }

    public void removeBorrowedBook(Book book) {
        if (borrowedCount > 0) {
            borrowedCount--;
        }
        currentLoans.remove(book.title);
    }

    public void showCurrentLoans() {
        System.out.println("\nCurrent Loans for " + name + ":");

        if (currentLoans.isEmpty()) {
            System.out.println("No current loans.");
        } else {
            for (String loan : currentLoans) {
                System.out.println("- " + loan);
            }
        }
    }

    public void showBorrowingHistory() {
        System.out.println("\nBorrowing History for " + name + ":");

        if (borrowingHistory.isEmpty()) {
            System.out.println("No borrowing history.");
        } else {
            for (String history : borrowingHistory) {
                System.out.println("- " + history);
            }
        }
    }

    public String toString() {
        return memberId + " | " + name
                + " | Borrow Limit: " + borrowLimit
                + " | Borrowed Count: " + borrowedCount;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        books.add(new Book("B001", "Java Basics", "James Gosling"));
        books.add(new Book("B002", "OOP Concepts", "Robert Martin"));
        books.add(new Book("B003", "Data Structures", "Mark Allen"));

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
            System.out.println("6. View Current Loans");
            System.out.println("7. View Borrowing History");
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
                case 6:
                    viewCurrentLoans();
                    break;
                case 7:
                    viewBorrowingHistory();
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

    public static Book findBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static Member findMember(String memberId) {
        for (Member member : members) {
            if (member.memberId.equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public static void borrowBook() {
        System.out.print("Enter Member ID: ");
        String memberId = input.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        Member member = findMember(memberId);
        Book book = findBook(isbn);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.borrowed) {
            System.out.println("Book already borrowed.");
            System.out.println("Available on: " + book.availableDate);
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Borrow limit reached.");
            return;
        }

        book.borrowBook();
        member.addBorrowedBook(book);

        System.out.println("Book borrowed successfully.");
        System.out.println("Due date: " + book.availableDate);
    }

    public static void returnBook() {
        System.out.print("Enter Member ID: ");
        String memberId = input.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = input.nextLine();

        Member member = findMember(memberId);
        Book book = findBook(isbn);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.borrowed) {
            System.out.println("This book is not currently borrowed.");
            return;
        }

        book.returnBook();
        member.removeBorrowedBook(book);

        System.out.println("Book returned successfully.");
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

    public static void viewCurrentLoans() {
        System.out.print("Enter Member ID: ");
        String memberId = input.nextLine();

        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            member.showCurrentLoans();
        }
    }

    public static void viewBorrowingHistory() {
        System.out.print("Enter Member ID: ");
        String memberId = input.nextLine();

        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            member.showBorrowingHistory();
        }
    }
}