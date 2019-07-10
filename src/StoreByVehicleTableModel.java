import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class StoreByVehicleTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int STOREID_COL = 0;
	private static final int CITY_COL = 1;
	private static final int NUMVEHICLES_COL = 2;
	
	private String[] columnNames = {"Store ID", "City", "Number of Vehicles"};
	private List<StoreByVehicle> stores;
	
	public StoreByVehicleTableModel(List<StoreByVehicle> theStores){
		stores = theStores;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return stores.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		StoreByVehicle tempStore = stores.get(row);
		switch(col){
		case STOREID_COL:
			return tempStore.getStoreID();
		case CITY_COL:
			return tempStore.getCity();
		case NUMVEHICLES_COL:
			return tempStore.getNumVehicles();
		default:
			return tempStore;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
