package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Thomas Shortt (n8854742)
 *
 */
public class CustomerFactoryTests {
	
	private Customer aCustomer;
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
	
	@Before
	public void setupCustomerFactory() {
		
	}
	
	@Test
	public void testGetCustomer() {
		
	}
}
