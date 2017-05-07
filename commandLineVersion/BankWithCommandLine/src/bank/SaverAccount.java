package bank;

import java.util.Calendar;
import java.util.Scanner;
/**
 * Saver Account is a kind of bankAccount  which has notice Date and notice Period
 * @author lbw
 *
 */
public class SaverAccount extends BankAccount{
    private Calendar noticeDate;
    private double noticeAmount;
    private int noticePeriod;
    /**
     * Another Constructor for Saver Account 
     * @param accNo
     * @param customer
     * @param noticePeriod
     */
	public SaverAccount(int accNo, Customer customer, int noticePeriod) {
		super(accNo, customer);
		this.noticePeriod = noticePeriod;
		overDraftLimit = 0;
		//noticeNeeded = true;
	}
	/**
	 * Constructor for saverAccount 
	 * @param accNo
	 * @param customer
	 */
	public SaverAccount(int accNo, Customer customer) {
		super(accNo, customer);
		this.noticePeriod = 7;
		overDraftLimit = 0;
		//noticeNeeded = true;
	}
	
	public long getNoticePeriod(){
		return noticePeriod;
	}
	
	public void setNoticePeriod(int noticePeriod){
		this.noticePeriod = noticePeriod;
	}
	/**
	 * set the notice date and notice amount 
	 * @param noticeDate
	 * @param noticeAmount
	 */
	public void setNotice(Calendar noticeDate, double noticeAmount){
		this.noticeDate = noticeDate;
		this.noticeAmount = noticeAmount;
	}
	/**
	 * getter for Notice Date
	 * @return
	 */
	public Calendar getNoticeDate(){
		return noticeDate;
	}
	
	public double getNoticeAmount(){
		return noticeAmount;
	}
	/**
	 * calculate the difference between noticeDate and current date
	 * @param noticeDate
	 * @param noticePeriod
	 * @return
	 */
	public boolean Difference(Calendar noticeDate, int noticePeriod){
		Calendar today = Calendar.getInstance();
		int monthOfToday = today.get(Calendar.MONTH)+1;
		noticeDate.add(noticeDate.DATE, noticePeriod);
		int m2 = noticeDate.get(Calendar.MONTH)+1;
		System.out.println("today : "+today.get(Calendar.YEAR)+" "+monthOfToday+" "+today.get(Calendar.DAY_OF_MONTH)+". The day begins to allow withdraw: "+noticeDate.get(Calendar.YEAR)+" "+m2+" "+noticeDate.get(Calendar.DAY_OF_MONTH));
		if(noticeDate.before(today)){
			return true;
		}else 
			return false;
	}
	
	/**
	 * This function is to check the notice date and notice amount 
	 */
	protected boolean CheckDate(double amount) {
		Scanner s3 = new Scanner(System.in);
		System.out.println("input your notice date and your notice amount: e.g. 2017 4 20 100");
		int year = 1899;
        int month = 0;
        int date = 0;
        int amountToWithdraw = 0;
        do{
        	try{
                year = Integer.parseInt(s3.next());
                month = Integer.parseInt(s3.next());
                date = Integer.parseInt(s3.next());
                amountToWithdraw = Integer.parseInt(s3.next());
        	if(year>2017 || year<1900 || month>12 || month<1 ||date>31 || date<1){
        		System.out.println("error input!");
        	}
        }catch(Exception e){
        	year = 1899;
        	System.out.println("error input!");
        }
	   }while(year>2017 || year<1900);
        Calendar calendarInstance = Calendar.getInstance();
        calendarInstance.set(year,month-1,date);
        setNotice(calendarInstance,amountToWithdraw);
		boolean allowed = false;
		if(!Difference(noticeDate,noticePeriod)){
			System.out.println("Fail to withdraw! Today is not your notice day to withdraw");
		}
		else if(noticeAmount < amount){
			System.out.println("Fail to withdraw! Your withdraw amount is larger than your notice amount.");
		}
		else if (this.getBalance() - amount >= -overDraftLimit) {
			allowed = true;
		} else {
			System.out.println("Withdraw " + amount
					+ " unsuccessfull. Do not have enough available funds.");
		}
		return allowed;
	}
	

}
