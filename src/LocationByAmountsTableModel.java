import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class LocationByAmountsTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int STARTLOCATION_COL = 0;
	private static final int PAYMENTAMOUNT = 1;
	
	private String[] columnNames = {"Start Location", "Total Payment Amount"};
	private List<LocationByAmounts> locations;
	
	public LocationByAmountsTableModel(List<LocationByAmounts> theLocations){
		locations = theLocations;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return locations.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		LocationByAmounts tempLocation = locations.get(row);
		switch(col){
		case STARTLOCATION_COL:
			return tempLocation.getLocationByAmountsStartLocation();
		case PAYMENTAMOUNT:
			return tempLocation.getLocationByAmountsPaymentAmount();
		default:
			return tempLocation;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
