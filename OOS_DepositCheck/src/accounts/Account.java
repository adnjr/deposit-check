package accounts;

import java.util.ArrayList;
import java.util.List;

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

	abstract public String getAccountType();
	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Long> getMembers() {
		return memberIDs;
	}

	public void setMembers(List<Long> memberIDs) {
		this.memberIDs = memberIDs;
	}

	// balance returned in dollars
	public Double getBalance() {
		return balance / 10.0;
	}

	// balance parameter should be in dollars
	public void setBalance(Double balance) {
		this.balance = (long)(balance * 10);
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
	public void addMember(Long memberID) {
	    memberIDs.add(memberID);
	}
	
	public void removeMember(Long memberID) {
	    memberIDs.remove(memberID);
	}
	
	public boolean isAccessAuthorized(Long memberID) {
	    return memberIDs.contains(memberID);
	}
	
	public Long getRoutingNumber() {
		return routingNumber;
	}

	@Override
	public String toString() {
	    return "account #" + getAccountNumber() + " (routing #" + getRoutingNumber() + "): $" + getBalance();
	}
	
}
