public class CustomerByLocation{
		
	private String FirstName;
	private String LastName;
	private String FinishLocation;
		
	public CustomerByLocation(String FirstName, String LastName, String FinishLocation){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.FinishLocation = FinishLocation;
	}
	
	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public String getFinishLocation(){
		return this.FinishLocation;
	}
}
