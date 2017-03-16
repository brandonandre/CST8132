import java.util.Random;

/**
 * 
 * The BankAccountTest class is used to simulate bank account data by populating it with
 * different kinds of bank accounts with random values. And also run a year simulation on
 * the data to see interest and fees play a role in each month. 
 * 
 * @author Brandon Andre
 *
 */
public class BankAccountTest {

	/**
	 * Maximum amount of money the simulation will give the account.
	 */
	public final double MAX_RANDOM_BALANCE = 20000;
	
	/**
	 * Minimum amount of money the simulation will give the account. 
	 */
	public final double MIN_RANDOM_BALANCE = 500;
	
	/**
	 * Array of the bank accounts being simulated. 
	 */
	//Declare the bank accounts
	public BankAccount[] accounts;
	
	//Declare and Instantiate the months
	public final static String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public static void main(String[] args) {
		//Declare the simulation class.
		BankAccountTest test = new BankAccountTest();
		
		//Generate the accounts to test around with.
		//Instantiate the Bank Accounts array
		test.accounts = new BankAccount[30];
		
		//Initialize the Bank Account array with a random value and different bank accounts.
		for(int i=0; i < (test.accounts.length); i+=2){
			
			//For each account come up with a random balance.
			Random random = new Random();
			
			//Add the minimum since it needs to be higher than that. Since it's adding the minimum the maximum gets offset. So it's subtracted.
			double randomBalance = test.MIN_RANDOM_BALANCE + ((test.MAX_RANDOM_BALANCE - test.MIN_RANDOM_BALANCE) * random.nextDouble());
	
			//Create 15 saving accounts and 15 chequing account
			test.accounts[i] = new SavingsAccount(randomBalance);
			test.accounts[i+1] = new ChequingAccount(randomBalance);
			
		}
		
		//Simulate a year of processes running every month.
		for(int i=0; i < MONTHS.length; i++){
			System.out.println("Balances for bank accounts for "+MONTHS[i]+":");
			test.monthlyProcess(test.accounts); //Pass the arrays which are generated through the test bank account simulation.
			test.display(test.accounts); //Display the result.
			System.out.println(); //New Line for the next process.
		}
	}
	
	/**
	 * For all bank accounts in the simulation, run the calculateAndUpdateBalance method
	 * for each bank account.
	 *
	 * @see calculateAndUpdateBalance();
	 */
	public void monthlyProcess(BankAccount[] accounts){
		for (int i=0; i < accounts.length; i++){
			accounts[i].calculateAndUpdateBalance();
		}
	}
	
	/**
	 * For all bank accounts in the simulation, run the getBalance method located in the
	 * abstract class.
	 * 
	 * @see getBalance();	
	 */
	public void display(BankAccount[] accounts){
		for (int i=0; i < accounts.length; i++){
			System.out.print("#"+i+": ");
			accounts[i].displayBalance();
		}
	}
	
}
