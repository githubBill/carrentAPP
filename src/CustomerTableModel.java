import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings({"serial"})
public class CustomerTableModel  extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	public static final int CUSTOMER_ID_COL = 0;
	public static final int IRS_NUMBER_COL =  1 ;
	public static final int SOS_SEC_NUMBER_COL = 2;
	private static final int LAST_NAME_COL = 3;
	private static final int FIRST_NAME_COL = 4;
	public static final int DRIVER_LICENSE_COL = 5;
	public static final int FIRST_REGISTRATION_COL = 6;
	private static final int CITY_COL = 7;
	private static final int POSTAL_CODE_COL = 8;
	private static final int STREET_COL = 9;
	private static final int STREET_NUMBER_COL = 10;
	
	private String[] columnNames = {"Customer ID","IRS Number", "Social Security Number", "Last Name", "First Name","Driver License", "First Registration", "City", "Postal Code", "Street", "Street Number"};
	private List<Customer> customers;
	
	public CustomerTableModel(List<Customer> theCustomers){
		customers = theCustomers;
	}
	

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return customers.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	
	@Override
	public Object getValueAt(int row, int col) {
		
		Customer tempCustomer = customers.get(row);
		switch(col){
		case CUSTOMER_ID_COL:
			return tempCustomer.getCustomerID();
		case IRS_NUMBER_COL:
			return tempCustomer.getIRS_Number();
		case SOS_SEC_NUMBER_COL:
			return tempCustomer.getSocial_Sec_Number();
		case DRIVER_LICENSE_COL:
			return tempCustomer.getDriver_License();
		case FIRST_NAME_COL:
			return tempCustomer.getFirstName();
		case LAST_NAME_COL:
			return tempCustomer.getLastName();
		case STREET_COL:
			return tempCustomer.getStreet();
		case STREET_NUMBER_COL:
			return tempCustomer.getStreetNumber();
		case POSTAL_CODE_COL:
			return tempCustomer.getPostalCode();
		case CITY_COL:
			return tempCustomer.getCity();
		case FIRST_REGISTRATION_COL:
			return tempCustomer.getFirstRegistration();
		default:
			return tempCustomer;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
