package transactions;

import java.util.Date;

abstract public class Transaction {
    
    private int transactionID;
    private int accountNumber;
    private int previousBalance;
    private int amount;
    private Date date;

    public Transaction(int transactionID, int accountNumber, int previousBalance,
                       int amount) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.previousBalance = previousBalance;
        this.amount = amount;
        this.date = new Date();
    }
    
    abstract public String getType();
    
    abstract public int getNewBalance();

    public int getTransactionID() {
        return transactionID;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPreviousBalance() {
        return previousBalance;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
    
}
