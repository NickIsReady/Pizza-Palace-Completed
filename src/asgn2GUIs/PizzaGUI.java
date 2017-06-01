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
	
	private JTextField ResultsProfit;
	private JTextField ResultsDistance;
	
	private JButton LoadLog;
	private JButton DisplayInformation;
	private JButton CalculationsProfit;
	private JButton CalculationsDistance;
	private JButton Reset;
	
	private JFileChooser ChooseLog;
	
	private String Filename;
	
	private JLabel LogStatus;
	
	private double TotalProfit = 0.00;
	private double TotalDistance = 0.00;
	
	DefaultTableModel CustomerTableModel;
	DefaultTableModel PizzaTableModel;
	
	private DecimalFormat twoDecimal = new DecimalFormat("#.00");
	
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
			Title.setLayout(new FlowLayout());
			JLabel label = new JLabel("Pizza Palace");
			Title.add(label,0);
		frame.getContentPane().add(Title, BorderLayout.NORTH);
		
		JPanel LogButtonPlusCalculations = new JPanel();
			LogButtonPlusCalculations.setLayout(new BorderLayout());
			
				JPanel LogButtons = new JPanel();
				LogButtons.setLayout(new BoxLayout(LogButtons,BoxLayout.Y_AXIS));
				LoadLog = new JButton("Open log file");
				LogButtons.add(LoadLog);
				LogStatus = new JLabel("Log file currently not loaded.");
				LogButtons.add(LogStatus);
				DisplayInformation = new JButton("Display Log File Data");
				DisplayInformation.setEnabled(false);
				LogButtons.add(DisplayInformation);
				
			LogButtonPlusCalculations.add(LogButtons, BorderLayout.LINE_START);
			
			
				JPanel Calculations = new JPanel();
					Calculations.setLayout(new BoxLayout(Calculations, BoxLayout.Y_AXIS));
					JPanel CalculateProfit = new JPanel();
					CalculateProfit.setLayout(new FlowLayout());
				
					CalculationsProfit = new JButton("Calculate Total Profit");
					CalculationsProfit.setEnabled(false);
					CalculateProfit.add(CalculationsProfit, 0);
					
					ResultsProfit = new JTextField("$          "+twoDecimal.format(TotalProfit));
					CalculateProfit.add(ResultsProfit, 1);
				Calculations.add(CalculateProfit);
		
					JPanel CalculateDistance = new JPanel();
					CalculateDistance.setLayout(new FlowLayout());
					
					CalculationsDistance = new JButton("Calculate Total Distance");
					CalculationsDistance.setEnabled(false);
					CalculateDistance.add(CalculationsDistance, 0);
					
					ResultsDistance = new JTextField("      "+twoDecimal.format(TotalDistance)+" blocks");
					CalculateDistance.add(ResultsDistance, 1);
				Calculations.add(CalculateDistance);
				
			LogButtonPlusCalculations.add(Calculations, BorderLayout.SOUTH);
			
		frame.getContentPane().add(LogButtonPlusCalculations, BorderLayout.WEST);
		
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
		
		JPanel ResetPanel = new JPanel();
			ResetPanel.setLayout(new FlowLayout());
			Reset = new JButton("Reset Information");
			Reset.setEnabled(false);
			ResetPanel.add(Reset, 0);
		frame.getContentPane().add(ResetPanel, BorderLayout.SOUTH);
		
	
		
		frame.getContentPane().setBackground(Color.white);
		
		//size frame and make it visible
		frame.pack(); 
		frame.setVisible(true);
		
		
		
		/*Thomas bit
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
		*/
	}

	
	@Override
	public void run() {
		restaurant = new PizzaRestaurant();
		
		LoadLog.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ChooseLog = new JFileChooser("logs/");
				FileNameExtensionFilter TxtFilter = new FileNameExtensionFilter("Text Files", "txt");
				ChooseLog.setFileFilter(TxtFilter);
				int ReturnValue = ChooseLog.showOpenDialog(null);
				if (ReturnValue == JFileChooser.APPROVE_OPTION){
					Filename = "logs/" + ChooseLog.getSelectedFile().getName();
					
					TotalProfit = 0.00;
					TotalDistance = 0.00;
					CustomerTableModel.setRowCount(0);
					PizzaTableModel.setRowCount(0);
					restaurant.resetDetails();
					ResultsProfit.setText("$          "+twoDecimal.format(TotalProfit));
					ResultsDistance.setText("      "+twoDecimal.format(TotalDistance)+" blocks");
					LogStatus.setText("Log file currently not loaded.");
					
					try {
						restaurant.processLog(Filename);
					} catch (CustomerException | PizzaException | LogHandlerException e1) {
						LogStatus.setText(e1.getMessage());
						e1.printStackTrace();
					}
					LogStatus.setText("Log "+ ChooseLog.getSelectedFile().getName() +" Processed Successfully.");
					DisplayInformation.setEnabled(true);
					CalculationsProfit.setEnabled(true);
					CalculationsDistance.setEnabled(true); 
					Reset.setEnabled(true);
				}
			}	
		});
		
		DisplayInformation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Object [] dataCustomerRow = new Object[6];
				Object [] dataPizzaRow = new Object[5];
				for (int i = 0; i < restaurant.getNumCustomerOrders(); i++){
					try {
						dataCustomerRow[0] = restaurant.getCustomerByIndex(i).getName();
						dataCustomerRow[1] = restaurant.getCustomerByIndex(i).getMobileNumber();
						dataCustomerRow[2] = restaurant.getCustomerByIndex(i).getCustomerType();
						dataCustomerRow[3] = restaurant.getCustomerByIndex(i).getLocationX();
						dataCustomerRow[4] = restaurant.getCustomerByIndex(i).getLocationY();
						dataCustomerRow[5] = restaurant.getCustomerByIndex(i).getDeliveryDistance();
						CustomerTableModel.addRow(dataCustomerRow);
					} catch (CustomerException e1) {
						e1.printStackTrace();
					}
				}
				
				for (int j = 0; j < restaurant.getNumPizzaOrders(); j++){
					try {
						dataPizzaRow[0] = restaurant.getPizzaByIndex(j).getPizzaType();
						dataPizzaRow[1] = restaurant.getPizzaByIndex(j).getQuantity();
						dataPizzaRow[2] = restaurant.getPizzaByIndex(j).getOrderPrice();
						dataPizzaRow[3] = restaurant.getPizzaByIndex(j).getOrderCost();
						dataPizzaRow[4] = restaurant.getPizzaByIndex(j).getOrderProfit();
						PizzaTableModel.addRow(dataPizzaRow);
					} catch (PizzaException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		CalculationsProfit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TotalProfit = restaurant.getTotalProfit();
				ResultsProfit.setText("$          "+twoDecimal.format(TotalProfit));	
			}
		});
		
		CalculationsDistance.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TotalDistance = restaurant.getTotalDeliveryDistance();
				ResultsDistance.setText("      "+twoDecimal.format(TotalDistance)+" blocks");
			}
		});
		
		Reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TotalProfit = 0.00;
				TotalDistance = 0.00;
				CustomerTableModel.setRowCount(0);
				PizzaTableModel.setRowCount(0);
				restaurant.resetDetails();
				ResultsProfit.setText("$          "+twoDecimal.format(TotalProfit));
				ResultsDistance.setText("      "+twoDecimal.format(TotalDistance)+" blocks");
				LogStatus.setText("Log file currently not loaded.");
			}
		});	
		
		/* Thomas Bit
		 * //code to press button goes here
		 *
		//and choose file
		String filename = "";
		restaurant = new PizzaRestaurant();
		//restaurant.processLog(filename)
		//component such as a JTextField or JTable is suitable to display this information.
	
		/* The information needs to be user friendly, so the codes 
		used to describe pizzas and customers should be translated 
		to into pizza and customer �types� using descriptive language 
		(Margherita, Meat Lovers, Vegetarian/Pick Up, Driver Delivery, Drone Delivery).
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
		*/
	}

	

}
