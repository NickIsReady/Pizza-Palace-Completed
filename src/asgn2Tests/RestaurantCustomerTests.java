package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	
	@Before
	public void setupRestaurantCustomer() {
		restaurant = new PizzaRestaurant();
	}
	
	@Test
	public void testProcessLog() throws CustomerException, PizzaException, LogHandlerException {
		assertEquals(true, restaurant.processLog("logs/20170101.txt"));
	}
	
	@Test
	public void testGetCustomerByIndex() {
		
	}
	
	@Test
	public void testGetNumCustomerOrders() {
		
	}
	
	@Test
	public void testGetTotalDeliveryDistance() {
		
	}
	
	@Test
	public void testResetDetails() {
		
	}
}
