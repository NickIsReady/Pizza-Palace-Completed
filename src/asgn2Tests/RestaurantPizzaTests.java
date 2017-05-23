package asgn2Tests;


import java.time.LocalTime;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Restaurant.PizzaRestaurant;
/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Nicholas Constantine (n9171550)
 *
 */
public class RestaurantPizzaTests {
	
	private PizzaRestaurant RestaurantA;
	
	Pizza FirstPizza;
	Pizza SecondPizza;
	Pizza ThirdPizza;
	
	@Before
	public void InitialisePizzaRestuarant() throws PizzaException{
		RestaurantA = new PizzaRestaurant();
		
		FirstPizza = new VegetarianPizza(2, LocalTime.of(19, 00), LocalTime.of(19, 20));
		SecondPizza = new MargheritaPizza(1, LocalTime.of(20, 00), LocalTime.of(20, 25));
		ThirdPizza = new MeatLoversPizza(3, LocalTime.of(21, 00), LocalTime.of(21, 35));
	}
	
	//Process log files
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
	@Test (expected = PizzaException.class)
	public void TestProcessLogInvalid() throws PizzaException, LogHandlerException, CustomerException{
		assertTrue(RestaurantA.processLog("logs/InvalidLog.txt"));
	}
	
	@Test 
	public void GetPizzaByIndexZeroLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		assertEquals(RestaurantA.getPizzaByIndex(0), FirstPizza);
	}
	
	@Test 
	public void GetPizzaByIndexOneLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		assertEquals(RestaurantA.getPizzaByIndex(1), SecondPizza);
	}
	
	@Test 
	public void GetPizzaByIndexTwoLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		assertEquals(RestaurantA.getPizzaByIndex(2), ThirdPizza);
	}
	
	//Invalid index tests
	@Test(expected = PizzaException.class)
	public void IndexOutOfRangeNegative() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		@SuppressWarnings("unused")
		Pizza InvalidPizza = RestaurantA.getPizzaByIndex(-1);
	}
	
	@Test(expected = PizzaException.class)
	public void IndexOutOfRangeAboveMax() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		@SuppressWarnings("unused")
		Pizza InvalidPizza = RestaurantA.getPizzaByIndex(5);
	}
	
	//Get Number of Pizza Orders
	@Test 
	public void GetNumOfPizzaOrdersLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		assertEquals(RestaurantA.getNumPizzaOrders(), 3);
	}
	
	@Test 
	public void GetNumOfPizzaOrdersLogFileTwo() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170102.txt");
		assertEquals(RestaurantA.getNumPizzaOrders(), 10);
	}
	
	@Test 
	public void GetNumOfPizzaOrdersLogFileThree() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170103.txt");
		assertEquals(RestaurantA.getNumPizzaOrders(), 100);
	}
	
	//GetTotalProfit
	@Test 
	public void GetTotalProfitLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		RestaurantA.processLog("logs/20170101.txt");
		double FirstCustomerProfit = RestaurantA.getPizzaByIndex(0).getOrderProfit();
		double SecondCustomerProfit = RestaurantA.getPizzaByIndex(1).getOrderProfit();
		double ThirdCustomerProfit = RestaurantA.getPizzaByIndex(2).getOrderProfit();
		double TotalProfit = FirstCustomerProfit + SecondCustomerProfit + ThirdCustomerProfit;
		assertEquals(RestaurantA.getTotalProfit(),TotalProfit,0);
	}
	
	
}
