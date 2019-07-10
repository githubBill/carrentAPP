public class LocationByAmounts{
		
	private String StartLocation;
	private int PaymentAmount;
		
	public LocationByAmounts(String StartLocation, int PaymentAmount){
		
		super();
		this.StartLocation = StartLocation;
		this.PaymentAmount = PaymentAmount;
		
	}

	public String getLocationByAmountsStartLocation(){
		return this.StartLocation;
	}
	
	public int getLocationByAmountsPaymentAmount(){
		return this.PaymentAmount;
	}
}
