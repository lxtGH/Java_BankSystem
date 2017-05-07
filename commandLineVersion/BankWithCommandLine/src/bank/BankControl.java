package bank;

import java.util.Scanner;
import java.util.Calendar;
/**
 * this is Main program of the software
 * @author lbw
 *
 */
public class BankControl {
	static int acc = 10000;
	static Bank myBank = new Bank();
	static Customer customer;
	public static void main(String[] args) {
	     System.out.println("Welcome to our bank!");
		 System.out.println("First you need to open a bank account! ");
		 getCustomerInformation(); 
		 detailedOperation();
		 
	}
	
	public static BankAccount identifyTheAccount(){
		BankAccount bankAccount =null;
		Scanner inputNameScanner = new Scanner(System.in);
		System.out.println("Please enter your account number");
		do{
        	try{
               bankAccount = myBank.getBankAccount(Integer.parseInt(inputNameScanner.next()));
               if(bankAccount == null){
            	   System.out.println("error account number!Enter again:"); 
               }
        }catch(Exception e){
            bankAccount = null;
        	System.out.println("error account number! Enter again:");
        }
	}while(bankAccount==null);
		return bankAccount;
	}
	/**
	 * this function implements all the operation that the account can do
	 */
	public static void detailedOperation() {
		BankAccount bankAccount = null;
		System.out.println("What to do next?");
		int choice = 0;
		Scanner scannerForMainOperation = new Scanner(System.in);
		System.out.println("1.Open another account; 2.Deposit funds; 3.Withdraw funds; 4.Suspend account; 5.Close account; 6.leave:");
		 do{
	        	try{
	            
	        	choice = Integer.parseInt(scannerForMainOperation.next());
	        	if(choice>6 || choice<1){
	        		System.out.println("Sorry, you must enter 1---6");
	        	}
	        }catch(Exception e){
	        	choice = 0;
	        	System.out.println("Sorry, you must enter 1----6");
	        }
		    }while(choice>6 || choice<1);
		if(choice == 1){
			getCustomerInformation();
			detailedOperation();
		}else if(choice == 2){
			System.out.println("Deposit funds");
	        bankAccount = identifyTheAccount();
			int amount =-1;
			int type = 0;
			Scanner depositTypeScanner = new Scanner(System.in);
			System.out.println("Please enter your deposit amount and deposit type(1.Cash; 2.Cheque)");
			do{
	        	try{
	               amount = Integer.parseInt(depositTypeScanner.next());
	               type = Integer.parseInt(depositTypeScanner.next());
	               if(amount <0 || type<1 || type>2){
	            	   amount = -1;
	            	   System.out.println("error input!Enter again:"); 
	               }
	        }catch(Exception e){
	            amount = -1;
	        	System.out.println("error input! Enter again:");
	        }
		}while(amount<0);
			bankAccount.deposit(amount, type);
			System.out.println(bankAccount.toString());
			detailedOperation();
		}else if (choice == 3){
			System.out.println("Withdraw funds");
	        bankAccount = identifyTheAccount();
	        int amount =-1;
			Scanner withdrwaScanner = new Scanner(System.in);
			System.out.println("Please enter your withdraw amount:");
			do{
	        	try{
	               amount = Integer.parseInt(withdrwaScanner.next());
	               if(amount <0 ){
	            	   amount = -1;
	            	   System.out.println("error input!Enter again:"); 
	               }
	        }catch(Exception e){
	            amount = -1;
	        	System.out.println("error input! Enter again:");
	        }
		}while(amount<0);
			bankAccount.withdraw(amount);
			System.out.println(bankAccount.toString());
			detailedOperation();
		}else if (choice == 4){
			System.out.println("Account suspend");
	        bankAccount = identifyTheAccount();
	        bankAccount.setSuspended(true);
	        detailedOperation();
		}else if (choice == 5){
			System.out.println("Account close");
	        bankAccount = identifyTheAccount();
	       if(bankAccount.close())
	        myBank.closeAccount(bankAccount);
	       detailedOperation();
		}else{
			myBank.clearAllAccountFund();
			System.out.println("Good Bye~");
		}
		
		}
	/**
	 * this function is to get the detailed customer information
	 */
	public static void getCustomerInformation(){
       Scanner nameScanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = nameScanner.nextLine();
        Scanner addressScanner = new Scanner(System.in);
        System.out.println("Please enter your address:");
        String address = addressScanner.nextLine();
        int year = 1899;
        int month = 0;
        int date = 0;
        Scanner birthScanner = new Scanner(System.in);
        System.out.println("Please enter your date of birth, e.g.(2000 1 1) :");
     
        do{
        	try{
                year = Integer.parseInt(birthScanner.next());
                month = Integer.parseInt(birthScanner.next());
                date = Integer.parseInt(birthScanner.next());
        	if(year>2017 || year<1900 || month>12 || month<1 ||date>31 || date<1){
        		System.out.println("error DoB!");
        	}
        }catch(Exception e){
        	year = 1899;
        	System.out.println("error DoB!");
        }
	   }while(year>2017 || year<1900);
        
        Calendar DoB = Calendar.getInstance();
        DoB.set(year,month,date);
        customer = new Customer(name, address, DoB);
       int type =0;
       Calendar today = Calendar.getInstance();
        Scanner s4 = new Scanner(System.in);
        System.out.println("Select a type account: 1.Current Account; 2.Junior Account; 3.Saver Account. Enter a number");
        do{
        	try{
            
        	type = Integer.parseInt(s4.next());
        	if(type>3 || type<1){
        		System.out.println("Sorry, you are only allowed to enter 1,2 or 3");
        	}else if ((today.get(1)-year >=16)&&(type==2)){
        		type = 0;
        		System.out.println("Sorry.You are older than 16! Can't open a junior account.");
        	}
        }catch(Exception e){
        	type = 0;
        	System.out.println("Sorry, you are only allowed to enter 1, 2 or 3");
        }
	    }while(type>3 || type<1);
        System.out.println("Your account has been sucessfully opened!");
  
        if(type == 1){
        	CurrentAccount ca = new CurrentAccount(acc,customer);
        	acc++;
        	myBank.openAccount(ca);
        	System.out.println(ca.toString());
        }
        else if(type == 2){
        		JuniorAccount ja = new JuniorAccount(acc,customer);
        		acc++;
        		myBank.openAccount(ja);
        		System.out.println(ja.toString());
        }else{
        	SaverAccount sa = new SaverAccount(acc,customer);
        	acc++;
        	myBank.openAccount(sa);
        	System.out.println(sa.toString());
        }
        
	}

}


