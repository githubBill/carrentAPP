
@SuppressWarnings({"unused"})
public class Store {

		private int StoreID ;  //primary key
		private String Street;
		private int StreetNumber;
		private int PostalCode;
		private String City;
		
		public Store(int StoreID, String Street, int StreetNumber, int PostalCode, String City) {
			
			super();
			this.StoreID = StoreID;
			this.Street = Street;
			this.StreetNumber = StreetNumber;
			this.PostalCode = PostalCode;
			this.City = City ;
		}
		
		public int getStoreID() {
			return this.StoreID;
		}
		public void setStoreID(int StoreID) {
			this.StoreID = StoreID;
		}
		
		public String getStoreStreet() {
			return this.Street;
		}
		public void setStoreStreet(String Street) {
			this.Street = Street;
		}
		
		public int getStoreStreetNumber() {
			return this.StreetNumber;
		}
		public void setStoreStreetNumber(int StreetNumber) {
			this.StreetNumber = StreetNumber;
		}
		
		public int getStorePostalCode() {
			return this.PostalCode;
		}
		public void setStorePostalCode(int PostalCode) {
			this.PostalCode = PostalCode;
		}
		
		public String getStoreCity() {
			return this.City;
		}
		public void setStoreCity(String City) {
			this.City = City;
		}
		
		
		
}
