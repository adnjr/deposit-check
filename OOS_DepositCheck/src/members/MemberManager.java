package members;

import java.util.HashMap;
import java.util.Map;

public class MemberManager {
	
	Map<Integer, Member> membersByID;
	Map<String, Member> membersByName;
	
	public MemberManager() {
		membersByID = new HashMap<Integer, Member>();
		membersByName = new HashMap<String, Member>();
	}
	
	public void addMember(int memberID, String firstName, String middleName,
            String lastName) {
		Member newMember;
		
		newMember = new Member(memberID, firstName, middleName, lastName);
		membersByID.put(memberID, newMember);
		membersByName.put(newMember.getFullName(), newMember);
	}
	
	public int getMemberIDOf(String memberFullName) {
		Member member;
		int id = -1;
		
		if ( (member = membersByName.get(memberFullName)) != null)
				id = member.getMemberID();
		
		return id;
	}
	
	public String getNameOf(int memberID) {
		Member member;
		String name = null;
		
		if ( (member = membersByID.get(memberID)) != null)
			name = member.getFullName();
		
		return name;
	}
	
	public Member getMember(int memberID) {
	    return membersByID.get(memberID);
	}

}
