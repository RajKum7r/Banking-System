package models;

public class Account {

	private int accountID;
	private int customerID;
	private String accountType;
	private double accountBalance;
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}



	/**
	 * @param accountID
	 * @param customerID
	 * @param accountType
	 * @param accountBalance
	 */
	public Account(int accountID, int customerID, String accountType, double accountBalance) {
		super();
		this.accountID = accountID;
		this.customerID = customerID;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

}
