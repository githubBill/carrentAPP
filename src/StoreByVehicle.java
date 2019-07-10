public class StoreByVehicle {
	
	private int StoreID ;
	private String City ;
	private int NumVehicles;
	
	public StoreByVehicle(int StoreID, String City, int NumVehicles) {
		
		super();
		this.StoreID = StoreID ;
		this.City = City;
		this.NumVehicles = NumVehicles;
		
	}
	
	public int getStoreID() {
		return this.StoreID;
	}
	
	
	public String getCity() {
		return this.City;
	}

	public int getNumVehicles() {
		return this.NumVehicles;
	}
	
/*	public void setStorebyVehicles(int NumVehicles) {
		this.NumVehicles = NumVehicles;
	}
	
	public void setStoreByVehiclesStoreID(int StoreID) {
		this.StoreID = StoreID;
	}
	public  void setStoreByVehiclesCity(String City) {
		this.City = City;
	}*/
	
	
}
