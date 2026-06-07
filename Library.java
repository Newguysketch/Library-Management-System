import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public Library() {
        books.add(new Book("B001", "Java Basics", "James Gosling"));
        books.add(new Book("B002", "OOP Concepts", "Robert Martin"));
        books.add(new Book("B003", "Data Structures", "Mark Allen"));

        members.add(new RegularMember("M001", "Suyog Basukala"));
        members.add(new PremiumMember("M002", "Premium User"));
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void addBook(String isbn, String title, String author) {
        if (findBook(isbn) != null) {
            System.out.println("Book already exists.");
            return;
        }

        books.add(new Book(isbn, title, author));
        System.out.println("Book added successfully.");
    }

    public void updateBook(String isbn, String title, String author) {
        Book book = findBook(isbn);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        book.setTitle(title);
        book.setAuthor(author);
        System.out.println("Book updated successfully.");
    }

    public void removeBook(String isbn) {
        Book book = findBook(isbn);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Cannot remove borrowed book.");
            return;
        }

        books.remove(book);
        System.out.println("Book removed successfully.");
    }

    public void registerMember(String memberId, String name, boolean premium) {
        if (findMember(memberId) != null) {
            System.out.println("Member already exists.");
            return;
        }

        if (premium) {
            members.add(new PremiumMember(memberId, name));
        } else {
            members.add(new RegularMember(memberId, name));
        }

        System.out.println("Member registered successfully.");
    }

    public void updateMember(String memberId, String name) {
        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        member.setName(name);
        System.out.println("Member updated successfully.");
    }

    public void borrowBook(String memberId, String isbn) {
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

        if (book.isBorrowed()) {
            System.out.println("Book already borrowed.");
            System.out.println("Available on: " + book.getAvailableDate());
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Borrow limit reached.");
            return;
        }

        book.borrowBook();
        member.addBorrowedBook(book);

        System.out.println("Book borrowed successfully.");
        System.out.println("Due date: " + book.getAvailableDate());
    }

    public void returnBook(String memberId, String isbn) {
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

        if (!book.isBorrowed()) {
            System.out.println("This book is not currently borrowed.");
            return;
        }

        book.returnBook();
        member.removeBorrowedBook(book);

        System.out.println("Book returned successfully.");
    }

    public void searchBook(String keyword) {
        boolean found = false;
        keyword = keyword.toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword)
                    || book.getAuthor().toLowerCase().contains(keyword)
                    || book.getIsbn().toLowerCase().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void viewCurrentLoans(String memberId) {
        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            member.showCurrentLoans();
        }
    }

    public void viewBorrowingHistory(String memberId) {
        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            member.showBorrowingHistory();
        }
    }
}