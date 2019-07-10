import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings({"serial"})
public class VehicleView1TableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	public static final int LICENSEPLATE_COL=0;
	public static final int MODEL_COL = 1;
	public static final int MAKE_COL = 2;
	public static final int TYPE_COL = 3;
	public static final int CYLINDERCAPACITY_COL = 4;
	public static final int HORSEPOWER_COL = 5;
	
	private String[] columnNames = {"License Plate", "Model", "Make", "Type", "Cylinder Capacity", "Horse Power"};
	private List<VehicleView1> vehicleViews1;
	

	public VehicleView1TableModel(List<VehicleView1> theVehicleViews1){
		vehicleViews1 = theVehicleViews1;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return vehicleViews1.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		
		VehicleView1 tempVehicleView1 = vehicleViews1.get(row);
		switch(col){
		case LICENSEPLATE_COL:
			return tempVehicleView1.getLicensePlate();
		case MODEL_COL:
			return tempVehicleView1.getModel();
		case MAKE_COL:
			return tempVehicleView1.getMake();
		case TYPE_COL:
			return tempVehicleView1.getType();
		case CYLINDERCAPACITY_COL:
			return tempVehicleView1.getCylinderCapacity();
		case HORSEPOWER_COL:
			return tempVehicleView1.getHorsePower();
		default:   
			return tempVehicleView1;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
	
	
}
