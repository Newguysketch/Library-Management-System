import java.util.Scanner;

public class LibraryManagementSystem {

    static Scanner input = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = getInt("Enter choice: ");

            switch (choice) {
                case 1 -> library.showBooks();
                case 2 -> library.showMembers();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> searchBook();
                case 6 -> viewCurrentLoans();
                case 7 -> viewBorrowingHistory();
                case 8 -> addBook();
                case 9 -> updateBook();
                case 10 -> removeBook();
                case 11 -> registerMember();
                case 12 -> updateMember();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Show Books");
        System.out.println("2. Show Members");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Book");
        System.out.println("6. View Current Loans");
        System.out.println("7. View Borrowing History");
        System.out.println("8. Add Book");
        System.out.println("9. Update Book");
        System.out.println("10. Remove Book");
        System.out.println("11. Register Member");
        System.out.println("12. Update Member");
        System.out.println("0. Exit");
    }

    public static String getText(String message) {
        String value;
        do {
            System.out.print(message);
            value = input.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("Input cannot be empty.");
            }
        } while (value.isEmpty());

        return value;
    }

    public static int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void addBook() {
        String isbn = getText("Enter ISBN: ");
        String title = getText("Enter title: ");
        String author = getText("Enter author: ");

        library.addBook(isbn, title, author);
    }

    public static void updateBook() {
        String isbn = getText("Enter ISBN: ");
        String title = getText("Enter new title: ");
        String author = getText("Enter new author: ");

        library.updateBook(isbn, title, author);
    }

    public static void removeBook() {
        String isbn = getText("Enter ISBN: ");
        library.removeBook(isbn);
    }

    public static void registerMember() {
        String memberId = getText("Enter Member ID: ");
        String name = getText("Enter name: ");
        String type = getText("Premium member? (Y/N): ");

        library.registerMember(memberId, name, type.equalsIgnoreCase("Y"));
    }

    public static void updateMember() {
        String memberId = getText("Enter Member ID: ");
        String name = getText("Enter new name: ");

        library.updateMember(memberId, name);
    }

    public static void borrowBook() {
        String memberId = getText("Enter Member ID: ");
        String isbn = getText("Enter ISBN: ");

        library.borrowBook(memberId, isbn);
    }

    public static void returnBook() {
        String memberId = getText("Enter Member ID: ");
        String isbn = getText("Enter ISBN: ");

        library.returnBook(memberId, isbn);
    }

    public static void searchBook() {
        String keyword = getText("Enter title, author or ISBN: ");
        library.searchBook(keyword);
    }

    public static void viewCurrentLoans() {
        String memberId = getText("Enter Member ID: ");
        library.viewCurrentLoans(memberId);
    }

    public static void viewBorrowingHistory() {
        String memberId = getText("Enter Member ID: ");
        library.viewBorrowingHistory(memberId);
    }
}