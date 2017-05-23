package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Thomas Shortt (n8854742)
 */
public class RestaurantCustomerTests {
	
	private PizzaRestaurant restaurant;
	private String file = "logs/20170101.txt";
	private String otherFileA = "logs/20170102.txt";
	private String otherFileB = "logs/20170103.txt";
	private String invalidFile = "logs/InvalidCustomerLog.txt";
	
	@Before
	public void setupRestaurantCustomer() {
		restaurant = new PizzaRestaurant();
	}
	
	@Test (expected = CustomerException.class)
	public void testInvalidProcessLog() throws CustomerException, PizzaException, LogHandlerException {
		assertEquals(true, restaurant.processLog(invalidFile));
	}
	
	@Test
	public void testProcessLogFirstFile() throws CustomerException, PizzaException, LogHandlerException {
		assertEquals(true, restaurant.processLog(file));
	}
	
	@Test
	public void testProcessLogSecondFile() throws CustomerException, PizzaException, LogHandlerException {
		assertEquals(true, restaurant.processLog(otherFileA));
	}
	
	@Test
	public void testProcessLogThirdFile() throws CustomerException, PizzaException, LogHandlerException {
		assertEquals(true, restaurant.processLog(otherFileB));
	}
	
	@Test
	public void testGetCustomerByIndexDriverDeliveryCustomer() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog(file);
		Customer customer = new DriverDeliveryCustomer("Casey Jones", "0123456789", 5, 5);
		assertEquals(customer, restaurant.getCustomerByIndex(0));
	}
	
	@Test
	public void testGetCustomerByIndexDroneDeliveryCustomer() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog(file);
		Customer customer = new DroneDeliveryCustomer("April O'Neal", "0987654321", 3, 4);
		assertEquals(customer, restaurant.getCustomerByIndex(1));
	}
	
	@Test
	public void testGetCustomerByIndexPickUpCustomer() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog(file);
		Customer customer = new PickUpCustomer("Oroku Saki", "0111222333", 0, 0);
		assertEquals(customer, restaurant.getCustomerByIndex(2));
	}
	
	@Test
	public void testGetNumCustomerOrders() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog(file);
		assertEquals(3, restaurant.getNumCustomerOrders());
	}

	@Test
	public void testGetTotalDeliveryDistance() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog(file);
		double customerADistance = restaurant.getCustomerByIndex(0).getDeliveryDistance();
		double customerBDistance = restaurant.getCustomerByIndex(1).getDeliveryDistance();
		double customerCDistance = restaurant.getCustomerByIndex(2).getDeliveryDistance();
		double total = customerADistance + customerBDistance + customerCDistance;
		assertEquals(total, restaurant.getTotalDeliveryDistance(), 0.1);
	}
	
	@Test
	public void testResetDetailsNumCustomerOrders() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog(file);
		restaurant.resetDetails();
		assertEquals(0, restaurant.getNumCustomerOrders());
	}
	
	@Test
	public void testResetDetailsTotalDeliveryDistance() throws CustomerException, PizzaException, LogHandlerException {
		restaurant.processLog(file);
		restaurant.resetDetails();
		assertEquals(0, restaurant.getTotalDeliveryDistance(), 0.1);
	}
}
