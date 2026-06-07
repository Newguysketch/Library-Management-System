import java.time.LocalDate;
import java.util.ArrayList;

public class Member {

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
        borrowedCount = 0;

        currentLoans = new ArrayList<>();
        borrowingHistory = new ArrayList<>();
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
        borrowedCount--;
        currentLoans.remove(book.title);
    }

    public void showCurrentLoans() {
        for (String loan : currentLoans) {
            System.out.println(loan);
        }
    }

    public void showBorrowingHistory() {
        for (String history : borrowingHistory) {
            System.out.println(history);
        }
    }

    @Override
    public String toString() {
        return memberId + " | " + name
                + " | Borrow Limit: " + borrowLimit
                + " | Borrowed Count: " + borrowedCount;
    }
}