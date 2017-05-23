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
	public void invalidCustomerNameEmpty() throws CustomerException {
		customerA = new DriverDeliveryCustomer("", mobileNumberA, locationXA, locationYA);
		assertEquals("", customerA.getName());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerNameWhiteSpaces() throws CustomerException {
		customerB = new DroneDeliveryCustomer("       ", mobileNumberB, locationXB, locationYB);
		assertEquals("       ", customerB.getName());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerNameTooLong() throws CustomerException {
		customerC = new PickUpCustomer("abcdefghijklmnopqrstu", mobileNumberC, locationXC, locationYC);
		assertEquals("abcdefghijklmnopqrstu", customerC.getName());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerMobileNumberEmpty() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, "", locationXA, locationYA);
		assertEquals("", customerA.getMobileNumber());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerMobileNumberFirstNumberOne() throws CustomerException {
		customerB = new DroneDeliveryCustomer(nameB, "1449500145", locationXB, locationYB);
		assertEquals("1449500145", customerB.getMobileNumber());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerMobileNumberLettersInNumber() throws CustomerException {
		customerC = new PickUpCustomer(nameC, "04f601L76o", locationXC, locationYC);
		assertEquals("04f601L76o", customerC.getMobileNumber());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerLocationXPositiveTooHigh() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, 12, locationYA);
		assertEquals(12, customerA.getLocationX());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerLocationXNegativeTooHigh() throws CustomerException {
		customerC = new PickUpCustomer(nameC, mobileNumberC, -13, locationYC);
		assertEquals(-13, customerC.getLocationX());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerLocationYPositiveTooHigh() throws CustomerException {
		customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, locationXA, 19);
		assertEquals(19, customerA.getLocationY());
	}
	
	@Test (expected = CustomerException.class)
	public void invalidCustomerLocationYNegativeTooHigh() throws CustomerException {
		customerB = new DroneDeliveryCustomer(nameB, mobileNumberB, locationXB, -18);
		assertEquals(-18, customerB.getLocationY());
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
	}
	
	@Test
	public void testGetMobileNumber() {
		assertEquals(mobileNumberA, customerA.getMobileNumber());
	}
	
	@Test
	public void testGetCustomerTypeDriverDelivery() {
		assertEquals("Driver Delivery", customerA.getCustomerType());
	}
	
	@Test
	public void testGetCustomerTypeDroneDelivery() {
		assertEquals("Drone Delivery", customerB.getCustomerType());
	}
	
	@Test
	public void testGetCustomerTypePickUp() {
		assertEquals("Pick Up", customerC.getCustomerType());
	}
	
	@Test
	public void testGetLocationXPositive() {
		assertEquals(locationXA, customerA.getLocationX());
	}
	
	@Test
	public void testGetLocationXNegative() {
		assertEquals(locationXC, customerC.getLocationX());
	}
	
	@Test
	public void testGetLocationYPositive() {
		assertEquals(locationYA, customerA.getLocationY());
	}
	
	@Test
	public void testGetLocationYNegative() {
		assertEquals(locationYC, customerC.getLocationY());
	}
	
	@Test
	public void testGetDeliveryDistanceDriverDelivery() {
		assertEquals(11, customerA.getDeliveryDistance(), 0.1);
	}
	
	@Test
	public void testGetDeliveryDistanceDroneDelivery() {
		assertEquals(10.6, customerB.getDeliveryDistance(), 0.1);
	}
	
	@Test
	public void testGetDeliveryDistancePickUp() {
		assertEquals(0, customerC.getDeliveryDistance(), 0.1);
	}
}
