import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class CustomerByDateTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int FIRSTNAME_COL = 0;
	private static final int LASTNAME_COL = 1;
	private static final int FIRSTREGISTRATION_COL = 2;
	
	private String[] columnNames = {"First Name", "Last Name", "First Registration Date"};
	private List<CustomerByDate> customers;
	
	public CustomerByDateTableModel(List<CustomerByDate> theCustomers){
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
		
		CustomerByDate tempCustomer = customers.get(row);
		switch(col){
		case FIRSTNAME_COL:
			return tempCustomer.getFirstName();
		case LASTNAME_COL:
			return tempCustomer.getLastName();
		case FIRSTREGISTRATION_COL:
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
