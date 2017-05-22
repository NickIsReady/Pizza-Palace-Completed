package asgn2Tests;


import java.time.LocalTime;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
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
	//Invalid Log files
	@Test(expected = CustomerException.class)
	public void TestProcessLogInvalid() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/InvalidLog.txt");
	}
	
	
	
	
}
