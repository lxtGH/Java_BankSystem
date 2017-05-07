package bank;
import java.util.ArrayList;
/**
 * 
 * ClassName: Bank 
 * @Description: This class is the center bank which contains a AccountList that maintain and manage the accounts
 * @author BoWen Li
 * @date 2017/5/6 
 */
public class Bank {
	private ArrayList<BankAccount> AccountList = new ArrayList<BankAccount>();

	public void openAccount(BankAccount b) {
		AccountList.add(b);
	}

	public void closeAccount(BankAccount b) {
		AccountList.remove(b);
	}
	/**
	 * find the account by providing the account number 
	 * @param acc account 
	 * @return account 
	 */
	public BankAccount getBankAccount(int acc){
		for (BankAccount banckaccount : AccountList) {
			if (banckaccount.getAccNo() == acc) {
				return banckaccount;
			}
	}
		return null;
	}
	/**
	 * clear the uncleared funds for each accounts
	 */
	public void clearAllAccountFund(){
		for (BankAccount bankAccount : AccountList) {
			if (bankAccount.getUnclearFund()>0) {
				bankAccount.setClear();
				System.out.println("The unclear fund of account "+bankAccount.accountNumber+" now clear");
				System.out.println(bankAccount.toString());
			}
			}
	}
	
}


