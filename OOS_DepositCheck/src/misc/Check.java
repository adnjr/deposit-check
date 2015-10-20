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

	public int getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	public int getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayTo() {
		return payTo;
	}

	public void setPayTo(String payTo) {
		this.payTo = payTo;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerAddress() {
		return payerAddress;
	}

	public void setPayerAddress(String payerAddress) {
		this.payerAddress = payerAddress;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public ImageIcon getSignature() {
		return signature;
	}

	public void setSignature(ImageIcon signature) {
		this.signature = signature;
	}
    
    
}
