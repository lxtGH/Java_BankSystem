package classes;

public class Customer {
	private String name;
	private String address;
	private int Birth_year,Birth_month,Birth_day;
	
	public Customer(String name, String address, int birth_year, int birth_month, int birth_day) {
		this.name = name;
		this.address = address;
		Birth_year = birth_year;
		Birth_month = birth_month;
		Birth_day = birth_day;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBirth_year() {
		return Birth_year;
	}
	public void setBirth_year(int birth_year) {
		Birth_year = birth_year;
	}
	public int getBirth_month() {
		return Birth_month;
	}
	public void setBirth_month(int birth_month) {
		Birth_month = birth_month;
	}
	public int getBirth_day() {
		return Birth_day;
	}
	public void setBirth_day(int birth_day) {
		Birth_day = birth_day;
	}
}
