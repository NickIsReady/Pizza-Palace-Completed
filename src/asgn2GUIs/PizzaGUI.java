package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


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
	
	private JTable CustomerTable;
	private JTable PizzaTable;
	
	private JTextField LogStatus;
	private JTextField ResultsProfit;
	private JTextField ResultsDistance;
	
	private JButton LoadLog;
	private JButton DisplayInformation;
	private JButton CalculationsProfit;
	private JButton CalculationsDistance;
	private JButton Reset;
	
	private JFileChooser ChooseLog;
	
	private String Filename;
	
	private double TotalProfit = 0.00;
	private double TotalDistance = 0.00;
	
	DefaultTableModel CustomerTableModel;
	DefaultTableModel PizzaTableModel;
	
	private DecimalFormat twoDecimal = new DecimalFormat("#0.00");
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		//Create and set up the JFrame GUI
		JFrame frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setResizable(false);
		
		//Setup main JFrame components
		JPanel Title = new JPanel();
			Title.setBackground(new Color(237, 172, 107));//rgb
			Title.setLayout(new FlowLayout());
			JLabel label = new JLabel("Pizza Palace");
			Title.add(label,0);
		frame.getContentPane().add(Title, BorderLayout.NORTH);
		
		JPanel LogButtonPlusCalculations = new JPanel();
			LogButtonPlusCalculations.setBackground(new Color(247, 243, 190));
			LogButtonPlusCalculations.setLayout(new BorderLayout());
				
				//Create the buttons and components needed to load a log file
				JPanel LogButtons = new JPanel();
				LogButtons.setBackground(new Color(247, 243, 190));
				LogButtons.setLayout(new BoxLayout(LogButtons,BoxLayout.Y_AXIS));
				LoadLog = new JButton("Open log file");
				LogButtons.add(LoadLog);
				
				LogButtons.add(Box.createRigidArea(new Dimension(0,10)));
				
				JLabel LogStatusName = new JLabel("Current Log File Status");
				LogButtons.add(LogStatusName);
				
				LogStatus = new JTextField("Log file currently not loaded.");
				LogStatus.setPreferredSize(new Dimension(250,75));
				LogStatus.setEditable(false);
				LogButtons.add(LogStatus);
				
				LogButtons.add(Box.createRigidArea(new Dimension(0,10)));
				
				DisplayInformation = new JButton("Display Log File Data");
				DisplayInformation.setEnabled(false);
				LogButtons.add(DisplayInformation);
				
				LogButtons.add(Box.createRigidArea(new Dimension(0,10)));
				
				//Image was found online at http://www.mycutegraphics.com/graphics/food/whole-pizza.html
				ImageIcon pizzaImage = new ImageIcon("pizzaImage.png");
				JLabel LabelPizzaImage = new JLabel(pizzaImage);
				LogButtons.add(LabelPizzaImage); 
				
				LogButtons.add(Box.createRigidArea(new Dimension(0,10)));
				
			LogButtonPlusCalculations.add(LogButtons, BorderLayout.LINE_START);
			
				//Create the buttons and components needed to perform calculations of the total profit and distance
				JPanel Calculations = new JPanel();
				Calculations.setBackground(new Color(247, 243, 190));
				Calculations.setLayout(new BoxLayout(Calculations, BoxLayout.Y_AXIS));
					
					JPanel CalculateProfit = new JPanel();
					CalculateProfit.setBackground(new Color(247, 243, 150));
					CalculateProfit.setLayout(new FlowLayout());
				
					CalculationsProfit = new JButton("Calculate Total Profit");
					CalculationsProfit.setEnabled(false);
					CalculationsProfit.setPreferredSize(new Dimension(180,30));
					CalculateProfit.add(CalculationsProfit, 0);
					
					JLabel Dollar = new JLabel("$");
					CalculateProfit.add(Dollar,1);
					
					ResultsProfit = new JTextField(twoDecimal.format(TotalProfit));
					ResultsProfit.setPreferredSize(new Dimension(70,20));
					ResultsProfit.setHorizontalAlignment(SwingConstants.RIGHT);
					ResultsProfit.setEditable(false);
					CalculateProfit.add(ResultsProfit, 2);
				Calculations.add(CalculateProfit);
		
					JPanel CalculateDistance = new JPanel();
					CalculateDistance.setBackground(new Color(247, 243, 150));
					CalculateDistance.setLayout(new FlowLayout());
					
					CalculationsDistance = new JButton("Calculate Total Distance");
					CalculationsDistance.setEnabled(false);
					CalculationsDistance.setPreferredSize(new Dimension(180,30));
					CalculateDistance.add(CalculationsDistance, 0);
					
					ResultsDistance = new JTextField(twoDecimal.format(TotalDistance));
					ResultsDistance.setPreferredSize(new Dimension(70,20));
					ResultsDistance.setHorizontalAlignment(SwingConstants.RIGHT);
					ResultsDistance.setEditable(false);
					CalculateDistance.add(ResultsDistance, 1);
					
					JLabel Blocks = new JLabel("Blocks");
					CalculateDistance.add(Blocks,2);
				Calculations.add(CalculateDistance);
				
			LogButtonPlusCalculations.add(Calculations, BorderLayout.SOUTH);
			
		frame.getContentPane().add(LogButtonPlusCalculations, BorderLayout.WEST);
		
		//Create the tables that will display the information obtained from the log file
		JPanel Tables = new JPanel();
			Tables.setLayout(new BoxLayout(Tables, BoxLayout.Y_AXIS));
			
			String [] columnNamesCustomer = {"Customer Name", "Mobile Number", "Customer Type", "X Location", "Y Location", "Distance from Restaurant"};
			CustomerTableModel = new DefaultTableModel(columnNamesCustomer, 0);
			CustomerTable = new JTable(CustomerTableModel);
			JScrollPane CustomerTablePane = new JScrollPane(CustomerTable);
			CustomerTable.setFillsViewportHeight(true);
			CustomerTablePane.setPreferredSize(new Dimension(1000,200));
			Tables.add(CustomerTablePane, 0);
			
			String [] columnNamesPizza = {"Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit"};
			PizzaTableModel = new DefaultTableModel(columnNamesPizza, 0);
			PizzaTable = new JTable(PizzaTableModel);
			JScrollPane PizzaTablePane = new JScrollPane(PizzaTable);
			PizzaTable.setFillsViewportHeight(true);
			PizzaTablePane.setPreferredSize(new Dimension(1000,200));
			Tables.add(PizzaTablePane, 1);
		
		frame.getContentPane().add(Tables, BorderLayout.EAST);
		
		//Create the reset button
		JPanel ResetPanel = new JPanel();
			ResetPanel.setBackground(new Color(237, 172, 107));
			ResetPanel.setLayout(new FlowLayout());
			Reset = new JButton("Reset Information");
			Reset.setEnabled(false);
			ResetPanel.add(Reset, 0);
		frame.getContentPane().add(ResetPanel, BorderLayout.SOUTH);
		
	
		
		frame.getContentPane().setBackground(Color.CYAN);
		
		//size frame and make it visible
		frame.pack(); 
		frame.setVisible(true);
	}

	
	@Override
	public void run() {
		restaurant = new PizzaRestaurant();
		
		//Load log when the "Open Log File" button is pressed
		LoadLog.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DisplayInformation.setEnabled(false);
				CalculationsProfit.setEnabled(false);
				CalculationsDistance.setEnabled(false); 
				ChooseLog = new JFileChooser("logs/");
				FileNameExtensionFilter TxtFilter = new FileNameExtensionFilter("Text Files", "txt");
				ChooseLog.setFileFilter(TxtFilter);
				int ReturnValue = ChooseLog.showOpenDialog(null);
				//Check if log has been chosen
				if (ReturnValue == JFileChooser.APPROVE_OPTION){
					Filename = "logs/" + ChooseLog.getSelectedFile().getName();
					
					TotalProfit = 0.00;
					TotalDistance = 0.00;
					CustomerTableModel.setRowCount(0);
					PizzaTableModel.setRowCount(0);
					restaurant.resetDetails();
					ResultsProfit.setText(twoDecimal.format(TotalProfit));
					ResultsDistance.setText(twoDecimal.format(TotalDistance));
					LogStatus.setText("Log file currently not loaded.");
					
					try {
						restaurant.processLog(Filename);
						//Check if log has loaded with no errors
						if (restaurant.processLog(Filename) == true) {
							LogStatus.setText("Log "+ ChooseLog.getSelectedFile().getName() +" Processed Successfully.");
							DisplayInformation.setEnabled(true);
							CalculationsProfit.setEnabled(true);
							CalculationsDistance.setEnabled(true); 
							Reset.setEnabled(true);
						}
					} catch (CustomerException | PizzaException | LogHandlerException e1) {
						LogStatus.setText(e1.getMessage());
						e1.printStackTrace();
					}
				}
			}	
		});
		
		//Display customer and pizza information in their respective display tables
		DisplayInformation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Object [] dataCustomerRow = new Object[6];
				Object [] dataPizzaRow = new Object[5];
				//Populate customer table with information from log
				for (int index = 0; index < restaurant.getNumCustomerOrders(); index++){
					try {
						dataCustomerRow[0] = restaurant.getCustomerByIndex(index).getName();
						dataCustomerRow[1] = restaurant.getCustomerByIndex(index).getMobileNumber();
						dataCustomerRow[2] = restaurant.getCustomerByIndex(index).getCustomerType();
						dataCustomerRow[3] = restaurant.getCustomerByIndex(index).getLocationX();
						dataCustomerRow[4] = restaurant.getCustomerByIndex(index).getLocationY();
						dataCustomerRow[5] = twoDecimal.format(restaurant.getCustomerByIndex(index).getDeliveryDistance());
						CustomerTableModel.addRow(dataCustomerRow);
					} catch (CustomerException e1) {
						e1.printStackTrace();
					}
				}
				//Populate pizza table with information from log
				for (int index = 0; index < restaurant.getNumPizzaOrders(); index++){
					try {
						restaurant.getPizzaByIndex(index).calculateCostPerPizza();
						dataPizzaRow[0] = restaurant.getPizzaByIndex(index).getPizzaType();
						dataPizzaRow[1] = restaurant.getPizzaByIndex(index).getQuantity();
						dataPizzaRow[2] = twoDecimal.format(restaurant.getPizzaByIndex(index).getOrderPrice());
						dataPizzaRow[3] = twoDecimal.format(restaurant.getPizzaByIndex(index).getOrderCost());
						dataPizzaRow[4] = twoDecimal.format(restaurant.getPizzaByIndex(index).getOrderProfit());
						PizzaTableModel.addRow(dataPizzaRow);
					} catch (PizzaException e1) {
						e1.printStackTrace();
					}
				}
				DisplayInformation.setEnabled(false);
			}
		});
		
		//Calculate and display the total profit of all pizza orders
		CalculationsProfit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TotalProfit = restaurant.getTotalProfit();
				ResultsProfit.setText(twoDecimal.format(TotalProfit));	
			}
		});
		
		//Calculate and display the total delivery distance of all customers
		CalculationsDistance.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TotalDistance = restaurant.getTotalDeliveryDistance();
				ResultsDistance.setText(twoDecimal.format(TotalDistance));
			}
		});
		
		//Clear all information and reset the GUI
		Reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TotalProfit = 0.00;
				TotalDistance = 0.00;
				CustomerTableModel.setRowCount(0);
				PizzaTableModel.setRowCount(0);
				restaurant.resetDetails();
				ResultsProfit.setText(twoDecimal.format(TotalProfit));
				ResultsDistance.setText(twoDecimal.format(TotalDistance));
				LogStatus.setText("Log file currently not loaded.");
				DisplayInformation.setEnabled(false);
				CalculationsProfit.setEnabled(false);
				CalculationsDistance.setEnabled(false); 
			}
		});
	}

	

}
