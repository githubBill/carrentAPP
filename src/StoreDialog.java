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
public class StoreDialog extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField StoreIDTextField;
	private JTextField StreetTextField;
	private JTextField StreetNumberTextField;
	private JTextField PostalCodeTextField;
	private JTextField CityTextField;
	
	private CRDriver driver;

	
	private CarRentDatabase storeSearchApp;
	private Store previousStore = null;
	private boolean updateMode = false;
	

	public StoreDialog(CarRentDatabase theStoreSearchApp, CRDriver theDriver, Store thePreviousStore, boolean theUpdateMode){
		this();
		driver = theDriver;
		storeSearchApp = theStoreSearchApp;
		previousStore = thePreviousStore;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Employee");
			populateGui(previousStore);
		}
	}
	
	private void populateGui(Store theStore) {
		
		StoreIDTextField.setText(new Integer(theStore.getStoreID()).toString());
		StreetTextField.setText(theStore.getStoreStreet());
		StreetNumberTextField.setText(new Integer(theStore.getStoreStreetNumber()).toString());
		PostalCodeTextField.setText(new Integer(theStore.getStorePostalCode()).toString());
		CityTextField.setText(theStore.getStoreCity());
		
	}
	
	
	/**
	 * Launch the application.
	 */
	//just for test does not need main    
	public static void main(String[] args) {
		try {
			StoreDialog dialog = new StoreDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the dialog.
	 */
	
	
	public StoreDialog() {
		setTitle("Add Store");
		setBounds(100, 100, 562, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	
		//-----------------------------------------------------
		CityTextField = new JTextField();
		CityTextField.setBounds(150, 149, 114, 20);
		contentPanel.add(CityTextField);
		CityTextField.setColumns(10);
		
		JLabel lblDriverLicense = new JLabel("City");
		lblDriverLicense.setBounds(19, 152, 101, 14);
		contentPanel.add(lblDriverLicense);
		//-----------------------------------------------------
		{
			StreetTextField = new JTextField();
			StreetTextField.setBounds(150, 51, 114, 20);
			contentPanel.add(StreetTextField);
			StreetTextField.setColumns(10);
		}
		{
			JLabel lblSocialSecurityNumber = new JLabel("Street");
			lblSocialSecurityNumber.setBounds(10, 51, 110, 20);
			contentPanel.add(lblSocialSecurityNumber);
		}
		//--------------------------------------------------------
		{
			StoreIDTextField = new JTextField();
			StoreIDTextField.setBounds(150, 21, 114, 20);
			contentPanel.add(StoreIDTextField);
			StoreIDTextField.setColumns(10);
		}
		{
			JLabel lblIrsNumber = new JLabel("Store ID");
			lblIrsNumber.setBounds(10, 24, 101, 16);
			contentPanel.add(lblIrsNumber);
		}
		//-------------------------------------------------------------
		
		{
			StreetNumberTextField = new JTextField();
			StreetNumberTextField.setBounds(150, 82, 114, 20);
			contentPanel.add(StreetNumberTextField);
			StreetNumberTextField.setColumns(10);
		}
		{
			JLabel lblStreetNumber = new JLabel("Street NUmber");
			lblStreetNumber.setBounds(10, 82, 87, 14);
			contentPanel.add(lblStreetNumber);
		}
		//---------------------------------------------------------------
		{
			PostalCodeTextField = new JTextField();
			PostalCodeTextField.setBounds(150, 113, 114, 20);
			contentPanel.add(PostalCodeTextField);
			PostalCodeTextField.setColumns(10);
		}
		{
			JLabel lblPostalCode = new JLabel("Postal Code");
			lblPostalCode.setBounds(10, 116, 70, 14);
			contentPanel.add(lblPostalCode);
		}
		//--------------------------------------------------------------
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveStore();
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
	
	
	protected void saveStore(){
		
		String StoreIDStr = StoreIDTextField.getText();
		int StoreID = Integer.parseInt(StoreIDStr);
		String Street = StreetTextField.getText();
		String StreetNumberStr = StreetNumberTextField.getText();
		int StreetNumber= Integer.parseInt(StreetNumberStr);
		String PostalCodeStr = PostalCodeTextField.getText();
		int PostalCode = Integer.parseInt(PostalCodeStr);
		String City = CityTextField.getText();
		
		
		Store tempStore = null;
		
		if(updateMode){
			
			tempStore = previousStore;
			tempStore.setStoreID(StoreID);
			tempStore.setStoreStreet(Street);
			tempStore.setStoreStreetNumber(StreetNumber);
			tempStore.setStorePostalCode(PostalCode);
			tempStore.setStoreCity(City);
			
		}
		else{
			tempStore = new Store(StoreID, Street, StreetNumber, PostalCode, City);
		}
		
		try{
			if(updateMode){
				driver.updateStore(tempStore);
			}
			else{
				driver.addStore(tempStore);
			}
			
			setVisible(false);
			dispose();
			
			storeSearchApp.refreshStoreView();
			
			JOptionPane.showMessageDialog(storeSearchApp, "Store added succesfully.", "Store Added", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(storeSearchApp, "Error saving employee: "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	

	
	
	
}
