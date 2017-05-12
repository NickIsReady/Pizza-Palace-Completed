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
	private int locationXC = -3;
	private int locationYA = 9;
	private int locationYB = -8;
	private int locationYC = -3;
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerName() throws CustomerException {
		customerA = new DriverDeliveryCustomer("", mobileNumberA, locationXA, locationYA);
		customerB = new DroneDeliveryCustomer("       ", mobileNumberB, locationXB, locationYB);
		customerC = new PickUpCustomer("abcdefghijklmnopqrstu", mobileNumberC, locationXC, locationYC);
		assertEquals("", customerA.getName());
		assertEquals("       ", customerB.getName());
		assertEquals("abcdefghijklmnopqrstu", customerC.getName());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerMobileNumber() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, "", locationXA, locationYA);
		customerB = new DroneDeliveryCustomer(nameB, "1449500145", locationXB, locationYB);
		customerC = new PickUpCustomer(nameC, "04f601L76o", locationXC, locationYC);
		assertEquals("", customerA.getMobileNumber());
		assertEquals("1449500145", customerB.getMobileNumber());
		assertEquals("04f601L76o", customerC.getMobileNumber());
		
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerLocationX() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, 12, locationYA);
		customerB = new DroneDeliveryCustomer(nameB, mobileNumberB, 17, locationYB);
		customerC = new PickUpCustomer(nameC, mobileNumberC, -13, locationYC);
		assertEquals(12, customerA.getLocationX());
		assertEquals(17, customerB.getLocationX());
		assertEquals(-13, customerC.getLocationX());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerLocationY() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, locationXA, 19);
		customerB = new DroneDeliveryCustomer(nameB, mobileNumberB, locationXB, -18);
		customerC = new PickUpCustomer(nameC, mobileNumberC, locationXC, -13);
		assertEquals(19, customerA.getLocationY());
		assertEquals(-18, customerB.getLocationY());
		assertEquals(-13, customerC.getLocationY());
		
	}
	
	/*@Test (expected = CustomerException.class)
	public void invalidCustomerType() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, locationXA, locationYA);
		customerB = new DroneDeliveryCustomer(nameB, mobileNumberB, locationXB, locationYB);
		customerC = new PickUpCustomer(nameC, mobileNumberC, locationXC, locationYC);
		assertEquals("", customerA.getCustomerType());
		assertEquals("", customerB.getCustomerType());
		assertEquals("", customerC.getCustomerType());
	}*/
	
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
		assertEquals(mobileNumberA, customerA.getMobileNumber());
		assertEquals(mobileNumberB, customerB.getMobileNumber());
		assertEquals(mobileNumberC, customerC.getMobileNumber());
	}
	
	@Test
	public void testGetCustomerType() {
		assertEquals("Driver Delivery", customerA.getCustomerType());
		assertEquals("Drone Delivery", customerB.getCustomerType());
		assertEquals("Pick Up", customerC.getCustomerType());
	}
	
	@Test
	public void testGetLocationX() {
		assertEquals(locationXA, customerA.getLocationX());
		assertEquals(locationXB, customerB.getLocationX());
		assertEquals(locationXC, customerC.getLocationX());
	}
	
	@Test
	public void testGetLocationY() {
		assertEquals(locationYA, customerA.getLocationY());
		assertEquals(locationYB, customerB.getLocationY());
		assertEquals(locationYC, customerC.getLocationY());
	}
	
	@Test
	public void testGetDeliveryDistance() {
		assertEquals(0, customerC.getDeliveryDistance(), 0.1);
	}
}
