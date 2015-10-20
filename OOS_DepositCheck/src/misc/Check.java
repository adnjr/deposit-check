package misc;

import java.util.Date;

import javax.swing.ImageIcon;

public class Check {
    
    private int checkNumber;
    private int routingNumber;
    private Date checkDate;
    private int amount;
    private String payTo;
    private String payerName;
    private String payerAddress;
    private String memo;
    private ImageIcon signature;

    public Check() {
        
    }

    // Expert
	public int getCheckNumber() {
		return checkNumber;
	}

    // Expert
	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

    // Expert
	public int getRoutingNumber() {
		return routingNumber;
	}

    // Expert
	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}

    // Expert
	public Date getCheckDate() {
		return checkDate;
	}

    // Expert
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

    // Expert
	public int getAmount() {
		return amount;
	}

    // Expert
	public void setAmount(int amount) {
		this.amount = amount;
	}

    // Expert
	public String getPayTo() {
		return payTo;
	}

    // Expert
	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

    // Expert
	public String getPayerName() {
		return payerName;
	}

    // Expert
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

    // Expert
	public String getPayerAddress() {
		return payerAddress;
	}

    // Expert
	public void setPayerAddress(String payerAddress) {
		this.payerAddress = payerAddress;
	}

    // Expert
	public String getMemo() {
		return memo;
	}

    // Expert
	public void setMemo(String memo) {
		this.memo = memo;
	}

    // Expert
	public ImageIcon getSignature() {
		return signature;
	}

    // Expert
	public void setSignature(ImageIcon signature) {
		this.signature = signature;
	}
    
    
}
