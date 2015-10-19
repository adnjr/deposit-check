package accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customers.Member;

abstract public class Account {

	private int accountNumber;
	private Map<Integer, Member> customers;
	private List<Integer> memberIDs;
	private int balance;
	private String status;
	
	public Account(int accountNumber, int routingNum, int balance, int... memberIDs) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customers = new HashMap<Integer, Member>();
		this.memberIDs = new ArrayList<Integer>();
		if (memberIDs != null && memberIDs.length > 0)
			for (int id : memberIDs)
				this.memberIDs.add(id);
//		if (customers != null && customers.length > 0)
//    		for (Member customer : customers)
//    		    this.customers.put(customer.getMemberID(), customer);
	}

	abstract public String getAccountType();
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Map<Integer, Member> getCustomers() {
		return customers;
	}

	public void setCustomers(Map<Integer, Member> customers) {
		this.customers = customers;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
	public boolean addCustomer(Member customer) {
	    customers.put(customer.getMemberID(), customer);
	    return true;
	}
	
	public boolean removeCustomer(Integer customerID) {
	    return customers.remove(customerID) != null;
	}
	
	public boolean isAccessAuthorized(Integer customerID) {
	    return customers.containsKey(customerID);
	}
	
}
