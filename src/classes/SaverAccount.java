package classes;

public class SaverAccount extends BankAccount {

	public SaverAccount(int accNo, Customer customer) {
		super(accNo, customer);
		this.noticeNeeded=true;
	}
	public SaverAccount(int accNo, Customer customer,double balance,int PIN) {
		super(accNo, customer,balance,PIN);
		this.noticeNeeded=true;
	}
	
	public boolean ifWithdraw(double amount){
		if((this.getBalance()-amount)<=0){
			return false;
		}
		return true;
	}
	
}
