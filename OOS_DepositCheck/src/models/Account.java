package models;

import java.util.HashMap;
import java.util.Map;

abstract public class Account {

	private int accountNumber;
	private Map<Integer, Customer> customers;
	private int balance;
	private String status;
	
	public Account(int accountNumber, int balance, Customer... customers) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customers = new HashMap<Integer, Customer>();
		if (customers != null && customers.length > 0)
    		for (Customer customer : customers)
    		    this.customers.put(customer.getCustomerID(), customer);
	}

	abstract public String getAccountType();
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Map<Integer, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Map<Integer, Customer> customers) {
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
	
	public boolean addCustomer(Customer customer) {
	    customers.put(customer.getCustomerID(), customer);
	    return true;
	}
	
	public boolean removeCustomer(Integer customerID) {
	    return customers.remove(customerID) != null;
	}
	
	public boolean isAccessAuthorized(Integer customerID) {
	    return customers.containsKey(customerID);
	}
	
}
