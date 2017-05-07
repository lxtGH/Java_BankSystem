package bank;
/**
 * this class is kind of bankaccount 
 * @author lbw 
 *
 */
public class JuniorAccount extends BankAccount{
	
	public JuniorAccount(int accNo, Customer customer) {
		super(accNo, customer);
		overDraftLimit = 0;
		//noticeNeeded = false;
	}
	
}
