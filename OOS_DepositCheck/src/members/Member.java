package members;

import java.util.Date;

public class Member {
    
    private int memberID;
    private int ssn;
    private String firstName;
    private String middleName;
    private String lastName;
    
    public Member(int memberID, int ssn, String firstName, String middleName,
                                                   String lastName) {
        this.memberID = memberID;
        this.ssn = ssn;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
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

}
