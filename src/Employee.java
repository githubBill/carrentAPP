
@SuppressWarnings({"unused"})
public class Employee {

	private int IRS_Number;  // primary key
	private int Social_Sec_Number;
	private String Driver_License;
	private String FirstName;
	private String LastName;
	private String Street;
	private int  StreetNumber;
	private int PostalCode;
	private String City;
	
	public Employee(int IRS_Number,int Social_Sec_Number, String Driver_License, String FirstName, String LastName, String Street, int StreetNumber, int PostalCode, String City) {
		
		super();
		this.IRS_Number = IRS_Number;
		this.Social_Sec_Number = Social_Sec_Number;
		this.Driver_License = Driver_License;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Street = Street;
		this.StreetNumber = StreetNumber;
		this.PostalCode = PostalCode ;
		this.City = City;
	}
	
	public int getEmployeeIRS_Number() {
		return this.IRS_Number ;
	}
	public void setEmployeeIRS_Number(int IRS_Number) {
		this.IRS_Number = IRS_Number;
	}
	
	public int getStreetNumber() {
		return this.StreetNumber;
	}
	public void setStreetNumber(int StreetNumber) {
		this.StreetNumber = StreetNumber ;
	}
	
	public int getSocial_Sec_Number() {
		return this.Social_Sec_Number ;
	}
	public void setSocial_Sec_Number(int Social_Sec_Number) {
		this.Social_Sec_Number = Social_Sec_Number;
	}
	
	public String getDriver_License() {
		return this.Driver_License ;
	}
	public void setDriver_License(String Driver_License) {
		this.Driver_License = Driver_License;
	}
	
	public String getFirstName() {
		return this.FirstName ;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public String getLastName() {
		return this.LastName ;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public String getStreet() {
		return this.Street ;
	}
	public void setStreet(String Street) {
		this.Street = Street;
	}
	
	public int getPostalCode() {
		return this.PostalCode ;
	}
	public void setPostalCode(int PostalCode) {
		this.PostalCode = PostalCode;
	}
	
	public String getCity() {
		return this.City;
	}
	public void setCity(String City) {
		this.City = City ;
	}
	
}
