public class EmployeePositionStore{
		
	private String IrsNumber;
	private String Position;
	private String City;
		
	public EmployeePositionStore(String IrsNumber, String Position, String City){
		
		super();
		this.IrsNumber = IrsNumber;
		this.Position = Position;
		this.City = City;
		
	}
	
	public String getIrsNumber(){
		return this.IrsNumber;
	}
	
	public String getPosition(){
		return this.Position;
	}
	
	public String getCity(){
		return this.City;
	}
}
