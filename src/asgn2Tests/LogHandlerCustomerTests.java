package asgn2Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Thomas Shortt (n8854742)
 */
public class LogHandlerCustomerTests {
	
	private String file = "logs/20170101.txt";
	private Customer customerA;
	private Customer customerB;
	private Customer customerC;
	private ArrayList<Customer> customerList;
	
	@Before
	public void setupCustomers() throws CustomerException {
		customerA = new DriverDeliveryCustomer("Casey Jones", "0123456789", 5, 5);
		customerB = new DroneDeliveryCustomer("April O'Neal", "0987654321", 3, 4);
		customerC = new PickUpCustomer("Oroku Saki", "0111222333", 0, 0);
		customerList = new ArrayList<Customer>();
	}
	
	@Test
	public void testPopulateCustomerDataset() throws CustomerException, LogHandlerException {
		customerList.add(customerA);
		customerList.add(customerB);
		customerList.add(customerC);
		assertEquals(customerList, LogHandler.populateCustomerDataset(file));
	}
	
	@Test
	public void testCreateCustomerDriverDeliveryCustomer() throws CustomerException, LogHandlerException, IOException {
		BufferedReader LogToRead = new BufferedReader(new FileReader(file));
		String line;
		line = LogToRead.readLine();
		assertEquals(customerA, LogHandler.createCustomer(line));
	}
	
	@Test
	public void testCreateCustomerDroneDeliveryCustomer() throws CustomerException, LogHandlerException, IOException {
		BufferedReader LogToRead = new BufferedReader(new FileReader(file));
		String line;
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		assertEquals(customerB, LogHandler.createCustomer(line));
	}
	
	@Test
	public void testCreateCustomerPickUpCustomer() throws CustomerException, LogHandlerException, IOException {
		BufferedReader LogToRead = new BufferedReader(new FileReader(file));
		String line;
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		assertEquals(customerC, LogHandler.createCustomer(line));
	}
}
