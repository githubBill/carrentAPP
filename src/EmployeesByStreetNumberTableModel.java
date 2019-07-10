import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class EmployeesByStreetNumberTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int FIRST_NAME_COL = 0;
	private static final int LAST_NAME_COL = 1;
	private static final int STREET_NUMBER_COL = 2;
	
	private String[] columnNames = {"First Name", "Last Name", "Street Number"};
	private List<EmployeesByStreetNumber> employees;
	
	public EmployeesByStreetNumberTableModel(List<EmployeesByStreetNumber> theEmployees){
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
		
		EmployeesByStreetNumber tempEmployee = employees.get(row);
		switch(col){
		case LAST_NAME_COL:
			return tempEmployee.getLastName();
		case FIRST_NAME_COL:
			return tempEmployee.getFirstName();
		case STREET_NUMBER_COL:
			return tempEmployee.getStreetNumber();
		default:
			return tempEmployee;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
