public class RegularMember extends Member {

    public RegularMember(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getBorrowLimit() {
        return 3;
    }
}   