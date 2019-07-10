import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings({"serial"})
public class StoreTableModel  extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	public static final int STORE_ID_COL = 0;
	public static final int STREET_COL = 1;
	public static final int STREET_NUMBER_COL = 2;
	public static final int POSTAL_CODE_COL = 3;
	public static final int CITY_COL = 4;
	
	private String[] columnNames = {"Store ID", "Street", "Street Number","Postal Code","City"};
	private List<Store> stores;
	
	public StoreTableModel(List<Store> theStores){
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
		
		Store tempStore = stores.get(row);
		switch(col){
		case STORE_ID_COL:
			return tempStore.getStoreID();
		case STREET_COL:
			return tempStore.getStoreStreet();
		case STREET_NUMBER_COL:
			return tempStore.getStoreStreetNumber();
		case POSTAL_CODE_COL:
			return tempStore.getStorePostalCode();
		case CITY_COL:
			return tempStore.getStoreCity();
		default:
			return tempStore;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
	
}
