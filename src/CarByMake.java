public class CarByMake{
		
	private String LicensePlate;
	private String Make;
		
	public CarByMake(String LicensePlate, String Make){
		
		super();
		this.LicensePlate = LicensePlate;
		this.Make = Make;
		
	}

	public String getLicensePlate(){
		return this.LicensePlate;
	}
	
	public String getMake(){
		return this.Make;
	}
	
}
