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

    // Expert
    public long getMemberID() {
        return memberID;
    }

    // Expert
    public void setMemberID(long memberID) {
        this.memberID = memberID;
    }

    // Expert
    public String getFirstName() {
        return firstName;
    }

    // Expert
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Expert
    public String getMiddleName() {
        return middleName;
    }

    // Expert
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Expert
    public String getLastName() {
        return lastName;
    }

    // Expert
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // Expert
    public String getFullName() {
    	return firstName + " " + middleName + " " + lastName;
    }
    
    // Polymorphism
    @Override
    public String toString() {
        return "member #" + getMemberID() + ": " + getFullName();
    }

}
