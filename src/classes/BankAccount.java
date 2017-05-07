package classes;

import java.util.Random;

public class BankAccount {
	protected int accNo;
	protected int pin;
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getUnclear_amount() {
		return unclear_amount;
	}
	public void setUnclear_amount(double unclear_amount) {
		this.unclear_amount = unclear_amount;
	}

	protected String accName;
	protected double balance;
	protected double unclear_amount;
	protected Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	protected boolean isSuspended;
	public boolean isSuspended() {
		return isSuspended;
	}
	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	protected boolean isActive;
	protected boolean noticeNeeded;
	

	/**
	 * this is for create the account
	 * @param accNo
	 * @param customer
	 */
	public BankAccount(int accNo,Customer customer){
		this.accNo = accNo;
		this.customer = customer;
		this.balance = 0.0;
		this.isActive=true;
		generatePin();
	}
	/**
	 * this is for reading from the csv files
	 * @param accNo
	 * @param customer
	 * @param balance
	 * @param PIN
	 */
	public BankAccount(int accNo,Customer customer,double balance,int PIN){
		this.accNo = accNo;
		this.customer = customer;
		this.balance = balance;
		this.isActive=true;
		this.pin = PIN;
	}
	/**
	 * this function is to generate 6 bits random pin code
	 */
	private void generatePin(){
		Random r = new Random();
		this.pin = (100000 + r.nextInt(900000));
	} 
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		}
	
	public void depositWithUnclearedAmount(){
		balance  += unclear_amount;
		unclear_amount=0;
	}
	public void withdraw(double amount) {
	if ((balance - amount) >= 0) {
		balance = balance - amount;
	} else {
	System.out.println("Withdraw unsuccessfull. Do not have enough available funds.");
	}
	}
	
	public String toString() {
		return "Account number: " + accNo + "\n" + "Account name: " + accName
		+ "\n" + "Balance: " + balance + "\n";
		}
	/**
	 * this function is for write the basic information to file
	 * @return string representation of each account information
	 */
	public String toFile(){
		String tmp="";
		int type=0;
		if(this instanceof CurrentAccount){
			type = 1;
		}else if(this instanceof SaverAccount){
			type = 2;
		}else if(this instanceof JuniorAccount){
			type = 3;
		}
		tmp= this.accNo+";"+this.pin+";"+this.customer.getName()+";"
		+this.customer.getBirth_year()+"-"+this.customer.getBirth_month()+"-"+this.customer.getBirth_day()
		+";"+this.customer.getAddress()+";"+this.balance+";"+type+";"+this.isSuspended;
		
		return tmp;
		
	}
	
}
