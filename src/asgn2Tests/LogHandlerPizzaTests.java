package asgn2Tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Restaurant.PizzaRestaurant;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	
	//Process log files
	@Test
	public void TestProcessLogOne() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> PizzaTest = LogHandler.populatePizzaDataset("logs/20170101.txt");
	}
	
	@Test
	public void TestProcessLogTwo() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> PizzaTest = LogHandler.populatePizzaDataset("logs/20170102.txt");
	}
	
	@Test
	public void TestProcessLogThree() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> PizzaTest = LogHandler.populatePizzaDataset("logs/20170103.txt");
	}
	
	@Test
	public void CreatePizzaTest() throws IOException, PizzaException, LogHandlerException{
		BufferedReader LogToRead = new BufferedReader(new FileReader("logs/20170101.txt"));
		String line;
		
		line = LogToRead.readLine();
		Pizza FirstPizza = new VegetarianPizza(2, LocalTime.of(19, 00), LocalTime.of(19, 20));
		assertEquals(LogHandler.createPizza(line), FirstPizza);
		
		line = LogToRead.readLine();
		Pizza SecondPizza = new MargheritaPizza(1, LocalTime.of(20, 00), LocalTime.of(20, 25));
		assertEquals(LogHandler.createPizza(line), SecondPizza);
		
		line = LogToRead.readLine();
		Pizza ThirdPizza = new MeatLoversPizza(3, LocalTime.of(21, 00), LocalTime.of(21, 35));
		assertEquals(LogHandler.createPizza(line), ThirdPizza);

	}
	
	
}
