package accounts;

import java.util.ArrayList;
import java.util.List;

abstract public class Account {

	private long accountNumber;
	private List<Long> memberIDs;
	private long balance;
	private String status;
	
	public Account(long accountNumber, long routingNum, long balance, long... memberIDs) {
		this.accountNumber = accountNumber;
		this.balance = balance;

		this.memberIDs = new ArrayList<Long>();
		if (memberIDs != null && memberIDs.length > 0)
			for (long id : memberIDs)
				this.memberIDs.add(id);
	}

	abstract public String getAccountType();
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Long> getMembers() {
		return memberIDs;
	}

	public void setMembers(List<Long> memberIDs) {
		this.memberIDs = memberIDs;
	}

	// balance returned in dollars
	public double getBalance() {
		return balance / 10.0;
	}

	// balance parameter should be in dollars
	public void setBalance(double balance) {
		this.balance = (int)(balance * 10);
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
	public void addMember(long memberID) {
	    memberIDs.add(memberID);
	}
	
	public void removeMember(Long memberID) {
	    memberIDs.remove(memberID);
	}
	
	public boolean isAccessAuthorized(Long memberID) {
	    return memberIDs.contains(memberID);
	}
	
	@Override
	public String toString() {
	    return "account " + getAccountNumber() + ": " + getBalance();
	}
	
}
