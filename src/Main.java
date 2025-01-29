import models.Account;
import models.Bank;
import models.Customer;

public class Main {

	public static void main(String[] args) {

		Bank bank = new Bank();
		
		Customer customer1 = new Customer(1, "John Doe", "123 Main St", "123-456-7890", "john.doe@example.com");
		bank.addCustomer(customer1);

		Account account1 = new Account(1, 1, "Checking", 1000.0);
		bank.addAccount(account1);
		
		bank.depositMoney(1, 500.0);
		bank.displayCustomerAccounts(1);
		bank.withdrawMoney(1, 200);
		
		bank.displayCustomerAccounts(1);
		bank.displayTransactionHistory(1);



		
		
	}

}
