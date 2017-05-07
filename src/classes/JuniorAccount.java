package classes;

public class JuniorAccount extends BankAccount {

	public JuniorAccount(int accNo, Customer customer) {
		super(accNo, customer);
		// TODO Auto-generated constructor stub
		this.noticeNeeded=false;
	}
	public JuniorAccount(int accNo, Customer customer,double balance,int PIN) {
		super(accNo, customer,balance,PIN);
		// TODO Auto-generated constructor stub
		this.noticeNeeded=false;
	}
	public boolean ifWithdraw(double amount){
		if((this.getBalance()-amount)<=0){
			return false;
		}
		return true;
	}

}
