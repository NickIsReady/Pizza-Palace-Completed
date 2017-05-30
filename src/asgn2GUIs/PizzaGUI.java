package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Thomas Shortt (n8854742) and Nicholas Constantine (n9171550)
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	private PizzaRestaurant restaurant;
	
	private JTable OrderTable;
	private JTextField TotalsDisplay;
	
	private JButton LoadLog;
	private JButton CalculateTotals;
	private JButton ResetButton;
	private JFileChooser ChooseLog;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		//Create and set up the window. 
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//Add the label. 
		JLabel label = new JLabel("Pizza Palace");
		
		OrderTable = new JTable();
		TotalsDisplay = new JTextField();
		
		LoadLog = new JButton("Load Log");
		CalculateTotals = new JButton("Calculate Total");
		ResetButton = new JButton("Reset");
		ChooseLog = new JFileChooser();
		
		//Display the window. 
		frame.setPreferredSize(new Dimension(1080, 720));
		frame.setResizable(true);
		frame.setLocation(new Point(200, 200));
		
		frame.getContentPane().add(label);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().add(OrderTable);
		frame.getContentPane().add(TotalsDisplay);
		frame.getContentPane().add(LoadLog);
		frame.getContentPane().add(CalculateTotals);
		frame.getContentPane().add(ResetButton);

		frame.pack(); 
		frame.setVisible(true);
		
	}

	
	@Override
	public void run() {
		//code to press button goes here
		//and choose file
		String filename = "";
		restaurant = new PizzaRestaurant();
		//restaurant.processLog(filename)
		//component such as a JTextField or JTable is suitable to display this information.
	
		/* The information needs to be user friendly, so the codes 
		used to describe pizzas and customers should be translated 
		to into pizza and customer ‘types’ using descriptive language 
		(Margherita, Meat Lovers, Vegetarian/Pick Up, Driver Delivery, Drone Delivery). */
		try {
			if (restaurant.processLog(filename) == true) {
				//Fill Customer table with customer information from log
				
				//Fill Pizza table with order information from log
				
				//Display the total distance and profit made from log
			}
		} catch (CustomerException | PizzaException | LogHandlerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
	}

	

}
