public class CustomerByDate{
		
	private String FirstName;
	private String LastName;
	private String FirstRegistration;
		
	public CustomerByDate(String FirstName, String LastName, String FirstRegistration){
		
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.FirstRegistration = FirstRegistration;
		
	}
	
	public String getLastName(){
		return this.LastName;
	}	
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public String getFirstName(){
		return this.FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public String getFirstRegistration(){
		return this.FirstRegistration;
	}
	public void setFirstRegistration(String FirstRegistration) {
		this.FirstRegistration = FirstRegistration;
	}
	
}
