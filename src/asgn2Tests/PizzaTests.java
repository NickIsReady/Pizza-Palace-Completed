package asgn2Tests;

import java.time.LocalTime;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	
	//asgn2Pizzas.MargheritaPizza, 
	
	//asgn2Pizzas.VegetarianPizza, 
	
	//asgn2Pizzas.MeatLoversPizza classes. 
	
	//asgn2Pizzas.MeatLoversPizza
	
	private int quantityA = 3;
	private int quantityB = 2;
	private int quantityC = 8;
	private LocalTime orderTimeA = LocalTime.of(19, 10);
	private LocalTime orderTimeB = LocalTime.of(20, 19);;
	private LocalTime orderTimeC = LocalTime.of(22, 05);;
	private LocalTime deliveryTimeA = LocalTime.of(19, 25);;
	private LocalTime deliveryTimeB = LocalTime.of(20, 30);;
	private LocalTime deliveryTimeC = LocalTime.of(22, 20);;
	private String typeA = "Margherita";
	private String typeB = "Vegetarian";
	private String typeC = "Meat Lovers";
	private double priceA = 8.00;
	private double priceB = 10.00;
	private double priceC = 12.00;
	private double costA;
	private double costB;
	private double costC;
	private Pizza PizzaA;
	private Pizza PizzaB;
	private Pizza PizzaC;
	
	@Before
	public void InitialisePizzas() throws PizzaException{
		PizzaA = new MargheritaPizza(quantityA, orderTimeA, deliveryTimeA);
		PizzaB = new VegetarianPizza(quantityA, orderTimeA, deliveryTimeA);
		PizzaC = new MeatLoversPizza(quantityA, orderTimeA, deliveryTimeA);	
	}
	
	@Test
	public void TestGetCostPerPizza(){
		PizzaA.calculateCostPerPizza();
		assertEquals(1.5, PizzaA.getCostPerPizza(),0.1);
	}
}
