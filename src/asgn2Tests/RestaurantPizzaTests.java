package asgn2Tests;


import java.time.LocalTime;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Restaurant.PizzaRestaurant;
/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	
	private PizzaRestaurant RestaurantA;
	
	@Before
	public void InitialisePizzaRestuarant() throws PizzaException{
		RestaurantA = new PizzaRestaurant();
	}
	

	@Test
	public void TestProcessLogOne() throws CustomerException, PizzaException, LogHandlerException{
		assertTrue(RestaurantA.processLog("logs/20170101.txt"));
	}
	@Test
	public void TestProcessLogTwo() throws CustomerException, PizzaException, LogHandlerException{
		assertTrue(RestaurantA.processLog("logs/20170102.txt"));
	}
	@Test
	public void TestProcessLogThree() throws CustomerException, PizzaException, LogHandlerException{
		assertTrue(RestaurantA.processLog("logs/20170103.txt"));
	}
	
	/*//Invalid Log files
	@Test(expected = CustomerException.class)
	public void TestProcessLogInvalid() throws CustomerException, PizzaException, LogHandlerException{
		assertTrue(RestaurantA.processLog("logs/InvalidLog.txt"));
	}
	*/
	@Test 
	public void GetCustomerByIndexLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		
		Customer FirstCustomer = new DriverDeliveryCustomer("Casey Jones", "0123456789", 5, 5);
		assertEquals(RestaurantA.getCustomerByIndex(0), FirstCustomer);
		
		Customer SecondCustomer = new DroneDeliveryCustomer("April O'Neal", "0987654321", 3, 4);
		assertEquals(RestaurantA.getCustomerByIndex(1), SecondCustomer);
		
		Customer ThirdCustomer = new PickUpCustomer("Oroku Saki", "0111222333", 0, 0);
		assertEquals(RestaurantA.getCustomerByIndex(2), ThirdCustomer);
	}
	
	//Get Number of Pizza Orders
	@Test 
	public void GetNumOfPizzaOrdersLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		
	}
	
	@Test 
	public void GetNumOfPizzaOrdersLogFileTwo() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170102.txt");
		
	}
	
	@Test 
	public void GetNumOfPizzaOrdersLogFileThree() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170103.txt");
		
	}
	
}
