package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CreditAgency {
	
	private ArrayList<record> list ;
	
	public CreditAgency(){
		readListFromCSV("Files/credit_list.csv");
	}
	
	void readListFromCSV(String fileName){
		list = new ArrayList<record>();
		BufferedReader reader = null;		
			try {
				reader= new BufferedReader(new FileReader(fileName));
				String line = null;  
		        while((line=reader.readLine())!=null){
		        	String item[] = line.split(";");
		        	record r= new record(item[0], Boolean.parseBoolean(item[1]));
		        	list.add(r);
		        }
		        reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
	/**
	 * this function to check whether the user can have the credit card through his name
	 * @param name
	 * @return
	 */
	public boolean ifCredit(String name){
		for(record r :list){
			if(r.getName().equals(name) && r.isStatus()){
				return true;
			}
		}
		return false;
	}
	

}
