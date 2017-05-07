package test;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.BankAccount;
import classes.CurrentAccount;
import classes.Customer;

public class testBankAccount {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		BankAccount account = new CurrentAccount(123111, new Customer("syj", "ningxia", 1995, 3, 12));
		assertEquals(0,(int)account.getBalance());
		account.setBalance(1000);
		account.deposit(1200);
		assertEquals(2200, (int)account.getBalance());
	}
	

}
