package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

	private List<Customer> customers;
	private List<Account> accounts;
	private List<Transaction> transactions;

	public Bank() {
		this.customers = new ArrayList<>();
		this.accounts = new ArrayList<>();
		this.transactions = new ArrayList<>();

	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public void depositMoney(int accountID, double amount) {
		Account account = accounts.stream().filter(a -> a.getAccountID() == accountID).findFirst().orElse(null);

		if (account != null) {
			account.setAccountBalance(account.getAccountBalance() + amount);
			Transaction transaction = new Transaction(transactions.size() + 1, accountID, "Deposit", amount,
					new Date());
			transactions.add(transaction);
		}
	}

	public void withdrawMoney(int accountID, double amount) {
		Account account = accounts.stream().filter(a -> a.getAccountID() == accountID).findFirst().orElse(null);

		if (account != null) {
			if (account.getAccountBalance() >= amount) {
				account.setAccountBalance(account.getAccountBalance() - amount);
				Transaction transaction = new Transaction(transactions.size() + 1, accountID, "Withdrawal", amount,
						new Date());
				transactions.add(transaction);
			}
		}
	}

	public void displayCustomerAccounts(int customerID) {
		Customer customer = customers.stream().filter(c -> c.getCustomerID() == customerID).findFirst().orElse(null);

		if (customer != null) {
			List<Account> accounts = this.accounts.stream().filter(a -> a.getCustomerID() == customerID)
					.collect(Collectors.toList());

			for (Account account : accounts) {
				System.out.println("Account ID: " + account.getAccountID());
				System.out.println("Account Type: " + account.getAccountType());
				System.out.println("Account Balance: " + account.getAccountBalance());
			}
		}
	}

	public void displayTransactionHistory(int accountID) {


		List<Transaction> transactions = this.transactions.stream().filter(t -> t.getAccountID() == accountID)
				.collect(Collectors.toList());

		for (Transaction transaction : transactions) {
			System.out.println("Transaction ID: " + transaction.getTransactionID());
			System.out.println("Transaction Type: " + transaction.getTransactionType());
			System.out.println("Transaction Amount: " + transaction.getTransactionAmount());
			System.out.println("Transaction Date: " + transaction.getTransactionDate());

		}
	}

}
