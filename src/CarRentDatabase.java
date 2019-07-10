import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import java.awt.Toolkit;

@SuppressWarnings({"serial" ,"unused"})
public class CarRentDatabase extends JFrame {

	private JFrame frame;
	private CRDriver driver;
	
	//
	private int tableChosen;
	
	//-------------------------------
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_1;
	private JLabel lblTables;
	private JLabel lblViews;
	private JLabel lblTools;
	private JLabel lblQueries;
	
	
	private JButton employeeTableButton;
	private JButton storeTableButton;
	private JButton customerTableButton;
	private JButton btnUpdate;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton VehicleView1Button;
	private JButton StoreContactViewbttn;

	private JButton btnEmployeesByStreetNumber;
	private JButton btnStoreByVehicles;
	private JButton btnCarsByMake;
	private JTextField makeGivenTextField;
	private JTextField givenStreetNumberTextField;
	private JButton btnStoresByVehicle;
	private JButton btnEmployeePositionStore;
	private JButton VehicleKmAvg;
	private JButton btnCustomerByDate;
	private JButton btnCustomerByLocation;
	private JButton btnLocationByAmounts;
	private JButton btnDamagesByKm;
	private JButton btnVehiclesByFuelType;
	private JTextField fuelTypeGivenTextField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarRentDatabase frame = new CarRentDatabase();
					frame.setSize(1100, 700);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application / frame 
	 */
	public CarRentDatabase() {
		
		try{
			driver = new CRDriver();
		}
		catch (Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		//
		//initialize the title
		setTitle("Car Rent Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//scrollPane --> contains table and panel_2 ( panel2: has 3 table that we can access and 2 view)
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.WEST);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(0, 0, 0));
		table.setForeground(new Color(34, 139, 34));
		
		
		table.setFont(new Font("Dialog", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setPreferredSize(new Dimension(200 , 800));
		scrollPane.setRowHeaderView(panel_2);
		//panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_2.setBackground(new Color(128, 128, 128));
		
		
		Box tablesBox = Box.createVerticalBox();
		tablesBox.setPreferredSize(new Dimension(200, 350));
		
		panel_2.add(tablesBox);
		lblTables = new JLabel("Tables");
		tablesBox.add(lblTables);
		
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		
		employeeTableButton = new JButton("Employee Table");
		employeeTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableChosen = 1;
				try{
					
					// code here 
					List<Employee> employees = null;
					
					employees = driver.getAllEmployees();
					
					EmployeeTableModel model = new EmployeeTableModel(employees);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		employeeTableButton.setIcon(null);
		employeeTableButton.setVerticalAlignment(SwingConstants.TOP);
		employeeTableButton.setSize(new Dimension(200, 140));
		employeeTableButton.setBorderPainted(true);
		employeeTableButton.setContentAreaFilled(false);
		employeeTableButton.setFocusPainted(false);
		employeeTableButton.setOpaque(false);
		
		tablesBox.add(employeeTableButton);
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		
		storeTableButton = new JButton("Store Table");
		storeTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableChosen = 2;
				try{
					
					// code here 
					List<Store> stores = null;
					stores = driver.getAllStores();
					
					StoreTableModel model = new StoreTableModel(stores);
					table.setModel(model);
					
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		storeTableButton.setIcon(null);
		storeTableButton.setVerticalAlignment(SwingConstants.TOP);
		storeTableButton.setSize(new Dimension(200, 140));
		storeTableButton.setBorderPainted(true);
		storeTableButton.setContentAreaFilled(false);
		storeTableButton.setFocusPainted(false);
		storeTableButton.setOpaque(false);
		
		tablesBox.add(storeTableButton);
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		
		customerTableButton = new JButton("Customer Table");
		customerTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableChosen = 3;
				try{
					
					// code here 
					List<Customer> customers = null;
					customers = driver.getAllCustomers();
					
					CustomerTableModel model = new CustomerTableModel(customers);
					table.setModel(model);
					
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		customerTableButton.setIcon(null);
		customerTableButton.setVerticalAlignment(SwingConstants.TOP);
		customerTableButton.setSize(new Dimension(200, 140));
		customerTableButton.setBorderPainted(true);
		customerTableButton.setContentAreaFilled(false);
		customerTableButton.setFocusPainted(false);
		customerTableButton.setOpaque(false);
		
		tablesBox.add(customerTableButton);
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		
		// views here
		lblViews = new JLabel("Views");
		tablesBox.add(lblViews);
		//VIEW1 (CAN BE UPDATED)
		
		VehicleView1Button = new JButton("VehicleView Button");
		VehicleView1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tableChosen = 4;  //changed from zero !
				
				try{
					List<VehicleView1> vehicleViews1 = null;
					
					vehicleViews1 = driver.getAllVehicleView1();
					
					VehicleView1TableModel model = new VehicleView1TableModel(vehicleViews1);
					table.setModel(model);
					
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		VehicleView1Button.setSize(new Dimension(40, 240));
		VehicleView1Button.setBorderPainted(true);
		VehicleView1Button.setContentAreaFilled(false);
		VehicleView1Button.setFocusPainted(true);
		VehicleView1Button.setOpaque(false);
		tablesBox.add(VehicleView1Button);
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		
		//VIEW2 (CAN NOT BE UPDATED)
		

		StoreContactViewbttn = new JButton("StoreContactView Button");
		StoreContactViewbttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tableChosen = 0;  //changed from zero !
				
				try{
					List<StoreContactView> storeContactViews = null;
					
					storeContactViews = driver.getAlltheStoreContactView();
					
					StoreContactViewTableModel model = new StoreContactViewTableModel(storeContactViews);
					table.setModel(model);
					
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		StoreContactViewbttn.setSize(new Dimension(40, 240));
		StoreContactViewbttn.setBorderPainted(true);
		StoreContactViewbttn.setContentAreaFilled(false);
		StoreContactViewbttn.setFocusPainted(true);
		StoreContactViewbttn.setOpaque(false);
		tablesBox.add(StoreContactViewbttn);
		tablesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		
		//-------------------------------------------
		
		//---------tools ------------//
				// new panel1 for tools ----------------//
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
				
		lblTools = new JLabel("Tools");
		panel_1.add(lblTools);
		
		//update button
		btnUpdate = new JButton();
		btnUpdate.setText("Update");
		btnUpdate.setIcon(null);
		btnUpdate.setPreferredSize(new Dimension(140, 35));
		btnUpdate.setBorderPainted(true);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setFocusPainted(false);
		btnUpdate.setOpaque(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code 
				//
				int row = table.getSelectedRow();
				if (tableChosen == 1){
					if (row<0){
						JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select an employee", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else if (tableChosen == 2){
					if (row<0){
						JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select a store", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				else if (tableChosen == 3){
					if (row<0){
						JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select a customer", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				else if (tableChosen == 4){
					if (row<0){
						JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select a vehicle(view)", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				//
				
				if (tableChosen == 1){
					Employee tempEmployee = (Employee) table.getValueAt(row, EmployeeTableModel.OBJECT_COL);
					EmployeeDialog dialog = new EmployeeDialog(CarRentDatabase.this, driver, tempEmployee, true);
					dialog.setVisible(true);
				}
				else if (tableChosen == 2){
					Store tempStore = (Store) table.getValueAt(row, StoreTableModel.OBJECT_COL);
					StoreDialog dialog = new StoreDialog(CarRentDatabase.this, driver , tempStore, true);
					dialog.setVisible(true);
				}
				else if (tableChosen == 3){
					Customer tempCustomer = (Customer) table.getValueAt(row, CustomerTableModel.OBJECT_COL);
					CustomerDialog dialog = new CustomerDialog(CarRentDatabase.this, driver, tempCustomer, true);
					dialog.setVisible(true);
					
				}
				else if (tableChosen == 4){
					VehicleView1 tempVehicleView1 = (VehicleView1) table.getValueAt(row, VehicleView1TableModel.OBJECT_COL);
					VehicleView1Dialog dialog = new VehicleView1Dialog(CarRentDatabase.this, driver, tempVehicleView1, true);
					dialog.setVisible(true);
					
				}
				
				//
				
			}
		});
		panel_1.add(btnUpdate);
		
		//insert button
		btnInsert = new JButton();
		btnInsert.setText("Insert");
		btnInsert.setIcon(null);
		btnInsert.setPreferredSize(new Dimension(140, 35));
		btnInsert.setBorderPainted(true);
		btnInsert.setContentAreaFilled(false);
		btnInsert.setFocusPainted(false);
		btnInsert.setOpaque(false);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code 
				//
				if (tableChosen == 1){
					EmployeeDialog dialog = new EmployeeDialog(CarRentDatabase.this, driver, null, false);  //fasle --> boolean updatemode=false --> just insert
					dialog.setVisible(true);
				}
				else if (tableChosen == 2){
					StoreDialog dialog = new StoreDialog(CarRentDatabase.this, driver, null, false);
					dialog.setVisible(true);
				}
				else if (tableChosen == 3){
					CustomerDialog dialog = new CustomerDialog(CarRentDatabase.this, driver, null , false);
					dialog.setVisible(true);
				}
				else if (tableChosen == 4){
					VehicleView1Dialog dialog = new VehicleView1Dialog(CarRentDatabase.this, driver, null, false);
					dialog.setVisible(true);
					
				}
				//
				
			}
		});
		panel_1.add(btnInsert);
		
		
		//delete button
		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setIcon(null);
		btnDelete.setPreferredSize(new Dimension(140, 35));
		btnDelete.setBorderPainted(true);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setFocusPainted(false);
		btnDelete.setOpaque(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code 
				//
				try{
					int row = table.getSelectedRow();
					
					
					if (tableChosen == 1){
						if (row<0){
							JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select an employee", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else if (tableChosen == 2){
						if (row<0){
							JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select a store", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else if (tableChosen == 3){
						if (row<0){
							JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select a customer", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else if (tableChosen == 4){
						if (row<0){
							JOptionPane.showMessageDialog(CarRentDatabase.this, "You must select a vehicle(view)", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					
					//
					
					if (tableChosen == 1){
						int response = JOptionPane.showConfirmDialog(CarRentDatabase.this, "Delete this employee?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response != JOptionPane.YES_OPTION) return;
					}
					else if (tableChosen == 2){
						int response = JOptionPane.showConfirmDialog(CarRentDatabase.this, "Delete this store?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response != JOptionPane.YES_OPTION) return;
					}
					else if (tableChosen == 3){
						int response = JOptionPane.showConfirmDialog(CarRentDatabase.this, "Delete this customer?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response != JOptionPane.YES_OPTION) return;
					}
					else if (tableChosen == 4){
						int response = JOptionPane.showConfirmDialog(CarRentDatabase.this, "Delete this vehicle(view)?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response != JOptionPane.YES_OPTION) return;
					}
					
					
					//
					
					
					if (tableChosen == 1){
						Employee tempEmployee = (Employee) table.getValueAt(row, EmployeeTableModel.OBJECT_COL);
						driver.deleteEmployee(tempEmployee.getEmployeeIRS_Number());
						refreshEmployeeView();
						JOptionPane.showMessageDialog(CarRentDatabase.this, "Employee deleted succesfully.", "Employee Deleted", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (tableChosen == 2){
						Store tempStore = (Store) table.getValueAt(row, StoreTableModel.OBJECT_COL);
						driver.deleteStore(tempStore.getStoreID());
						refreshStoreView();
						JOptionPane.showMessageDialog(CarRentDatabase.this, "Store deleted succesfully.", "Store Deleted", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (tableChosen == 3){
						Customer tempCustomer = (Customer) table.getValueAt(row, CustomerTableModel.OBJECT_COL);
						driver.deleteCustomer(tempCustomer.getCustomerID());
						refreshCustomerView();
						JOptionPane.showMessageDialog(CarRentDatabase.this, "Customer deleted succesfully.", "Customer Deleted", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (tableChosen == 4){
						VehicleView1 tempVehicleView1 = (VehicleView1) table.getValueAt(row, VehicleView1TableModel.OBJECT_COL);
						driver.deleteVehicleView1(tempVehicleView1.getLicensePlate());
						refreshVehicleView1();
						JOptionPane.showMessageDialog(CarRentDatabase.this, "Vehicle(view) deleted succesfully.", "Customer Deleted", JOptionPane.INFORMATION_MESSAGE);
					}
					
					//
					
				}
					catch(Exception exc){
						JOptionPane.showMessageDialog(CarRentDatabase.this, "Error deleting tuple: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				
				
			}
		});
		panel_1.add(btnDelete);
		
		// new panel for queries
		panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		contentPane.add(panel, BorderLayout.EAST);
		
		Box queriesBox = Box.createVerticalBox();
		panel.add(queriesBox);
		
		lblQueries = new JLabel("Queries");
		lblQueries.setHorizontalAlignment(SwingConstants.LEFT);
		queriesBox.add(lblQueries);
		//--------------------------------------
		// add queries buttons
		//----------------------------------
		
		queriesBox.add(Box.createVerticalStrut(15)); //barrier-gap
		
		//first query 
		
		btnEmployeesByStreetNumber = new JButton("Employees Last Name with Street Number > input");
		btnEmployeesByStreetNumber.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployeesByStreetNumber.setIcon(null);
		btnEmployeesByStreetNumber.setPreferredSize(new Dimension(250, 25));
		btnEmployeesByStreetNumber.setBorderPainted(true);
		btnEmployeesByStreetNumber.setContentAreaFilled(false);
		btnEmployeesByStreetNumber.setFocusPainted(false);
		btnEmployeesByStreetNumber.setOpaque(false);
		btnEmployeesByStreetNumber.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				tableChosen = 0;
				String givenStreetNumberStr = givenStreetNumberTextField.getText();
				
				List<EmployeesByStreetNumber> employees = null;
				
				if(givenStreetNumberStr != null && givenStreetNumberStr.trim().length()>0){
					int givenStreetNumber = Integer.parseInt(givenStreetNumberStr);
					employees = driver.searchEmployeesByStreetNumber(givenStreetNumber);
				}
				else{
					
					employees = driver.getAllEmployeesByStreetNumber();
				}
				
				EmployeesByStreetNumberTableModel model = new EmployeesByStreetNumberTableModel(employees);
				table.setModel(model);
			}
			catch (Exception exc){
				JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		});

		btnEmployeesByStreetNumber.setHorizontalAlignment(SwingConstants.LEFT);
		queriesBox.add(btnEmployeesByStreetNumber);
		
		givenStreetNumberTextField = new JTextField();
		givenStreetNumberTextField.setColumns(10);
		queriesBox.add(givenStreetNumberTextField);
		queriesBox.add(Box.createVerticalStrut(10)); //barrier-gap
		
		//second query
		
		
		btnCarsByMake = new JButton("Vehicles of make:");
		btnCarsByMake.setPreferredSize(new Dimension(250, 25));
		btnCarsByMake.setBorderPainted(true);
		btnCarsByMake.setContentAreaFilled(false);
		btnCarsByMake.setFocusPainted(false);
		btnCarsByMake.setOpaque(false);
		btnCarsByMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					String makeGiven = makeGivenTextField.getText();
					List<CarByMake> cars = null;
					
					if(makeGiven != null && makeGiven.trim().length()>0){
						cars = driver.searchMake(makeGiven);
					}
					else{
						cars = driver.getCarByMake();
					}
					
					CarByMakeTableModel model = new CarByMakeTableModel(cars);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCarsByMake.setHorizontalAlignment(SwingConstants.LEFT);
		queriesBox.add(btnCarsByMake);
		
		makeGivenTextField = new JTextField();
		makeGivenTextField.setColumns(15);
		queriesBox.add(makeGivenTextField);
		queriesBox.add(Box.createVerticalStrut(15));
		
		
		//
		//third query 
		
		btnStoresByVehicle = new JButton("Stores by number of Vechiles");
		btnStoresByVehicle.setPreferredSize(new Dimension(250, 25));
		btnStoresByVehicle.setBorderPainted(true);
		btnStoresByVehicle.setContentAreaFilled(false);
		btnStoresByVehicle.setFocusPainted(false);
		btnStoresByVehicle.setOpaque(false);
		btnStoresByVehicle.setHorizontalAlignment(SwingConstants.LEFT);
		btnStoresByVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<StoreByVehicle> stores = null;
					
					stores = driver.getStoreByVehicle();
					
					StoreByVehicleTableModel model = new StoreByVehicleTableModel(stores);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnStoresByVehicle);
		queriesBox.add(Box.createVerticalStrut(10));
		
		
		//
		// fourth query
		
		
		btnEmployeePositionStore = new JButton("Employees' Position in Stores");
		btnEmployeePositionStore.setPreferredSize(new Dimension(250, 25));
		btnEmployeePositionStore.setBorderPainted(true);
		btnEmployeePositionStore.setContentAreaFilled(false);
		btnEmployeePositionStore.setFocusPainted(false);
		btnEmployeePositionStore.setOpaque(false);
		btnEmployeePositionStore.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployeePositionStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<EmployeePositionStore> employees = null;
					
					employees = driver.getEmployeePositionStore();
					
					EmployeePositionStoreTableModel model = new EmployeePositionStoreTableModel(employees);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnEmployeePositionStore);
		queriesBox.add(Box.createVerticalStrut(10));
		
		
		//fifth query
		
		VehicleKmAvg = new JButton("Vehicles With the Most Kilometers");
		VehicleKmAvg.setPreferredSize(new Dimension(250, 25));
		VehicleKmAvg.setBorderPainted(true);
		VehicleKmAvg.setContentAreaFilled(false);
		VehicleKmAvg.setFocusPainted(false);
		VehicleKmAvg.setOpaque(false);
		VehicleKmAvg.setHorizontalAlignment(SwingConstants.LEFT);
		VehicleKmAvg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<VehicleKmAvg> vehicles = null;
					
					vehicles = driver.getVehicleKmAvg();
					
					VehicleKmAvgTableModel model = new VehicleKmAvgTableModel(vehicles);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(VehicleKmAvg);
		queriesBox.add(Box.createVerticalStrut(10));
		
		
		//sixth query
		
		btnCustomerByDate = new JButton("Customers ordered by First Registration");
		btnCustomerByDate.setPreferredSize(new Dimension(250, 25));
		btnCustomerByDate.setBorderPainted(true);
		btnCustomerByDate.setContentAreaFilled(false);
		btnCustomerByDate.setFocusPainted(false);
		btnCustomerByDate.setOpaque(false);
		btnCustomerByDate.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomerByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<CustomerByDate> customers = null;
					
					customers = driver.getCustomerByDate();
					
					CustomerByDateTableModel model = new CustomerByDateTableModel(customers);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnCustomerByDate);
		queriesBox.add(Box.createVerticalStrut(10));
		
		
		//
		// seventh query
		

		btnCustomerByLocation = new JButton("Customers Reserved in Summer 2018");
		btnCustomerByLocation.setPreferredSize(new Dimension(250, 25));
		btnCustomerByLocation.setBorderPainted(true);
		btnCustomerByLocation.setContentAreaFilled(false);
		btnCustomerByLocation.setFocusPainted(false);
		btnCustomerByLocation.setOpaque(false);
		btnCustomerByLocation.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomerByLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					tableChosen = 0;
					List<CustomerByLocation> customers = null;
					
					customers = driver.getCustomerByLocation();
					
					CustomerByLocationTableModel model = new CustomerByLocationTableModel(customers);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnCustomerByLocation);
		queriesBox.add(Box.createVerticalStrut(10));
		
		//
		// 8th query
		
		
		btnLocationByAmounts = new JButton("Rent Location Order By Total Amount Paid");
		btnLocationByAmounts.setPreferredSize(new Dimension(250, 25));
		btnLocationByAmounts.setBorderPainted(true);
		btnLocationByAmounts.setContentAreaFilled(false);
		btnLocationByAmounts.setFocusPainted(false);
		btnLocationByAmounts.setOpaque(false);
		btnLocationByAmounts.setHorizontalAlignment(SwingConstants.LEFT);
		btnLocationByAmounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<LocationByAmounts> patients = null;
					
					patients = driver.getLocationByAmounts();
					
					LocationByAmountsTableModel model = new LocationByAmountsTableModel(patients);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnLocationByAmounts);
		queriesBox.add(Box.createVerticalStrut(10));
		
		//
		// 9th query
		
		
		btnDamagesByKm = new JButton("Vehicle's Damages ordered by Kilometers");
		btnDamagesByKm.setPreferredSize(new Dimension(250, 25));
		btnDamagesByKm.setBorderPainted(true);
		btnDamagesByKm.setContentAreaFilled(false);
		btnDamagesByKm.setFocusPainted(false);
		btnDamagesByKm.setOpaque(false);
		btnDamagesByKm.setHorizontalAlignment(SwingConstants.LEFT);
		btnDamagesByKm.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try{
					tableChosen = 0;
					List<DamagesByKm> damages = null;
					
					damages = driver.getDamagesByKm();
					
					DamagesByKmTableModel model = new DamagesByKmTableModel(damages);
					table.setModel(model);
				}
				catch (Exception exc){
					JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		queriesBox.add(btnDamagesByKm);
		queriesBox.add(Box.createVerticalStrut(10));
		
		//
		//10th query
		

			btnVehiclesByFuelType = new JButton("Vehicle of Fuel Type:");
			btnVehiclesByFuelType.setPreferredSize(new Dimension(250, 25));
			btnVehiclesByFuelType.setBorderPainted(true);
			btnVehiclesByFuelType.setContentAreaFilled(false);
			btnVehiclesByFuelType.setFocusPainted(false);
			btnVehiclesByFuelType.setOpaque(false);
			btnVehiclesByFuelType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						tableChosen = 0;
						String fuelTypeGiven = fuelTypeGivenTextField.getText();
						List<String> vehicles = null;
						
						if(fuelTypeGiven != null && fuelTypeGiven.trim().length()>0){
							vehicles = driver.searchVehiclesByFuelType(fuelTypeGiven);
						}
						else{
							vehicles = driver.getAllVehiclesByFuelType();
						}
						
						VehiclesByFuelTypeTableModel model = new VehiclesByFuelTypeTableModel(vehicles);
						table.setModel(model);
					}
					catch (Exception exc){
						JOptionPane.showMessageDialog(CarRentDatabase.this, "Error: "+exc, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnVehiclesByFuelType.setHorizontalAlignment(SwingConstants.LEFT);
			queriesBox.add(btnVehiclesByFuelType);
			
			fuelTypeGivenTextField = new JTextField();
			fuelTypeGivenTextField.setColumns(10);
			queriesBox.add(fuelTypeGivenTextField);
		
		//-------------------------------------------------------------------------------------------------------------------------------------
		
	}
	
	
	public void refreshEmployeeView() {
		try{
			List<Employee> employees = driver.getAllEmployees();
			
			EmployeeTableModel model = new EmployeeTableModel(employees);
			
			table.setModel(model);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void refreshStoreView() {
		try{
			List<Store> stores = driver.getAllStores();
			
			StoreTableModel model = new StoreTableModel(stores);
			
			table.setModel(model);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void refreshCustomerView() {
		try {
			List<Customer> customers = driver.getAllCustomers();
			
			CustomerTableModel model = new CustomerTableModel(customers);
			
			table.setModel(model);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void refreshVehicleView1() {
		try {
			List<VehicleView1> vehicleViews1 = driver.getAllVehicleView1();
			
			VehicleView1TableModel model = new VehicleView1TableModel(vehicleViews1);
			
			table.setModel(model);
		
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(this, "Error: "+exc, "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
}
