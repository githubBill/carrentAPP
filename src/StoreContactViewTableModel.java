import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings({"serial"})
public class StoreContactViewTableModel extends AbstractTableModel {
	
	public static final int OBJECT_COL = -1;
	public static final int CITY_COL = 0;
	public static final int PHONENUMBER_COL = 1;
	public static final int EMAIL_COL = 2;
	
	private String[] columnNames = {"City", "Phone Number", "Email Address"};
	private List<StoreContactView> storeContactViews;
	
	public StoreContactViewTableModel(List<StoreContactView> theStoreContactViews) {
		this.storeContactViews = theStoreContactViews;
	}
	

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return storeContactViews.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		
		StoreContactView tempStoreContactView = storeContactViews.get(row);
		switch(col){
		case CITY_COL:
			return tempStoreContactView.getCity();
		case PHONENUMBER_COL:
			return tempStoreContactView.getPhoneNumber();
		case EMAIL_COL:
			return tempStoreContactView.getEmail();
		default:   
			return tempStoreContactView;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
