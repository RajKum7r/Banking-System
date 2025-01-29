package models;

import java.util.Date;

public class Transaction {
	private int transactionID;
	private int accountID;
	private String transactionType;
	private double transactionAmount;
	private Date transactionDate;
	

	/**
	 * @param transactionID
	 * @param accountID
	 * @param transactionType
	 * @param transactionAmount
	 * @param transactionDate
	 */
	public Transaction(int transactionID, int accountID, String transactionType, double transactionAmount,
			Date transactionDate) {
		super();
		this.transactionID = transactionID;
		this.accountID = accountID;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}
	
	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}




}
