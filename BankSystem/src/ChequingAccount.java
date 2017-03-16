/**
 * ChequingAccounts are {@link BankAccount} objects where every month a fee is taken out
 * of the accounts balance.
 * 
 * @author Brandon Andre
 * @see BankAccount
 */
public class ChequingAccount extends BankAccount {

	/**
	 * fee is the amount of money removed the account for every month. 
	 */
	public double fee = 5;
	
	/**
	 * Sole constructor.
	 * If you create an account with no parameters it defaults to zero balance.  
	 */
	public ChequingAccount(){
		super(0);
	}
	
	/**
	 * Constructor
	 * Presets a value for the balance of the account.
	 * 
	 * @param balance (Value gets set as the balance of the account.)
	 */
	public ChequingAccount(double balance) {
		super(balance);
	}

	/**
	 * Calculate the amount of money will have to removed for the fee of the account
	 * every month.
	 */
	@Override
	public void calculateAndUpdateBalance() {
		balance -= fee; 
	}

	
	/**
	 * Display the balance in a nicely formatted way. Show the account type with it.
	 */
	@Override
	public void displayBalance() {
		String formattedBalance = String.format("%.2f", getBalance());
		System.out.println("Chequing account balance: $" + formattedBalance);
	}

}
