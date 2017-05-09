package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;

/**
 * 
 *  A class that represents a meat lovers pizza made at the Pizza Palace restaurant. 
 *  The meat lovers pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Thomas Shortt (n8854742)
 *
 */
public class MeatLoversPizza extends Pizza {

	private LocalTime openingTime = LocalTime.of(19, 00);
	private LocalTime closingTime = LocalTime.of(23, 00);
	
	/**
	 * 
	 *  This class represents a meat lovers pizza made at the  Pizza Palace restaurant. The meat lovers pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
 	 * <P> PRE: TRUE
 	 * <P> POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MeatLoversPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		super(quantity, deliveryTime, deliveryTime, "Meat Lovers", 12.00);
		if (quantity < 1 || quantity > 10) {
			throw new PizzaException("Invalid quantity!");
		} else if (orderTime.isBefore(openingTime) == true || orderTime.isAfter(closingTime) == true) {
			throw new PizzaException("Order time is invalid!");
		} else if (deliveryTime.isBefore(orderTime.plusMinutes(10)) == true || deliveryTime.isAfter(orderTime.plusHours(1)) == true) {
			throw new PizzaException("Delivery time is invalid!");
		}
	}

}
