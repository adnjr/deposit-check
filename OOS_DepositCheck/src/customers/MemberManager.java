package customers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MemberManager {
	
	Map<Integer, Member> customersByID;
	Map<String, Member> customersByName;
	
	public MemberManager() {
		customersByID = new HashMap<Integer, Member>();
		customersByName = new HashMap<String, Member>();
	}
	
	public void addMember(int customerID, int ssn, String firstName, String middleName,
            String lastName, Date dob) {
		Member newMember;
		
		newMember = new Member(customerID, ssn, firstName, middleName, lastName, dob);
		customersByID.put(customerID, newMember);
		customersByName.put(firstName + " " + middleName + " " + lastName, newMember);
	}
	
	public int getMemberIDOf(String memberFullName) {
		Member member;
		int id = -1;
		
		if ( (member = customersByName.get(memberFullName)) != null)
				id = member.getMemberID();
		
		return id;
	}
	
	public String getNameOf(int memberID) {
		Member member;
		String name = null;
		
		if ( (member = customersByID.get(memberID)) != null)
			name = member.getFirstName() + " " + member.getMiddleName() + " " + member.getLastName();
		
		return name;
	}

}
