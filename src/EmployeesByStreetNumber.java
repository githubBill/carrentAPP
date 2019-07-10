public class EmployeesByStreetNumber{
		
	private String FirstName;
	private String LastName;
	private int StreetNumber;
		
	public EmployeesByStreetNumber(String FirstName, String LastName, int StreetNumber){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.StreetNumber = StreetNumber;
		
	}
	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public int getStreetNumber(){
		return this.StreetNumber;
	}
}
