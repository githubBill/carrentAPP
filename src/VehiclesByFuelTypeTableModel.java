

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class VehiclesByFuelTypeTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int NAME_COL = 0;
	
	private String[] columnNames = {"Vehicle License Plate"};
	private List<String> vehicles;
	
	public VehiclesByFuelTypeTableModel(List<String> theVehicles){
		vehicles = theVehicles;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return vehicles.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		String tempVehicle = vehicles.get(row);
		switch(col){
		case NAME_COL:
			return tempVehicle;
		default:
			return tempVehicle;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
