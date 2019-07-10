public class VehicleKmAvg{

	private String LicensePlate;
	private int Kilometers;
		
	public VehicleKmAvg(String LicensePlate, int Kilometers){
		
		super();
		this.LicensePlate = LicensePlate;
		this.Kilometers = Kilometers;
		
	}

	public String getLicensePlate(){
		return this.LicensePlate;
	}
	
	public int getKilometers(){
		return this.Kilometers;
	}
	
}
