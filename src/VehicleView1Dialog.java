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
public class VehicleView1Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField LicensePlateTextField;
	private JTextField ModelTextField;
	private JTextField MakeTextField;
	private JTextField TypeTextField;
	private JTextField CylinderCapacityTextField;
	private JTextField HorsePowerTextField;
	
	private CRDriver driver;
	
	private CarRentDatabase vehicleView1SearchApp;
	private VehicleView1 previousVehicleView1 = null;
	private boolean updateMode = false;

	
	
	public VehicleView1Dialog(CarRentDatabase theVehicleView1SearchApp, CRDriver theDriver, VehicleView1 thePreviousVehicleView1, boolean theUpdateMode){
		this();
		driver = theDriver;
		vehicleView1SearchApp = theVehicleView1SearchApp;
		previousVehicleView1 = thePreviousVehicleView1;
		updateMode = theUpdateMode;
		
		if(updateMode){
			setTitle("Update Customer");
			populateGui(previousVehicleView1);
		}
	}
	
	
	private void populateGui(VehicleView1 theVehicleView1) {
		
		LicensePlateTextField.setText(theVehicleView1.getLicensePlate());
		ModelTextField.setText(theVehicleView1.getModel());
		MakeTextField.setText(theVehicleView1.getMake());
		TypeTextField.setText(theVehicleView1.getType());
		CylinderCapacityTextField.setText(new Integer(theVehicleView1.getCylinderCapacity()).toString());
		HorsePowerTextField.setText(new Integer(theVehicleView1.getHorsePower()).toString());
		
	}
	
	
	/**
	 * Launch the application.
	 */
	//just for test does not need main     

	public static void main(String[] args) {
		try {
			VehicleView1Dialog dialog = new VehicleView1Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the dialog.
	 */
	
	
	public VehicleView1Dialog() {
		setTitle("Add VehicleView1");
		setBounds(100, 100, 656, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//-----------------------------------------------------
		ModelTextField = new JTextField();
		ModelTextField.setBounds(150, 128, 131, 20);
		contentPanel.add(ModelTextField);
		ModelTextField.setColumns(10);
		
		JLabel lblDriverLicense = new JLabel("Model");
		lblDriverLicense.setBounds(10, 131, 101, 14);
		contentPanel.add(lblDriverLicense);
		//-----------------------------------------------------
		{
			MakeTextField = new JTextField();
			MakeTextField.setBounds(150, 89, 131, 20);
			contentPanel.add(MakeTextField);
			MakeTextField.setColumns(10);
		}
		{
			JLabel lblSocialSecurityNumber = new JLabel("Make");
			lblSocialSecurityNumber.setBounds(10, 89, 110, 20);
			contentPanel.add(lblSocialSecurityNumber);
		}
		//--------------------------------------------------------
		{
			TypeTextField = new JTextField();
			TypeTextField.setBounds(150, 58, 131, 20);
			contentPanel.add(TypeTextField);
			TypeTextField.setColumns(10);
		}
		{
			JLabel lblIrsNumber = new JLabel("Type");
			lblIrsNumber.setBounds(10, 62, 101, 16);
			contentPanel.add(lblIrsNumber);
		}
		//-------------------------------------------------------------
		{
			CylinderCapacityTextField = new JTextField();
			CylinderCapacityTextField.setBounds(150, 168, 131, 20);
			contentPanel.add(CylinderCapacityTextField);
			CylinderCapacityTextField.setColumns(10);
		}
		{
			JLabel lblStreet = new JLabel("Cylinder Capacity");
			lblStreet.setBounds(10, 171, 87, 14);
			contentPanel.add(lblStreet);
		}
		//---------------------------------------------------------
		{
			HorsePowerTextField = new JTextField();
			HorsePowerTextField.setBounds(150, 210, 131, 20);
			contentPanel.add(HorsePowerTextField);
			HorsePowerTextField.setColumns(10);
		}
		{
			JLabel lblStreetNumber = new JLabel("Horse Power");
			lblStreetNumber.setBounds(10, 213, 87, 14);
			contentPanel.add(lblStreetNumber);
		}
		
		LicensePlateTextField = new JTextField();
		LicensePlateTextField.setBounds(146, 27, 135, 20);
		contentPanel.add(LicensePlateTextField);
		LicensePlateTextField.setColumns(10);
		
		JLabel lblLicensePlate = new JLabel("License Plate");
		lblLicensePlate.setBounds(10, 30, 68, 14);
		contentPanel.add(lblLicensePlate);
		//---------------------------------------------------------------
	
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveVehicleView1();
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
	
	
	
	protected void saveVehicleView1(){
		
		String LicensePlate = LicensePlateTextField.getText();
		String Model = ModelTextField.getText();
		String Make = MakeTextField.getText();
		String Type = TypeTextField.getText();
		String CylinderCapacityStr = CylinderCapacityTextField.getText();
		int CylinderCapacity = Integer.parseInt(CylinderCapacityStr);
		String HorsePowerStr = HorsePowerTextField.getText();
		int HorsePower = Integer.parseInt(HorsePowerStr);
		
		VehicleView1 tempVehicleView1 = null;
		
		if(updateMode){
			tempVehicleView1 = previousVehicleView1;
			tempVehicleView1.setModel(Model);
			tempVehicleView1.setMake(Make);
			tempVehicleView1.setType(Type);
			tempVehicleView1.setCylinderCapacity(CylinderCapacity);
			tempVehicleView1.setHorsePower(HorsePower);
			
		}
		else{
			tempVehicleView1 =  new VehicleView1(LicensePlate ,Model, Make, Type, CylinderCapacity, HorsePower);
		}
		
		try{
			if(updateMode){
				driver.updateVehicleView1(tempVehicleView1);
			}
			else{
				driver.addVehicleView1(tempVehicleView1);
			}
			
			setVisible(false);
			dispose();
			
			vehicleView1SearchApp.refreshVehicleView1();
			
			JOptionPane.showMessageDialog(vehicleView1SearchApp, "Vehicle(view) added succesfully.", "Vehicle(view) Added", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception exc){
			JOptionPane.showMessageDialog(vehicleView1SearchApp, "Error : "+exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
