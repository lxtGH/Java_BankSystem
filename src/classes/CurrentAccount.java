package classes;

public class CurrentAccount extends BankAccount {
	// this account has the overdraftLimits
	private double overdraftLimits=1000;
	public CurrentAccount(int accNo, Customer customer) {
		super(accNo, customer);
		this.noticeNeeded=false;
	}
	public CurrentAccount(int accNo, Customer customer,Double balance,int PIN) {
		super(accNo, customer,balance,PIN);
		this.noticeNeeded=false;
	}
	public double getOverdraftLimits() {
		return overdraftLimits;
	}
	public void setOverdraftLimits(double overdraftLimits) {
		this.overdraftLimits = overdraftLimits;
	}
	public boolean ifWithdraw(double amount){
		if((this.getBalance()-amount)>=0){
			return true;
		}
		else if(Math.abs(this.getBalance()-amount)<=this.overdraftLimits){
			return true;
		}
		return false;
	}
	public void withdraw(double amount){
		this.balance -= amount;
	}
	
}
