/**
 * SavingsAccount are {@link BankAccount} objects where interest rates are added to the
 * balance every month. 
 * 
 * @author Brandon Andre
 * @see BankAccount
 */
public class SavingsAccount extends BankAccount {

	//Declare the interest rate. 
	/**
	 * interestRate is the interest rate used to process the interest every month.
	 */
	public double interestRate = 1.1;
	
	/**
	 * Sole constructor. New bank accounts start at zero balance.
	 */
	public SavingsAccount(){
		super(0);
	}
	
	/**
	 * Constructor
	 * Presets a value for the balance of the account.
	 * 
	 * @param balance (Value gets set as the balance of the account.)
	 */
	public SavingsAccount(double balance){
		super(balance);
	}

	/**
	 * Calculates how much interest should be added to the account based on the
	 * interest for this specific account.
	 */
	@Override
	public void calculateAndUpdateBalance() {
		balance *= interestRate;
	}

	/**
	 * Display the balance in a nicely formatted way. Show the account type with it.
	 */
	@Override
	public void displayBalance() {
		String formattedBalance = String.format("%.2f", getBalance());
		System.out.println("Saving Account Balance: $" + formattedBalance);
	}
	
}
