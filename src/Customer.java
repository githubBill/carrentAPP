
@SuppressWarnings({"unused"})
public class Customer {

	private int CustomerID;  //primary key
	private int IRS_Number;
	private int Social_Sec_Number;
	private String LastName;
	private String FirstName;
	private String Driver_License;
	private String FirstRegistration;
	private String City;
	private int PostalCode;
	private String Street;
	private int StreetNumber;
	
	public Customer(int CustomerID, int IRS_Number, int Social_Sec_Number,  String LastName, String FirstName, String Driver_License, String FirstRegistration, String City, int PostalCode, String Street, int StreetNumber) {
		
		super();
		this.CustomerID = CustomerID;
		this.IRS_Number = IRS_Number;
		this.Social_Sec_Number = Social_Sec_Number;
		this.LastName = LastName;
		this.FirstName = FirstName;
		this.Driver_License = Driver_License;
		this.FirstRegistration = FirstRegistration;
		this.City = City;
		this.PostalCode = PostalCode;
		this.Street = Street;
		this.StreetNumber = StreetNumber; 
	}
	
	
	public int getCustomerID() {
		return this.CustomerID;
	}
	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}
	
	public int getIRS_Number() {
		return this.IRS_Number ;
	}
	public void setIRS_Number(int IRS_Number) {
		this.IRS_Number = IRS_Number;
	}
	
	public int getSocial_Sec_Number() {
		return this.Social_Sec_Number ;
	}
	public void setSocial_Sec_Number(int Social_Sec_Number) {
		this.Social_Sec_Number = Social_Sec_Number;
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
	
	public String getDriver_License() {
		return this.Driver_License ;
	}
	public void setDriver_License(String Driver_License) {
		this.Driver_License = Driver_License;
	}
	
	public String getFirstRegistration() {
		return this.FirstRegistration;
	}
	public void setFirstRegistration(String FirstRegistration) {
		this.FirstRegistration = FirstRegistration ;
	}
	
	public String getCity() {
		return this.City;
	}
	public void setCity(String City) {
		this.City = City ;
	}
	

	public int getPostalCode() {
		return this.PostalCode ;
	}
	public void setPostalCode(int PostalCode) {
		this.PostalCode = PostalCode;
	}
	
	public String getStreet() {
		return this.Street ;
	}
	public void setStreet(String Street) {
		this.Street = Street;
	}
	
	public int getStreetNumber() {
		return this.StreetNumber;
	}
	public void setStreetNumber(int StreetNumber) {
		this.StreetNumber = StreetNumber ;
	}
		
	
}
