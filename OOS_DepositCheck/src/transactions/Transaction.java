package transactions;

import java.util.Date;

// Polymorphism
abstract public class Transaction {
    
    private long transactionID;
    private long accountNumber;
    private long previousBalance;
    private long amount;
    private Date date;

    public Transaction(long transactionID, long accountNumber, long previousBalance,
                       long amount) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.previousBalance = previousBalance;
        this.amount = amount;
        this.date = new Date();
    }
    
    abstract public String getType();
    
    abstract public double getNewBalance();

    // Expert
    public long getTransactionID() {
        return transactionID;
    }

    // Expert
    public long getAccountNumber() {
        return accountNumber;
    }

    // Expert
    public double getPreviousBalance() {
        return previousBalance / 10.0;
    }

    // Expert    
    public double getAmount() {
        return amount / 10.0;
    }

    // Expert
    public Date getDate() {
        return date;
    }
    
    // Polymorphism
    @Override
    public String toString() {
        return getType() + " transaction #" + getTransactionID() + ": #" + getAmount();
    }
    
}
