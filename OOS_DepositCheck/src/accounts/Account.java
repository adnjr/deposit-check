package accounts;

import java.util.ArrayList;
import java.util.List;

abstract public class Account {

	private int accountNumber;
	private List<Integer> memberIDs;
	private int balance;
	private String status;
	
	public Account(int accountNumber, int routingNum, int balance, int... memberIDs) {
		this.accountNumber = accountNumber;
		this.balance = balance;

		this.memberIDs = new ArrayList<Integer>();
		if (memberIDs != null && memberIDs.length > 0)
			for (int id : memberIDs)
				this.memberIDs.add(id);
	}

	abstract public String getAccountType();
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Integer> getMembers() {
		return memberIDs;
	}

	public void setMembers(List<Integer> memberIDs) {
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
	
	public void addMember(int memberID) {
	    memberIDs.add(memberID);
	}
	
	public void removeMember(Integer memberID) {
	    memberIDs.remove(memberID);
	}
	
	public boolean isAccessAuthorized(Integer memberID) {
	    return memberIDs.contains(memberID);
	}
	
	@Override
	public String toString() {
	    return "account " + getAccountNumber() + ": " + getBalance();
	}
	
}
