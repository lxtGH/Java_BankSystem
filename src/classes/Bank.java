package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> ActiveList; 
	
	/**
	 * constructor for bank
	 */
	public Bank(){
		readActiveListFromCSV("Files/account.csv");
		//System.out.println(this.getActiveList().size());
	}
	/**
	 * this function is to read the information from the files
	 * @param fileName
	 */
	public void readActiveListFromCSV(String fileName){
		ActiveList = new ArrayList<BankAccount>();
		BufferedReader reader = null;		
			try {
				reader= new BufferedReader(new FileReader(fileName));
		        String line = null;  
		        while((line=reader.readLine())!=null){
		        	String item[] = line.split(";");
		        	int accountNum = Integer.parseInt(item[0]);
		        	int PIN = Integer.parseInt(item[1]);
		        	String name = item[2];
		        	String temp[] = item[3].split("-");
		        	int year = Integer.parseInt(temp[0]);
		        	int month  =  Integer.parseInt(temp[1]);
		        	int day = Integer.parseInt(temp[2]);
		        	String address= item[4];
		        	double balance = Double.parseDouble(item[5]);
		        	int type = Integer.parseInt(item[6]);
		        	boolean isSuspend = Boolean.parseBoolean(item[7]);
		        	Customer customer = new Customer(name, address, year, month, day);
		        	BankAccount account = null;
		        	
		        	if (type==1){
		        		account = new CurrentAccount(accountNum, customer,balance,PIN);
		        	}else if (type ==2){
		        		 account = new SaverAccount(accountNum, customer);
		        	}else if (type==3){
		        		 account = new JuniorAccount(accountNum, customer);
		        	}
		        	account.setSuspended(isSuspend);
		        	ActiveList.add(account);		        			
		        }   
		    	reader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//ActiveList.add();
	}

	/**
	 * this function is to write the information of all account and customer to the file
	 * @param fileName
	 */
	public void writeActiveListToCSV(String fileName){
		BufferedWriter bufferedWriter = null;
		
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(fileName));
			int len = ActiveList.size();
			int count = 0;
			for (BankAccount bankAccount :ActiveList){
				if(!bankAccount.isActive())
					continue;
				String line = bankAccount.toFile();
				bufferedWriter.write(line);
				count++;
				if(count<len)
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * this function is to judge whether the bank has this account number
	 * @param num
	 * @return
	 */
	public boolean isExist(int num){
		for (BankAccount bankAccount:ActiveList){
			if(num == bankAccount.getAccNo()){
				return true;
			}
		}
		return false;
	}
	/**
	 * this function is to judge if account number match its PIN codes
	 * @param acc_num
	 * @param pin
	 * @return
	 */
	public boolean isMatch(int acc_num, int pin){
		for (BankAccount bankAccount:ActiveList){
			if(bankAccount.getAccNo()==acc_num && bankAccount.getPin()==pin){
				return true;
			}
		}
		return false;
	}
	/**
	 * this function is to get bank account object by providing the account number
	 * @param acc_num
	 * @return
	 */
	public BankAccount getAccountByNum(int acc_num){
		BankAccount account =null;
		for (BankAccount bankAccount:ActiveList){
			if(acc_num == bankAccount.getAccNo()){
				account = bankAccount;
				return bankAccount;
			}
		}
		return account;
	}
	
	/**
	 * this function is to set all the uncleared money
	 */
	public void setUnclearedMoney(){
		for (BankAccount account : ActiveList){
			account.depositWithUnclearedAmount();
		}
	}
	
	public ArrayList<BankAccount> getActiveList() {
		return ActiveList;
	}
	
	public void setActiveList(ArrayList<BankAccount> activeList) {
		ActiveList = activeList;
	}
	
	/**
	 * this for the reader's function
	 * @param args
	 */
	public static void main(String[] args) {
		 Bank bank = new Bank();
		 bank.writeActiveListToCSV("Files/account.csv");
	}

}
