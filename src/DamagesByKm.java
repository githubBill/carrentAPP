public class DamagesByKm{
		
	private String damages;
	private int numVehicles;
	private int avgKilometers;
		
	public DamagesByKm(String damages, int numVehicles, int avgKilometers){
		
		super();
		this.damages = damages;
		this.numVehicles = numVehicles;
		this.avgKilometers = avgKilometers;
	}
	
	
	public String getDamages(){
		return this.damages;
	}
	
	public int getNumVehicles(){
		return this.numVehicles;
	}
	
	public int getAvgKilometers(){
		return this.avgKilometers;
	}
}
