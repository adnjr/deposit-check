package accounts;

import java.util.ArrayList;
import java.util.List;

/*
 * This abstract class is the parent to CheckingAccount, as well as account
 * types that would be implemented in the future, e.g. savings, investment.
 * This is an example of the Polymorphism pattern (behavior varies by type).
 */
abstract public class Account {

	private Long accountNumber;
	private List<Long> memberIDs;
	private Long balance;
	private String status;
	private Long routingNumber;

	public Account(Long accountNumber, Long routingNum, Long balance, Long... memberIDs) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.routingNumber = routingNum;

		this.memberIDs = new ArrayList<Long>();
		if (memberIDs != null && memberIDs.length > 0)
			for (Long id : memberIDs)
				this.memberIDs.add(id);
		
		this.status = "open";
	}

	// Polymorphism: sub-class implements behavior that varies by type
	abstract public String getAccountType();
	
	// Expert: Account should be responsible for knowing its accountNumber (also supports low representational gap)
	public Long getAccountNumber() {
		return accountNumber;
	}

	// Expert: Account has the information necessary (its accountNumber) to complete this task
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	// Expert: Account should be responsible for knowing its associated memberIDs (also supports low representational gap)
	public List<Long> getMembers() {
		return memberIDs;
	}

	// Expert: Account has the information necessary (its memberIDs) to complete this task
	public void setMembers(List<Long> memberIDs) {
		this.memberIDs = memberIDs;
	}

	// Expert: Account should be responsible for knowing its balance (also supports low representational gap)
	// balance returned in dollars
	public Double getBalance() {
		return balance / 10.0;
	}

	// Expert: Account has the information necessary (its balance) to complete this task
	// balance parameter should be in dollars
	public void setBalance(Double balance) {
		this.balance = (long)(balance * 10);
	}

	// Expert: Account should be responsible for knowing its status (also supports low representational gap)
    public String getStatus() {
        return status;
    }

    // Expert: Account has the information necessary (its status) to complete this task
    public void setStatus(String status) {
        this.status = status;
    }
	
    // Expert: Account has the information necessary (its memberIDs) to complete this task
	public void addMember(Long memberID) {
	    memberIDs.add(memberID);
	}
	
	// Expert: Account has the information necessary (its memberIDs) to complete this task
	public void removeMember(Long memberID) {
	    memberIDs.remove(memberID);
	}
	
	// Expert: Account has the information necessary (its memberIDs) to complete this task
	public boolean isAccessAuthorized(Long memberID) {
	    return memberIDs.contains(memberID);
	}
	
	// Expert: Account should be responsible for knowing its routingNumber (also supports low representational gap)
	public Long getRoutingNumber() {
		return routingNumber;
	}

	// Polymorphism: sub-class implements toString() behavior that varies by type
	@Override
	public String toString() {
	    return "account #" + getAccountNumber() + " (routing #" + getRoutingNumber() + "): $" + getBalance();
	}
	
}
