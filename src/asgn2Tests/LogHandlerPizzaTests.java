package asgn2Tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Nicholas Constantine (n9171550)
* 
*/
public class LogHandlerPizzaTests {
	
	String line = null;
	BufferedReader LogToRead;
	
	Pizza FirstPizza;
	Pizza SecondPizza;
	Pizza ThirdPizza;
	
	@Before
	public void setupLogFile() throws FileNotFoundException, PizzaException{
		LogToRead = new BufferedReader(new FileReader("logs/20170101.txt"));
		
		FirstPizza = new VegetarianPizza(2, LocalTime.of(19, 00), LocalTime.of(19, 20));
		SecondPizza = new MargheritaPizza(1, LocalTime.of(20, 00), LocalTime.of(20, 25));
		ThirdPizza = new MeatLoversPizza(3, LocalTime.of(21, 00), LocalTime.of(21, 35));
	}
	
	//Process log files
	@Test
	public void TestProcessLogOne() throws PizzaException, LogHandlerException{
		@SuppressWarnings("unused")
		ArrayList<Pizza> PizzaTest = LogHandler.populatePizzaDataset("logs/20170101.txt");
	}
	
	@Test
	public void TestProcessLogTwo() throws PizzaException, LogHandlerException{
		@SuppressWarnings("unused")
		ArrayList<Pizza> PizzaTest = LogHandler.populatePizzaDataset("logs/20170102.txt");
	}
	
	@Test
	public void TestProcessLogThree() throws PizzaException, LogHandlerException{
		@SuppressWarnings("unused")
		ArrayList<Pizza> PizzaTest = LogHandler.populatePizzaDataset("logs/20170103.txt");
	}
	
	@Test
	public void CreateFirstPizzaTest() throws IOException, PizzaException, LogHandlerException{
		line = LogToRead.readLine();
		assertEquals(LogHandler.createPizza(line), FirstPizza);
	}
	@Test
	public void CreateSecondPizzaTest() throws IOException, PizzaException, LogHandlerException{
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		assertEquals(LogHandler.createPizza(line), SecondPizza);
	}
	@Test
	public void CreateThirdPizzaTest() throws IOException, PizzaException, LogHandlerException{
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		assertEquals(LogHandler.createPizza(line), ThirdPizza);

	}
	
	//Invalid Log files
	@Test (expected = LogHandlerException.class)
	public void TestProcessLogInvalid() throws PizzaException, LogHandlerException{
		@SuppressWarnings("unused")
		ArrayList<Pizza> PizzaTest = LogHandler.populatePizzaDataset("logs/InvalidEmptyLog.txt");
	}
	
	@Test (expected = LogHandlerException.class)
	public void TestCreatePizzaInvalid() throws IOException, PizzaException, LogHandlerException{
		LogToRead = new BufferedReader(new FileReader("logs/InvalidPizzaShortenedLog.txt"));
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		line = LogToRead.readLine();
		assertEquals(LogHandler.createPizza(line), ThirdPizza);

	}
	
}
