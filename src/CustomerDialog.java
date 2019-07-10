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
public class CustomerDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField CustomerIDTextField;
	private JTextField IRS_NumberTextField;
	private JTextField Social_Sec_NumberTextField;
	private JTextField LastNameTextField;
	private JTextField FirstNameTextField;
	private JTextField Driver_LicenseTextField;
	private JTextField FirstRegistrationTextFiedl;
	private JTextField CityTextField;
	private JTextField PostalCodeTextField;
	private JTextField StreetTextField;
	private JTextField StreetNumberTextField;
	
	private CRDriver driver;
	
	private CarRentDatabase customerSearchApp;
	private Customer previousCustomer = null;
	private boolean updateMode = false;

	
	
	
	public CustomerDialog(CarRentDatabase theCustomerSearchApp, CRDriver theDriver, Customer thePreviousCustomer, boolean theUpdateMode){
		this();
		driver = theDriver;
		customerSearchApp = theCustomerSearchApp;
		previousCustomer = thePreviousCustomer;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Customer");
			populateGui(previousCustomer);
		}
	}
	
	
	private void populateGui(Customer theCustomer) {
		
		CustomerIDTextField.setText(new Integer(theCustomer.getCustomerID()).toString());
		IRS_NumberTextField.setText(new Integer(theCustomer.getIRS_Number()).toString());
		Social_Sec_NumberTextField.setText(new Integer(theCustomer.getSocial_Sec_Number()).toString());
		LastNameTextField.setText(theCustomer.getLastName());
		FirstNameTextField.setText(theCustomer.getFirstName());
		Driver_LicenseTextField.setText(theCustomer.getDriver_License());
		FirstRegistrationTextFiedl.setText(theCustomer.getFirstRegistration());
		CityTextField.setText(theCustomer.getCity());
		PostalCodeTextField.setText(new Integer(theCustomer.getPostalCode()).toString());
		StreetTextField.setText(theCustomer.getStreet());
		StreetNumberTextField.setText(new Integer(theCustomer.getStreetNumber()).toString());
		
	}
	
	
	/**
	 * Launch the application.
	 */
	//just for test does not need main     

	public static void main(String[] args) {
		try {
			CustomerDialog dialog = new CustomerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the dialog.
	 */
	
	

	public CustomerDialog() {
		setTitle("Add Customer");
		setBounds(100, 100, 704, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel lblNewLabel = new JLabel("First Name");
			lblNewLabel.setBounds(10, 215, 101, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			FirstNameTextField = new JTextField();
			FirstNameTextField.setBounds(150, 212, 131, 19);
			contentPanel.add(FirstNameTextField);
			FirstNameTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(10, 185, 101, 15);
			contentPanel.add(lblLastName);
		}
		{
			LastNameTextField = new JTextField();
			LastNameTextField.setBounds(150, 182, 131, 19);
			contentPanel.add(LastNameTextField);
			LastNameTextField.setColumns(10);
		}
		//-----------------------------------------------------
		Driver_LicenseTextField = new JTextField();
		Driver_LicenseTextField.setBounds(150, 151, 131, 20);
		contentPanel.add(Driver_LicenseTextField);
		Driver_LicenseTextField.setColumns(10);
		
		JLabel lblDriverLicense = new JLabel("Driver License\r\n");
		lblDriverLicense.setBounds(10, 154, 101, 14);
		contentPanel.add(lblDriverLicense);
		//-----------------------------------------------------
		{
			Social_Sec_NumberTextField = new JTextField();
			Social_Sec_NumberTextField.setBounds(150, 89, 131, 20);
			contentPanel.add(Social_Sec_NumberTextField);
			Social_Sec_NumberTextField.setColumns(10);
		}
		{
			JLabel lblSocialSecurityNumber = new JLabel("Social Security Number");
			lblSocialSecurityNumber.setBounds(10, 89, 110, 20);
			contentPanel.add(lblSocialSecurityNumber);
		}
		//--------------------------------------------------------
		{
			IRS_NumberTextField = new JTextField();
			IRS_NumberTextField.setBounds(150, 58, 131, 20);
			contentPanel.add(IRS_NumberTextField);
			IRS_NumberTextField.setColumns(10);
		}
		{
			JLabel lblIrsNumber = new JLabel("IRS Number");
			lblIrsNumber.setBounds(10, 62, 101, 16);
			contentPanel.add(lblIrsNumber);
		}
		//-------------------------------------------------------------
		{
			StreetTextField = new JTextField();
			StreetTextField.setBounds(150, 242, 131, 20);
			contentPanel.add(StreetTextField);
			StreetTextField.setColumns(10);
		}
		{
			JLabel lblStreet = new JLabel("Street");
			lblStreet.setBounds(10, 245, 46, 14);
			contentPanel.add(lblStreet);
		}
		//---------------------------------------------------------
		{
			StreetNumberTextField = new JTextField();
			StreetNumberTextField.setBounds(150, 273, 131, 20);
			contentPanel.add(StreetNumberTextField);
			StreetNumberTextField.setColumns(10);
		}
		{
			JLabel lblStreetNumber = new JLabel("Street NUmber");
			lblStreetNumber.setBounds(10, 276, 87, 14);
			contentPanel.add(lblStreetNumber);
		}
		//---------------------------------------------------------------
		{
			PostalCodeTextField = new JTextField();
			PostalCodeTextField.setBounds(150, 304, 131, 20);
			contentPanel.add(PostalCodeTextField);
			PostalCodeTextField.setColumns(10);
		}
		{
			JLabel lblPostalCode = new JLabel("Postal Code");
			lblPostalCode.setBounds(10, 307, 70, 14);
			contentPanel.add(lblPostalCode);
		}
		//--------------------------------------------------------------
		{
			CityTextField = new JTextField();
			CityTextField.setBounds(150, 334, 131, 20);
			contentPanel.add(CityTextField);
			CityTextField.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City");
			lblCity.setBounds(10, 337, 46, 14);
			contentPanel.add(lblCity);
		}
		//----------------------------------------------------------------
		{
			CustomerIDTextField = new JTextField();
			CustomerIDTextField.setBounds(148, 27, 133, 20);
			contentPanel.add(CustomerIDTextField);
			CustomerIDTextField.setColumns(10);
		}
		{
			JLabel lblCustomerId = new JLabel("Customer ID");
			lblCustomerId.setBounds(10, 30, 87, 14);
			contentPanel.add(lblCustomerId);
		}
		//---------------------------------------------------------------
		FirstRegistrationTextFiedl = new JTextField();
		FirstRegistrationTextFiedl.setBounds(150, 120, 131, 20);
		contentPanel.add(FirstRegistrationTextFiedl);
		FirstRegistrationTextFiedl.setColumns(10);
		
		JLabel lblFirstRegistration = new JLabel("First Registration");
		lblFirstRegistration.setBounds(10, 123, 101, 14);
		contentPanel.add(lblFirstRegistration);
		//-----------------------------------------------------------
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveCustomer();
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
	
	
	protected void saveCustomer(){
	
		String CustomerIDStr = CustomerIDTextField.getText();
		int CustomerID = Integer.parseInt(CustomerIDStr);
		String IRS_NumberStr = IRS_NumberTextField.getText();
		int IRS_Number = Integer.parseInt(IRS_NumberStr);
		String Social_Sec_NumberStr = Social_Sec_NumberTextField.getText();
		int Social_Sec_Number = Integer.parseInt(Social_Sec_NumberStr);
		String LastName = LastNameTextField.getText();
		String FirstName = FirstNameTextField.getText();
		String Driver_License = Driver_LicenseTextField.getText();
		String FirstRegistration = FirstRegistrationTextFiedl.getText();
		String City = CityTextField.getText();
		String PostalCodeStr = PostalCodeTextField.getText();
		int PostalCode = Integer.parseInt(PostalCodeStr);
		String Street = StreetTextField.getText();
		String StreetNumberStr = StreetNumberTextField.getText();
		int StreetNumber= Integer.parseInt(StreetNumberStr);
		
		
		
		
		
		Customer tempCustomer = null;
		
		if(updateMode){
			tempCustomer = previousCustomer;
			tempCustomer.setCustomerID(CustomerID);
			tempCustomer.setIRS_Number(IRS_Number);
			tempCustomer.setSocial_Sec_Number(Social_Sec_Number);
			tempCustomer.setDriver_License(Driver_License);
			tempCustomer.setFirstRegistration(FirstRegistration);
			tempCustomer.setLastName(LastName);
			tempCustomer.setFirstName(FirstName);
			tempCustomer.setStreet(Street);
			tempCustomer.setStreetNumber(StreetNumber);
			tempCustomer.setPostalCode(PostalCode);
			tempCustomer.setCity(City);
			
		}
		else{
			tempCustomer =  new Customer(CustomerID, IRS_Number, Social_Sec_Number, LastName, FirstName, Driver_License, FirstRegistration, City, PostalCode, Street, StreetNumber);
		}
		
		try{
			if(updateMode){
				driver.updateCustomer(tempCustomer);
			}
			else{
				driver.addCustomer(tempCustomer);
			}
			
			setVisible(false);
			dispose();
			
			customerSearchApp.refreshCustomerView();
			
			JOptionPane.showMessageDialog(customerSearchApp, "Customer added succesfully.", "Customer Added", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(customerSearchApp, "Error : "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
