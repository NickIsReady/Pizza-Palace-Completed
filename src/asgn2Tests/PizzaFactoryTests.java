package asgn2Tests;

import java.time.LocalTime;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	
	private int quantityTemp = 3;
	private LocalTime orderTimeTemp = LocalTime.of(19, 10);
	private LocalTime deliveryTimeTemp = LocalTime.of(19, 25);
	private String codeTemp = "PZM";
	
	
	//Exceptions
	@Test(expected = PizzaException.class)
	public void ExceptionFalseCode() throws PizzaException {
		Pizza InvalidPizaa = PizzaFactory.getPizza("AAA", quantityTemp, orderTimeTemp, deliveryTimeTemp);
	}
	
	@Test
	public void RetrieveMargheritaPizza() throws PizzaException {
		Pizza MargheritaTemp = new MargheritaPizza(quantityTemp, orderTimeTemp, deliveryTimeTemp);
		assertEquals(MargheritaTemp, PizzaFactory.getPizza("PZM", quantityTemp, orderTimeTemp, deliveryTimeTemp));
	}
	
	@Test
	public void RetrieveVegetarianPizza() throws PizzaException{
		Pizza VegetarianTemp = new VegetarianPizza(quantityTemp, orderTimeTemp, deliveryTimeTemp);
		assertEquals(VegetarianTemp, PizzaFactory.getPizza("PZV", quantityTemp, orderTimeTemp, deliveryTimeTemp));
	}
	
	@Test
	public void MeatLoversPizza() throws PizzaException{
		Pizza MeatLoversTemp = new MeatLoversPizza(quantityTemp, orderTimeTemp, deliveryTimeTemp);
		assertEquals(MeatLoversTemp, PizzaFactory.getPizza("PZL", quantityTemp, orderTimeTemp, deliveryTimeTemp));
	}
	
}
