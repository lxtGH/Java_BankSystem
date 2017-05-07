package bank;
/**
 * this class is a kind of bankAccount that can have the overdraft limit 
 * @author lbw 	
 *
 */
public class CurrentAccount extends BankAccount {
	/**
	 * 
	 * @param accNo
	 * @param customer
	 */
	public CurrentAccount(int accNo, Customer customer) {
		super(accNo, customer);
		overDraftLimit = 500;
	}

	public CurrentAccount(int accNo, Customer customer, double overdraftLimit) {
		super(accNo, customer);
		this.setOverdraftLimit(overdraftLimit);
	}

	public double getOverdraftLimit() {
		return overDraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overDraftLimit = overdraftLimit;
	}

}