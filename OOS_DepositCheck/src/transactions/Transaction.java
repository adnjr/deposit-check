package transactions;

import java.util.Date;

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
    
    abstract public long getNewBalance();

    public long getTransactionID() {
        return transactionID;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getPreviousBalance() {
        return previousBalance;
    }

    public long getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
    
    @Override
    public String toString() {
        return getType() + " transaction " + getTransactionID() + ": " + getAmount();
    }
    
}
