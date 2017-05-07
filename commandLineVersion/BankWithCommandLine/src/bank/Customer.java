package bank;

import java.util.Calendar;

/**
 * Cusotmer class for storing the customer information
 * 
 * @author lbw
 *
 */
public class Customer {
	private String CustomerName;
	private String CustomerAdress;
	private Calendar BirthDateOfCustomer;
	private boolean creditStatusOfCustomer;

	/**
	 * Constructor for the customer for new a customer
	 * 
	 * @param name
	 * @param address
	 * @param dateOfBirth
	 */
	public Customer(String name, String address, Calendar dateOfBirth) {
		this.CustomerName = name;
		this.CustomerAdress = address;
		this.BirthDateOfCustomer = dateOfBirth;
		creditStatusOfCustomer = false;
	}

	/**
	 * getter for the customer Name
	 * 
	 * @return
	 */
	public String getCustomerName() {
		return CustomerName;
	}

	/**
	 * setter for customer Name
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	/**
	 * getter for Customer Address
	 * 
	 * @return
	 */
	public String getCustomerAdress() {
		return CustomerAdress;
	}

	/**
	 * setter for Customer Address
	 * 
	 * @param customerAdress
	 */
	public void setCustomerAdress(String customerAdress) {
		CustomerAdress = customerAdress;
	}

	public Calendar getBirthDateOfCustomer() {
		return BirthDateOfCustomer;
	}

	public void setBirthDateOfCustomer(Calendar birthDateOfCustomer) {
		BirthDateOfCustomer = birthDateOfCustomer;
	}

	public boolean isCreditStatusOfCustomer() {
		return creditStatusOfCustomer;
	}

	public void setCreditStatusOfCustomer(boolean creditStatusOfCustomer) {
		this.creditStatusOfCustomer = creditStatusOfCustomer;
	}

}
