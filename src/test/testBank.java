package test;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Bank;

public class testBank {

	@Test
	public void test() {
		Bank bank = new Bank();
		int accountNum = bank.getActiveList().size();
		assertEquals(5, accountNum);
	}

}
