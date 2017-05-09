package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Thomas Shortt (n8854742)
 * 
 *
 */
public class CustomerTests {
	
	private Customer customerA;
	private Customer customerB;
	private Customer customerC;
	private String nameA = "Jane";
	private String nameB = "Eric";
	private String nameC = "David";
	private String mobileNumberA = "0441555000";
	private String mobileNumberB = "0449500145";
	private String mobileNumberC = "0446011760";
	private int locationXA = 2;
	private int locationXB = 7;
	private int locationXC = 3;
	private int locationYA = 9;
	private int locationYB = 8;
	private int locationYC = 3;
	private String typeA;
	private String typeB;
	private String typeC;
	
	@Before
	public void setupCustomer() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, locationXA, locationYA);
		customerB = new DroneDeliveryCustomer(nameB, mobileNumberB, locationXB, locationYB);
		customerC = new PickUpCustomer(nameC, mobileNumberC, locationXC, locationYC);
	}
	
	@Test
	public void testGetName() {
		assertEquals(nameA, customerA.getName());
		assertEquals(nameB, customerB.getName());
		assertEquals(nameC, customerC.getName());
	}
	
	@Test
	public void testGetMobileNumber() {
		
	}
	
	@Test
	public void testGetCustomerType() {
		
	}
	
	@Test
	public void testGetLocationX() {
		
	}
	
	@Test
	public void testGetLocationY() {
		
	}
	
	@Test
	public void testGetDeliveryDistance() {
		
	}
}
