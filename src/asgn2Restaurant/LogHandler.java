package asgn2Restaurant;


import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Thomas Shortt (n8854742) and Nicholas Constantine (n9171550)
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();
		try {
			BufferedReader LogToRead = new BufferedReader(new FileReader(filename));
			if (!LogToRead.ready()){
				LogToRead.close();
				throw new LogHandlerException("Log file is empty!");
			}
			String line;
			while((line = LogToRead.readLine()) != null) {
				CustomerList.add(createCustomer(line));
			}
			LogToRead.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
        	e.printStackTrace();
		}
		return CustomerList;
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		try {
			BufferedReader LogToRead = new BufferedReader(new FileReader(filename));
			if (!LogToRead.ready()) {
				LogToRead.close();
				throw new LogHandlerException("Log file is empty!");
			}
			String line;
			while((line = LogToRead.readLine()) != null) {
				pizzaList.add(createPizza(line));
			}
			LogToRead.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
        	e.printStackTrace();
		}
		return pizzaList;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		String[] lineArray = line.split(",");
		if(lineArray.length != 9) {
			throw new LogHandlerException("Missing elements in log file.");
		} 
		Customer temp = CustomerFactory.getCustomer(lineArray[4], lineArray[2], lineArray[3], Integer.parseInt(lineArray[5]), Integer.parseInt(lineArray[6]));
		return temp;
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		String[] lineArray = line.split(",");
		if(lineArray.length != 9) {
			throw new LogHandlerException("Missing elements in log file.");
		} 
		Pizza pizza = PizzaFactory.getPizza(lineArray[7], Integer.parseInt(lineArray[8]), LocalTime.parse(lineArray[0]), LocalTime.parse(lineArray[1]));
		return pizza;
	}

}
