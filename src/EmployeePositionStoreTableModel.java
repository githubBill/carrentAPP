import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class EmployeePositionStoreTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int IRSNUMBER_COL = 0;
	private static final int POSITION_COL = 1;
	private static final int CITY_COL = 2;
	
	private String[] columnNames = {"IRS Number", "Position", "Store City"};
	private List<EmployeePositionStore> employees;
	
	public EmployeePositionStoreTableModel(List<EmployeePositionStore> theEmployees){
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
		
		EmployeePositionStore tempEmployee = employees.get(row);
		switch(col){
		case IRSNUMBER_COL:
			return tempEmployee.getIrsNumber();
		case POSITION_COL:
			return tempEmployee.getPosition();
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
