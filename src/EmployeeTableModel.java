import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings({"serial"})
public class EmployeeTableModel  extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	public static final int IRS_NUMBER_COL =  0 ;
	public static final int SOS_SEC_NUMBER_COL = 1;
	public static final int DRIVER_LICENSE_COL = 2;
	private static final int FIRST_NAME_COL = 3;
	private static final int LAST_NAME_COL = 4;
	private static final int STREET_COL = 5;
	private static final int STREET_NUMBER_COL = 6;
	private static final int POSTAL_CODE_COL = 7;
	private static final int CITY_COL = 8;
	
	private String[] columnNames = {"IRS Number", "Social Security Number", "Driver License","First Name", "Last Name", "Street", "Street Number","Postal Code","City"};
	private List<Employee> employees;
	
	public EmployeeTableModel(List<Employee> theEmployees){
		employees = theEmployees;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		
		Employee tempEmployee = employees.get(row);
		switch(col){
		case IRS_NUMBER_COL:
			return tempEmployee.getEmployeeIRS_Number();
		case SOS_SEC_NUMBER_COL:
			return tempEmployee.getSocial_Sec_Number();
		case DRIVER_LICENSE_COL:
			return tempEmployee.getDriver_License();
		case FIRST_NAME_COL:
			return tempEmployee.getFirstName();
		case LAST_NAME_COL:
			return tempEmployee.getLastName();
		case STREET_COL:
			return tempEmployee.getStreet();
		case STREET_NUMBER_COL:
			return tempEmployee.getStreetNumber();
		case POSTAL_CODE_COL:
			return tempEmployee.getPostalCode();
		case CITY_COL:
			return tempEmployee.getCity();
		default:
			return tempEmployee;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
}
