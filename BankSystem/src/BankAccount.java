
/**
 * The abstract bank account class for the different types of bank accounts you can have.
 *
 * @author Brandon Andre
 * @see ChequingAccount, SavingsAccount
 */
public abstract class BankAccount {
	
	/**
	 * The amount of money in the account currently. 
	 */
	public double balance;
	
	/**
	 * Constructor. Used to initialize the balance variable with a preset balance.
	 * @param balance The Balance which is set to the specific account.
	 */
	public BankAccount(double balance){
		this.balance = balance; 
	}
	
	/**
	 * Retrieve the balance of the account.
	 * @return the value of the balance.
	 */
	public double getBalance(){
		return balance;
	}
	
	/**
	 * Based on the type of the account it determines the type
	 * of math it needs to do. For a saving account it has interest
	 * rate. Or chequing accounts with fees every month.
	 * 
	 * @author Brandon Andre
	 */
	public abstract void calculateAndUpdateBalance();
	
	/**
	 * Depending on the account display the balance. And show the account type as well.
	 * 
	 * @author Brandon Andre
	 */
	public abstract void displayBalance();

}
