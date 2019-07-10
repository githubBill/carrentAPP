import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IRS_NumberTextField;
	private JTextField Social_Sec_NumberTextField;
	private JTextField Driver_LicenseTextField;
	private JTextField FirstNameTextField;
	private JTextField LastNameTextField;
	private JTextField StreetTextField;
	private JTextField StreetNumberTextField;
	private JTextField PostalCodeTextField;
	private JTextField CityTextField;
	
	private CRDriver driver;

	
	private CarRentDatabase  employeeSearchApp;
	private Employee previousEmployee = null;
	private boolean updateMode = false;
	
	
	
	
	
	public EmployeeDialog(CarRentDatabase theEmployeeSearchApp, CRDriver theDriver, Employee thePreviousEmployee, boolean theUpdateMode){
		this();
		driver = theDriver;
		employeeSearchApp = theEmployeeSearchApp;
		previousEmployee = thePreviousEmployee;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Employee");
			populateGui(previousEmployee);
		}
	}
	
	private void populateGui(Employee theEmployee) {
		
		IRS_NumberTextField.setText(new Integer(theEmployee.getEmployeeIRS_Number()).toString());
		Social_Sec_NumberTextField.setText(new Integer(theEmployee.getSocial_Sec_Number()).toString());
		Driver_LicenseTextField.setText(theEmployee.getDriver_License());
		FirstNameTextField.setText(theEmployee.getFirstName());
		LastNameTextField.setText(theEmployee.getLastName());
		StreetTextField.setText(theEmployee.getStreet());
		StreetNumberTextField.setText(new Integer(theEmployee.getStreetNumber()).toString());
		PostalCodeTextField.setText(new Integer(theEmployee.getPostalCode()).toString());
		CityTextField.setText(theEmployee.getCity());
		
	}
	
	
	/**
	 * Launch the application.
	 */
	//just for test does not need main    
	public static void main(String[] args) {
		try {
			EmployeeDialog dialog = new EmployeeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the dialog.
	 */
	
	public EmployeeDialog() {
		setTitle("Add Employee");
		setBounds(100, 100, 578, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel lblNewLabel = new JLabel("First Name");
			lblNewLabel.setBounds(10, 113, 101, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			FirstNameTextField = new JTextField();
			FirstNameTextField.setBounds(150, 110, 114, 19);
			contentPanel.add(FirstNameTextField);
			FirstNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(10, 139, 101, 15);
			contentPanel.add(lblLastName);
		}
		{
			LastNameTextField = new JTextField();
			LastNameTextField.setBounds(150, 136, 114, 19);
			contentPanel.add(LastNameTextField);
			LastNameTextField.setColumns(10);
		}
		//-----------------------------------------------------
		Driver_LicenseTextField = new JTextField();
		Driver_LicenseTextField.setBounds(150, 79, 114, 20);
		contentPanel.add(Driver_LicenseTextField);
		Driver_LicenseTextField.setColumns(10);
		
		JLabel lblDriverLicense = new JLabel("Driver License\r\n");
		lblDriverLicense.setBounds(10, 82, 101, 14);
		contentPanel.add(lblDriverLicense);
		//-----------------------------------------------------
		{
			Social_Sec_NumberTextField = new JTextField();
			Social_Sec_NumberTextField.setBounds(150, 51, 114, 20);
			contentPanel.add(Social_Sec_NumberTextField);
			Social_Sec_NumberTextField.setColumns(10);
		}
		{
			JLabel lblSocialSecurityNumber = new JLabel("Social Security Number");
			lblSocialSecurityNumber.setBounds(10, 51, 110, 20);
			contentPanel.add(lblSocialSecurityNumber);
		}
		//--------------------------------------------------------
		if(!updateMode){
			{
				IRS_NumberTextField = new JTextField();
				IRS_NumberTextField.setBounds(150, 21, 114, 20);
				contentPanel.add(IRS_NumberTextField);
				IRS_NumberTextField.setColumns(10);
			}
			{
				JLabel lblIrsNumber = new JLabel("IRS Number");
				lblIrsNumber.setBounds(10, 24, 101, 16);
				contentPanel.add(lblIrsNumber);
			}
		}
		//-------------------------------------------------------------
		{
			StreetTextField = new JTextField();
			StreetTextField.setBounds(150, 166, 114, 20);
			contentPanel.add(StreetTextField);
			StreetTextField.setColumns(10);
		}
		{
			JLabel lblStreet = new JLabel("Street");
			lblStreet.setBounds(10, 169, 46, 14);
			contentPanel.add(lblStreet);
		}
		//---------------------------------------------------------
		{
			StreetNumberTextField = new JTextField();
			StreetNumberTextField.setBounds(150, 197, 114, 20);
			contentPanel.add(StreetNumberTextField);
			StreetNumberTextField.setColumns(10);
		}
		{
			JLabel lblStreetNumber = new JLabel("Street NUmber");
			lblStreetNumber.setBounds(10, 200, 87, 14);
			contentPanel.add(lblStreetNumber);
		}
		//---------------------------------------------------------------
		{
			PostalCodeTextField = new JTextField();
			PostalCodeTextField.setBounds(150, 230, 114, 20);
			contentPanel.add(PostalCodeTextField);
			PostalCodeTextField.setColumns(10);
		}
		{
			JLabel lblPostalCode = new JLabel("Postal Code");
			lblPostalCode.setBounds(10, 233, 70, 14);
			contentPanel.add(lblPostalCode);
		}
		//--------------------------------------------------------------
		{
			CityTextField = new JTextField();
			CityTextField.setBounds(150, 263, 114, 20);
			contentPanel.add(CityTextField);
			CityTextField.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City");
			lblCity.setBounds(10, 266, 46, 14);
			contentPanel.add(lblCity);
		}
		//-----------------------------------------------------------
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveEmployee();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void saveEmployee(){
		
		String IRS_NumberStr = IRS_NumberTextField.getText();
		int IRS_Number = Integer.parseInt(IRS_NumberStr);
		String Social_Sec_NumberStr = Social_Sec_NumberTextField.getText();
		int Social_Sec_Number = Integer.parseInt(Social_Sec_NumberStr);
		String Driver_License = Driver_LicenseTextField.getText();
		String FirstName = FirstNameTextField.getText();
		String LastName = LastNameTextField.getText();
		String Street = StreetTextField.getText();
		String StreetNumberStr = StreetNumberTextField.getText();
		int StreetNumber= Integer.parseInt(StreetNumberStr);
		String PostalCodeStr = PostalCodeTextField.getText();
		int PostalCode = Integer.parseInt(PostalCodeStr);
		String City = CityTextField.getText();
		
		
		Employee tempEmployee = null;
		
		if(updateMode){
			tempEmployee = previousEmployee;
			tempEmployee.setEmployeeIRS_Number(IRS_Number);
			tempEmployee.setSocial_Sec_Number(Social_Sec_Number);
			tempEmployee.setDriver_License(Driver_License);
			tempEmployee.setLastName(LastName);
			tempEmployee.setFirstName(FirstName);
			tempEmployee.setStreet(Street);
			tempEmployee.setStreetNumber(StreetNumber);
			tempEmployee.setPostalCode(PostalCode);
			tempEmployee.setCity(City);
			
		}
		else{
			tempEmployee = new Employee(IRS_Number, Social_Sec_Number, Driver_License, FirstName, LastName, Street, StreetNumber, PostalCode, City);
		}
		
		try{
			if(updateMode){
				driver.updateEmployee(tempEmployee);
			}
			else{
				driver.addEmployee(tempEmployee);
			}
			
			setVisible(false);
			dispose();
			
			employeeSearchApp.refreshEmployeeView();
			
			JOptionPane.showMessageDialog(employeeSearchApp, "Employee added succesfully.", "Employee Added", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(employeeSearchApp, "Error saving employee: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	
	
}
