
public class StoreContactView {

	private String City;
	private int PhoneNumber;
	private String Email;
	
	public StoreContactView(String City, int PhoneNumber, String Email) {
		
		super();
		this.City = City;
		this.PhoneNumber = PhoneNumber ;
		this.Email = Email;
	}
	
	public String getCity() {
		return this.City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	
	public int getPhoneNumber() {
		return this.PhoneNumber;
	}
	public void setPhoneNumber(int PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	
	public String getEmail() {
		return this.Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
}
