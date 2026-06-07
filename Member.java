import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Member {

    protected String memberId;
    protected String name;
    protected int borrowedCount;

    protected ArrayList<String> currentLoans;
    protected ArrayList<String> borrowingHistory;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;

        borrowedCount = 0;
        currentLoans = new ArrayList<>();
        borrowingHistory = new ArrayList<>();
    }

    public abstract int getBorrowLimit();

    public String getMemberId() {
        return memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean canBorrow() {
        return borrowedCount < getBorrowLimit();
    }

    public void addBorrowedBook(Book book) {
        borrowedCount++;
        currentLoans.add(book.getTitle());
        borrowingHistory.add(
                book.getTitle() + " borrowed on " + LocalDate.now());
    }

    public void removeBorrowedBook(Book book) {
        if (borrowedCount > 0)
            borrowedCount--;

        currentLoans.remove(book.getTitle());
    }

    public void showCurrentLoans() {
        if (currentLoans.isEmpty()) {
            System.out.println("No current loans.");
            return;
        }

        for (String loan : currentLoans) {
            System.out.println(loan);
        }
    }

    public void showBorrowingHistory() {
        if (borrowingHistory.isEmpty()) {
            System.out.println("No borrowing history.");
            return;
        }

        for (String history : borrowingHistory) {
            System.out.println(history);
        }
    }

    @Override
    public String toString() {
        return memberId + " | " + name +
                " | Borrow Limit: " + getBorrowLimit() +
                " | Borrowed Count: " + borrowedCount;
    }
}