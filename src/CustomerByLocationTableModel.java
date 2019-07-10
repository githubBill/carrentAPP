import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class CustomerByLocationTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int FIRST_NAME_COL = 0;
	private static final int LAST_NAME_COL = 1;
	private static final int FINISHLOCATION_COL = 2;
	
	private String[] columnNames = {"First Name", "Last Name", "Reserved Finish Location"};
	private List<CustomerByLocation> customers;
	
	public CustomerByLocationTableModel(List<CustomerByLocation> theCustomers){
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
		
		CustomerByLocation tempCustomer = customers.get(row);
		switch(col){
		case FIRST_NAME_COL:
			return tempCustomer.getFirstName();
		case LAST_NAME_COL:
			return tempCustomer.getLastName();
		case FINISHLOCATION_COL:
			return tempCustomer.getFinishLocation();
		default:
			return tempCustomer;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
