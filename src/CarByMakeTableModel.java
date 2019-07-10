import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class CarByMakeTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int LICENSEPLATE_COL = 0;
	private static final int MAKE_COL = 1;
	
	private String[] columnNames = {"License Plate", "Make"};
	private List<CarByMake> cars;
	
	public CarByMakeTableModel(List<CarByMake> theCars){
		cars = theCars;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return cars.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		CarByMake tempCar = cars.get(row);
		switch(col){
		case LICENSEPLATE_COL:
			return tempCar.getLicensePlate();
		case MAKE_COL:
			return tempCar.getMake();
		default:
			return tempCar;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
	
}
