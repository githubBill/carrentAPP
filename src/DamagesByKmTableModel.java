import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DamagesByKmTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int DAMAGES_COL = 0;
	private static final int NUM_VEHICLES_COL = 1;
	private static final int AVG_KILOMETERS_COL = 2;
	
	private String[] columnNames = {"Damages", "Number of Vehicles", "Average Kilometers"};
	private List<DamagesByKm> damages;
	
	public DamagesByKmTableModel(List<DamagesByKm> theDamages){
		damages = theDamages;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return damages.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DamagesByKm tempDamages = damages.get(row);
		switch(col){
		case DAMAGES_COL:
			return tempDamages.getDamages();
		case NUM_VEHICLES_COL:
			return tempDamages.getNumVehicles();
		case AVG_KILOMETERS_COL:
			return tempDamages.getAvgKilometers();
		default:
			return tempDamages;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
