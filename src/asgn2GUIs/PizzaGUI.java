package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a �dummy� class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature � as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Thomas Shortt (n8854742) and Nicholas Constantine (n9171550)
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	private PizzaRestaurant restaurant;
	
	private JTable CustomerTable;
	private JTable PizzaTable;
	
	private JButton LoadLog;
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
		
		//Display the window. 
		frame.setPreferredSize(new Dimension(1080, 720));
		frame.setResizable(true);
		frame.setLocation(new Point(200, 200));
		
		frame.getContentPane().add(label);
		frame.getContentPane().setBackground(Color.white);
		

		frame.pack(); 
		frame.setVisible(true); 
		
	}

	
	@Override
	public void run() {
		//code to press button goes here
		//and choose file
		restaurant = new PizzaRestaurant();
		//restaurant.processLog(filename)
		//component such as a JTextField or JTable is suitable to display this information.
	
		/* The information needs to be user friendly, so the codes 
		used to describe pizzas and customers should be translated 
		to into pizza and customer �types� using descriptive language 
		(Margherita, Meat Lovers, Vegetarian/Pick Up, Driver Delivery, Drone Delivery). */
	
	}

	

}
