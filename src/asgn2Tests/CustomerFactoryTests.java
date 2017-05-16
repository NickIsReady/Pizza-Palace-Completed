package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Thomas Shortt (n8854742)
 *
 */
public class CustomerFactoryTests {
	
	private Customer customerA;
	private Customer customerB;
	private Customer customerC;
	private String codeA = "DVC";
	private String codeB = "DNC";
	private String codeC = "PUC";
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
		
	@Test
	public void testGetCustomerDriverDeliveryCustomer() throws CustomerException {
		assertEquals(customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, locationXA, locationYA), CustomerFactory.getCustomer(codeA, nameA, mobileNumberA, locationXA, locationYA));
	}
	
	@Test
	public void testGetCustomerDroneDeliveryCustomer() throws CustomerException {
		assertEquals(customerB = new DroneDeliveryCustomer(nameB, mobileNumberB, locationXB, locationYB), CustomerFactory.getCustomer(codeB, nameB, mobileNumberB, locationXB, locationYB));
	}
	
	@Test
	public void testGetCustomerPickUpCustomer() throws CustomerException {
		assertEquals(customerC = new PickUpCustomer(nameC, mobileNumberC, locationXC, locationYC), CustomerFactory.getCustomer(codeC, nameC, mobileNumberC, locationXC, locationYC));
	}
	
	@Test (expected = CustomerException.class)
	public void testInvalidGetCustomerInvalidCode() throws CustomerException {
		assertEquals(customerA = new DriverDeliveryCustomer(nameA, mobileNumberA, locationXA, locationYA), CustomerFactory.getCustomer("JVC", nameA, mobileNumberA, locationXA, locationYA));
	}
}
