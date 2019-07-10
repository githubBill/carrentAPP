
public class VehicleView1 {

	private String LicensePlate ;
	private String Model ;
	private String Make;
	private String Type;
	private int CylinderCapacity;
	private int HorsePower;
	
	public VehicleView1(String LicensePalte, String Model, String Make, String Type, int CylinderCapacity, int HorsePower) {
		
		super();
		this.LicensePlate = LicensePalte;
		this.Model = Model;
		this.Make = Make;
		this.Type = Type;
		this.CylinderCapacity = CylinderCapacity;
		this.HorsePower = HorsePower;
	}
	
	public String getLicensePlate() {
		return this.LicensePlate;
	}
	public void setLicensePlate(String LicensePlate) {
		this.LicensePlate = LicensePlate;
	}
	
	public String getModel() {
		return this.Model;
	}
	public void setModel(String Model) {
		this.Model = Model;
	}
	
	public String getMake() {
		return this.Make;
	}
	public void setMake(String Make) {
		this.Make = Make;
	}
	
	public String getType() {
		return this.Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	
	public int getCylinderCapacity() {
		return this.CylinderCapacity;
	}
	public void setCylinderCapacity(int CylinderCapacity) {
		this.CylinderCapacity = CylinderCapacity;
	}
	
	public int getHorsePower() {
		return this.HorsePower;
	}
	public void setHorsePower(int HorsePower) {
		this.HorsePower = HorsePower;
	}
	
}
