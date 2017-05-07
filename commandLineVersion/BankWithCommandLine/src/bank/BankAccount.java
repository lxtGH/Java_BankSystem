package bank;

import java.util.Random;
/**
 * BankAccount  (the basic class) 
 * @author lbw
 *
 */
public class BankAccount {
	protected int accountNumber; // 
	protected int PIN; //PIN  of each account 
	protected double NotClearFunds;
	protected Customer customer;
	protected double overDraftLimit;
	protected boolean isSuspended;
	protected boolean isActive;
	protected double balance;
	/**
	 * Bank Account for construtor of bank account 
	 * @param accNo
	 * @param customer
	 */
	public BankAccount(int accNo, Customer customer) {
		this.accountNumber = accNo;
		this.customer = customer;
		this.balance = 0.0;
		this.isActive = true;
		this.isSuspended = false;
		this.NotClearFunds = 0;
		generatePINnumber();
	}
	
	private void generatePINnumber(){
		Random r = new Random();
		PIN = (100000 + r.nextInt(900000));
	}
	
	public double getUnclearFund(){
		return NotClearFunds;
	}

	public int getAccNo() {
		return accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getBalance() {
		return balance;
	}
	
	public int getPin(){
		return PIN;
	}
	
	public boolean isSuspended(){
		return this.isSuspended;
	}
	
	public void setSuspended(boolean set){
		isSuspended = set;
		System.out.println("The account has been suspended successfully!");
	}
	
	public boolean close(){
		if(balance == 0 || balance < 10){
			isActive = false;
			System.out.println("The account has been successfully closed!");
		}else{
			System.out.println("Fail to close! The balance of the account must be zero or less than 10 ");
		}
		return isActive;
	}

	public void deposit(double amount, int deposit_type) {
		if(isSuspended){
			System.out.println("The account has been suspended, you can not deposit any money into it");
		}
		else if(deposit_type == 1){
		balance = balance + amount;
		System.out.println("Deposit " + amount + " successfully");
	    }else if(deposit_type == 2){
	    	NotClearFunds += amount;
	    	System.out.println("The deposit is now unclear.");
	    }
	}
	/**
	 * plus the unclearFund to the balance
	 */
	public void setClear(){
		balance = balance + NotClearFunds;
		NotClearFunds = 0;
	}
	
	

	public void withdraw(double amount) {
		if(isSuspended){
			System.out.println("The account has been suspended, you can not withdraw the money");
		}
		else if (CheckDate(amount)) {
			balance = balance - amount;
			System.out.println("Withdraw " + amount + " successfull.");
		}
	}

	protected boolean CheckDate(double amount) {
		boolean allowed = false;
		if (this.getBalance() - amount >= -overDraftLimit) {
			allowed = true;
		} else {
			System.out.println("Withdraw " + amount
					+ " unsuccessfull. you do not  have enough available funds.");
		}
		return allowed;
	}
	public String toString() {
		return "Account number: " + accountNumber + "\n" + "Account name: " + customer.getCustomerName()
				+ "\n" + "Balance: " + balance + "\n";
	}

}
