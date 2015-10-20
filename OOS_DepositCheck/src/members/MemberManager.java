package members;

import java.util.HashMap;
import java.util.Map;

/* High Cohesion, Low Coupling, Pure Fabrication:
 * The MemberManager increases the cohesion of the BankingSystemController
 * class, by delegating the responsibility of managing Members to another
 * class. MemberManager is not something that exists in the domain, and
 * is therefore a Pure Fabrication.
 */
public class MemberManager {
	
	Map<Long, Member> membersByID;
	Map<String, Member> membersByName;
	
	public MemberManager() {
		membersByID = new HashMap<Long, Member>();
		membersByName = new HashMap<String, Member>();
	}
	
	// Expert: MemberManager aggregates Member objects and should be responsible for adding more
	public void addMember(long memberID, String firstName, String middleName,
            String lastName) {
		Member newMember;
		
		newMember = new Member(memberID, firstName, middleName, lastName);
		membersByID.put(memberID, newMember);
		membersByName.put(newMember.getFullName(), newMember);
	}
	
	/* Expert, Indirection, Protected Variations (Don't Talk To Strangers):
	 * MemberManager aggregates Member objects and should be responsible for retrieving their IDs,
	 * instead of having clients retrieve the member and then get the ID from it directly.
	 */
	public long getMemberIDOf(String memberFullName) {
		Member member;
		long id = -1;
		
		if ( (member = membersByName.get(memberFullName)) != null)
				id = member.getMemberID();
		
		return id;
	}
	
	/* Expert, Indirection, Protected Variations (Don't Talk To Strangers):
	 * MemberManager aggregates Member objects and should be responsible for retrieving their names,
	 * instead of having clients retrieve the member and then get the name from it directly.
	 */
	public String getNameOf(long memberID) {
		Member member;
		String name = null;
		
		if ( (member = membersByID.get(memberID)) != null)
			name = member.getFullName();
		
		return name;
	}
	
	// Expert: MemberManager aggregates Member objects and should be responsible for retrieving them
	public Member getMember(long memberID) {
	    return membersByID.get(memberID);
	}

}
