import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class VehicleKmAvgTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int LICENSEPLATE_COL = 0;
	private static final int KILOMETERS_COL = 1;
	
	private String[] columnNames = {"License Plate", "Kilometers"};
	private List<VehicleKmAvg> vehicles;
	
	public VehicleKmAvgTableModel(List<VehicleKmAvg> theVehicles){
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
		
		VehicleKmAvg tempVehicle = vehicles.get(row);
		switch(col){
		case LICENSEPLATE_COL:
			return tempVehicle.getLicensePlate();
		case KILOMETERS_COL:
			return tempVehicle.getKilometers();
		default:
			return tempVehicle;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
