package members;

public class Member {
    
    private long memberID;
    private String firstName;
    private String middleName;
    private String lastName;
    
    public Member(long memberID, String firstName, String middleName,
                                                   String lastName) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public long getMemberID() {
        return memberID;
    }

    public void setMemberID(long memberID) {
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFullName() {
    	return firstName + " " + middleName + " " + lastName;
    }
    
    @Override
    public String toString() {
        return "member " + getMemberID() + ": " + getFullName();
    }

}
