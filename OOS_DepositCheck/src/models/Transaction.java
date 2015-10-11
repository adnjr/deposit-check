package models;

import java.util.Date;

abstract public class Transaction {
    
    private int transactionID;
    private int accountNumber;
    private int previousBalance;
    private int amount;
    private Date date;

    public Transaction(int transactionID, int accountNumber, int previousBalance,
                       int amount, Date date) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.previousBalance = previousBalance;
        this.amount = amount;
        this.date = date;
    }
    
    abstract public String getType();

    public int getTransactionID() {
        return transactionID;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPreviousBalance() {
        return previousBalance;
    }

    public int getNewBalance() {
        return previousBalance + amount;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
    
}
