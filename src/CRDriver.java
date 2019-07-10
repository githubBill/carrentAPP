import java.sql.*;
import java.util.*;

import javax.swing.JFrame;



import java.io.*;

@SuppressWarnings({"unused"})
public class CRDriver {

	private static Connection myConn;
	
	public CRDriver() throws Exception {

		// get database properties
		Properties props = new Properties();
		props.load(new FileInputStream("connection.properties"));

		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");

		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);

		System.out.println("DB connection successful to: " + dburl);
	}
	
	//----------------------------------------
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

				if (myRs != null) {
					myRs.close();
				}

				if (myStmt != null) {

				}

				if (myConn != null) {
					myConn.close();
				}
			}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);
	}
	//---------------------------------------
	
	private Employee rowToEmployee(ResultSet myRs) throws SQLException {

		int IRS_Number = myRs.getInt("IRS Number");
		int Social_Sec_Number = myRs.getInt("Social Security Number");
		String Driver_License = myRs.getString("Driver License");
		String FirstName = myRs.getString("First Name");
		String LastName = myRs.getString("Last Name");
		String Street = myRs.getString("Street");
		int StreetNumber = myRs.getInt("Street Number");
		int PostalCode = myRs.getInt("Postal Code");
		String City = myRs.getString("City");
		
		Employee tempEmployee = new Employee(IRS_Number, Social_Sec_Number, Driver_License, FirstName, LastName, Street, StreetNumber, PostalCode, City );

		return tempEmployee;
	}
	
	private Store rowToStore(ResultSet myRs) throws SQLException {
		
		int StoreID = myRs.getInt("Store ID");
		String Street = myRs.getString("Street");
		int StreetNumber = myRs.getInt("Street Number");
		int PostalCode = myRs.getInt("Postal Code");
		String City = myRs.getString("City");
		
		Store tempStore = new Store(StoreID, Street, StreetNumber, PostalCode, City);
		
		return tempStore;
		
	}
	
	public Customer rowToCustomer(ResultSet myRs) throws SQLException{
		
		int CustomerID = myRs.getInt("Customer ID");
		int IRS_Number = myRs.getInt("IRS Number");
		int Social_Sec_Number = myRs.getInt("Social Security Number");
		String LastName = myRs.getString("Last Name");
		String FirstName = myRs.getString("First Name");
		String Driver_License = myRs.getString("Driver License");
		String FirstRegistration = myRs.getString("First Registration");
		String City = myRs.getString("City");
		int PostalCode = myRs.getInt("Postal Code");
		String Street = myRs.getString("Street");
		int StreetNumber = myRs.getInt("Street Number");
		
		Customer tempCustomer = new Customer(CustomerID, IRS_Number, Social_Sec_Number, LastName, FirstName, Driver_License, FirstRegistration, City, PostalCode, Street, StreetNumber);
		
		return tempCustomer ;
		
	}
	//----------------------------------------------------------------------------------------------------------------------
	//views convert and get methods
	private VehicleView1 convertRowToVehicleView1(ResultSet myRs) throws SQLException{
		
		String LicensePlate = myRs.getString("License Plate");
		String Model = myRs.getString("Model");
		String Make = myRs.getString("Make");
		String Type = myRs.getString("Type");
		int CylinderCapacity = myRs.getInt("Cylinder Capacity");
		int HorsePower = myRs.getInt("Horse Power");
		
		VehicleView1 tempVehicleView1 = new VehicleView1(LicensePlate, Model, Make, Type, CylinderCapacity, HorsePower);
		
		return tempVehicleView1;
	}
	
	
	public List<VehicleView1> getAllVehicleView1() throws Exception{
		List<VehicleView1> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try{
			
			myStmt = myConn.prepareStatement("select * from VehicleView1;");
			
			myRs = myStmt.executeQuery();

			while(myRs.next()){
				VehicleView1 tempVehicleView1 = convertRowToVehicleView1(myRs);
				list.add(tempVehicleView1);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	private StoreContactView convertRowToStoreContactView(ResultSet myRs) throws SQLException{
		
		String City = myRs.getString("City");
		int PhoneNumber = myRs.getInt("Phone Number");
		String Email = myRs.getString("Name_exp_3");
		
		StoreContactView theStoreContactView = new StoreContactView(City, PhoneNumber, Email);
		
		return theStoreContactView;
		
	}
	
	public List<StoreContactView> getAlltheStoreContactView() throws Exception{
		List<StoreContactView> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try{
			
			myStmt = myConn.prepareStatement("select * from StoreContactInfo;");
			
			myRs = myStmt.executeQuery();

			while(myRs.next()){
				StoreContactView tempStoreContactView = convertRowToStoreContactView(myRs);
				list.add(tempStoreContactView);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
		
		
	}
	

	//-----------------------------------------------------------------------------------------------------------
	
	private EmployeesByStreetNumber convertRowToEmployeesByStreetNumber(ResultSet myRs) throws SQLException {

		String firstName = myRs.getString("First Name");
		String lastName = myRs.getString("Last Name");
		int streetNumber = myRs.getInt("Street Number");

		EmployeesByStreetNumber tempEmployee = new EmployeesByStreetNumber(firstName, lastName, streetNumber);

		return tempEmployee;
	}
	
	private CarByMake convertRowToCarByMake(ResultSet myRs) throws SQLException {

		String licensePlate = myRs.getString("License Plate");
		String make = myRs.getString("Make");

		CarByMake tempCar = new CarByMake(licensePlate, make);

		return tempCar;
	}
	
	//----------------------------------------------------------------------------------------------------------
	public List<EmployeesByStreetNumber> searchEmployeesByStreetNumber(int streetNumber) throws Exception{
		List<EmployeesByStreetNumber> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			//formula += "%";
			myStmt = myConn.prepareStatement("select  `First Name`,`Last Name`,`Street Number` from Employee group by `Last Name` having `Street Number` > ? order by `Street Number` desc;");

			myStmt.setInt(1, streetNumber);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				EmployeesByStreetNumber tempEmployee = convertRowToEmployeesByStreetNumber(myRs);
				list.add(tempEmployee);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	public List<EmployeesByStreetNumber> getAllEmployeesByStreetNumber() throws Exception{
		List<EmployeesByStreetNumber> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.prepareStatement("select Employee.`First Name`, Employee.`Last Name`, Employee.`Street Number`from Employee;");

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				EmployeesByStreetNumber tempEmployee = convertRowToEmployeesByStreetNumber(myRs);
				list.add(tempEmployee);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	private StoreByVehicle convertRowToStoreByVehicle(ResultSet myRs) throws SQLException {

		int StoreID = myRs.getInt("Store ID");
		String City = myRs.getString("City");
		int numVehicles = myRs.getInt("COUNT(Vehicle.`Store Id`)");

		StoreByVehicle tempStore = new StoreByVehicle(StoreID, City, numVehicles);

		return tempStore;
	}
	

	public List<StoreByVehicle> getStoreByVehicle() throws Exception{

		List<StoreByVehicle> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select Store.`Store ID` , Store.`City` , count(Vehicle.`Store ID`) from Store right join Vehicle on Store.`Store ID` =  Vehicle.`Store ID` group by Store.`Store ID` order by count(Vehicle.`Store ID`) desc ;");
			
			while(myRs.next()){
				StoreByVehicle tempStore= convertRowToStoreByVehicle(myRs);
				list.add(tempStore);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	private EmployeePositionStore convertRowToEmployeePositionStore(ResultSet myRs) throws SQLException {

		String IrsNumber = myRs.getString("IRS Number");
		String Position = myRs.getString("Position");
		String City = myRs.getString("(select City from Store where Store.`Store ID` = w.`Store ID`)");

		EmployeePositionStore tempEmployee = new EmployeePositionStore(IrsNumber, Position, City);

		return tempEmployee;
	}
	
	
	public List<EmployeePositionStore> getEmployeePositionStore() throws Exception{

		List<EmployeePositionStore> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select e.`IRS Number`, City , Position, (select City from Store where Store.`Store ID` = w.`Store ID`) from Employee e inner join Works w on e.`IRS Number` = w.`IRS Number`;");
			
			while(myRs.next()){
				EmployeePositionStore tempEmployee= convertRowToEmployeePositionStore(myRs);
				list.add(tempEmployee);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	
	//---------------------------------------------------------------------------------------------------------------
	
	public List<CarByMake> searchMake(String make) throws Exception{
		List<CarByMake> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			make += "%";
			myStmt = myConn.prepareStatement("select `License Plate`, Make from Vehicle where Make like ?;");

			myStmt.setString(1, make);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				CarByMake tempCar = convertRowToCarByMake(myRs);
				list.add(tempCar);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	
	public List<CarByMake> getCarByMake() throws Exception{

		List<CarByMake> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select `License Plate`, Make from Vehicle order by Make ASC");
			
			while(myRs.next()){
				CarByMake tempCar = convertRowToCarByMake(myRs);
				list.add(tempCar);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	//------------------------------------------------------------------------------------------------------------------
	
	private VehicleKmAvg convertRowToVehicleKmAvg(ResultSet myRs) throws SQLException {

		String Name = myRs.getString("License Plate");
		int avg = myRs.getInt("Kilometers");

		VehicleKmAvg tempVehicle = new VehicleKmAvg(Name, avg);

		return tempVehicle;
	}
	
	public List<VehicleKmAvg> getVehicleKmAvg() throws Exception{

		List<VehicleKmAvg> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select distinct `License Plate`, Kilometers from Vehicle where Kilometers > (select avg(Kilometers) from Vehicle);");
			
			while(myRs.next()){
				VehicleKmAvg tempVehicle= convertRowToVehicleKmAvg(myRs);
				list.add(tempVehicle);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	//----------------------------------------------------------------------------------------------------------------------
	
	private CustomerByDate convertRowToCustomerByDate(ResultSet myRs) throws SQLException {

		String FirstName = myRs.getString("First Name");
		String LastName = myRs.getString("Last Name");
		String FirstRegistration = myRs.getString("First Registration");

		CustomerByDate tempCustomer = new CustomerByDate(FirstName, LastName, FirstRegistration);

		return tempCustomer;
	}


	public List<CustomerByDate> getCustomerByDate() throws Exception{

		List<CustomerByDate> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
		
			myRs = myStmt.executeQuery("select c.`First Name`, c.`Last Name`, c.`First Registration` from Customer c order by c.`First Registration`;");
		
			while(myRs.next()){
				CustomerByDate tempCustomer= convertRowToCustomerByDate(myRs);
				list.add(tempCustomer);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}	

	}
	//--------------------------------------------------------------------------------------------------------------------
	
	private CustomerByLocation convertRowToCustomerByLocation(ResultSet myRs) throws SQLException {

		String firstName = myRs.getString("First Name");
		String lastName = myRs.getString("Last Name");
		String FinishLocation = myRs.getString("Finish Location");

		CustomerByLocation tempCustomer = new CustomerByLocation(firstName, lastName, FinishLocation);

		return tempCustomer;
	}

	
	public List<CustomerByLocation> getCustomerByLocation() throws Exception{

		List<CustomerByLocation> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select c.`First Name`, c.`Last Name`, r.`Finish Location` from Customer c RIGHT JOIN Reserves r ON c.`Customer ID` = r.`Customer ID` where r.`Start Date` between '2018-06-01' and '2018-08-31' order by r.`Finish Location`;");
			
			while(myRs.next()){
				CustomerByLocation tempCustomer = convertRowToCustomerByLocation(myRs);
				list.add(tempCustomer);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
	private DamagesByKm convertRowToDamagesByKm(ResultSet myRs) throws SQLException {

		String damages = myRs.getString("Damages");
		int numVehicles = myRs.getInt("COUNT(Damages)");
		int avgKilometers= myRs.getInt("AVG(Kilometers)");

		DamagesByKm tempDamages = new DamagesByKm(damages, numVehicles, avgKilometers);

		return tempDamages;
	}
	
	
	public List<DamagesByKm> getDamagesByKm() throws Exception{

		List<DamagesByKm> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select Damages, COUNT(Damages), AVG(Kilometers) from Vehicle group by Damages order by AVG(Kilometers) Desc;");
			
			while(myRs.next()){
				DamagesByKm tempDamages = convertRowToDamagesByKm(myRs);
				list.add(tempDamages);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	//--------------------------------------------------------------------------------------------------------------------
	
	public List<String> searchVehiclesByFuelType(String fuelType) throws Exception{
		List<String> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			
			myStmt = myConn.prepareStatement("select v.`License Plate` from Vehicle v where v.`License Plate` in (select f.`License Plate` from `Fuel Type`  f where f.`Fuel Type` = ? );");

			myStmt.setString(1, fuelType);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				String tempString = myRs.getString("License Plate");
				list.add(tempString);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	
	public List<String> getAllVehiclesByFuelType() throws Exception{
		List<String> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.prepareStatement("select Vehicle.`License Plate` from Vehicle;");

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				String tempString = myRs.getString("License Plate");
				list.add(tempString);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
	private LocationByAmounts convertRowToLocationByAmounts(ResultSet myRs) throws SQLException {

		String startLocation = myRs.getString("Start Location");
		int paymentAmount = myRs.getInt("sum(p.`Payment Amount`)");

		LocationByAmounts tempLocation = new LocationByAmounts(startLocation, paymentAmount);

		return tempLocation;
	}
	
	
	public List<LocationByAmounts> getLocationByAmounts() throws Exception{

		List<LocationByAmounts> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select r.`Start Location`, sum(p.`Payment Amount`) from Rents as r, `Payment Transaction` as p where r.`Start Date` = p.`Start Date` group by r.`Start Location` order by sum(p.`Payment Amount`) Desc;");
			
			while(myRs.next()){
				LocationByAmounts tempLocation = convertRowToLocationByAmounts(myRs);
				list.add(tempLocation);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	
	//------------------------------------------------------------------------------------------------------------------------
	
	public List<Employee> getAllEmployees() throws Exception{

		List<Employee> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try{
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Employee");

			while(myRs.next()){
				Employee tempEmployee = rowToEmployee(myRs);
				list.add(tempEmployee);
			}

			return list;
		}
		finally{
			close(myStmt, myRs);
		}

	}
	
	public List<Store> getAllStores() throws Exception{
		
		List<Store> list = new ArrayList<>();
		
		Statement myStmt = null ;
		ResultSet myRs = null ;
		
		try {
			
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("Select * from Store");
			
			while(myRs.next()) {
				Store tempStore = rowToStore(myRs);
				list.add(tempStore);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
		
	}
	
	public List<Customer> getAllCustomers() throws Exception{
		
		List<Customer> list = new ArrayList<>();
		Statement myStmt =  null;
		ResultSet myRs = null ;
		
		try {
			
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("Select * from Customer");
			
			while(myRs.next()) {
				Customer tempCustomer = rowToCustomer(myRs);
				list.add(tempCustomer);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
		
	}
	
	
	
	//---------- updates -----------------------------  adds ------------- deletes -----------------------------------------
	
	public void updateEmployee(Employee theEmployee) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Employee"
					+ " set `Social Security Number`=?, `Driver License`=?,  `First Name`=?, `Last Name`=?,  `Street`=?, `Street Number`=?,  `Postal Code`=?,  `City`=?"
					+ " where `IRS Number`=?");
			
			// set parameters
			myStmt.setInt(1, theEmployee.getSocial_Sec_Number());
			myStmt.setString(2, theEmployee.getDriver_License());
			myStmt.setString(3, theEmployee.getFirstName());
			myStmt.setString(4, theEmployee.getLastName());
			myStmt.setString(5, theEmployee.getStreet());
			myStmt.setInt(6, theEmployee.getStreetNumber());
			myStmt.setInt(7, theEmployee.getPostalCode());
			myStmt.setString(8, theEmployee.getCity());
			myStmt.setInt(9, theEmployee.getEmployeeIRS_Number());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	}
	
	public void updateStore(Store theStore) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Store"
					+ " set `Street`=?, `Street Number`=?,  `Postal Code`=?,  `City`=?"
					+ " where `Store ID`=?");
			
			// set parameters
			myStmt.setString(1, theStore.getStoreStreet());
			myStmt.setInt(2, theStore.getStoreStreetNumber());
			myStmt.setInt(3, theStore.getStorePostalCode());
			myStmt.setString(4, theStore.getStoreCity());
			myStmt.setInt(5, theStore.getStoreID());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	}
	
	public void updateCustomer(Customer theCustomer) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Customer"
					+ " set `IRS Number`=?,`Social Security Number`=?, `Last Name`=?,  `First Name`=?, `Driver License`=?, `First Registration`=?,  `City`=?, `Postal Code`=?, `Street`=?, `Street Number`=?"
					+ " where `Customer ID` = ? ");
			
			// set parameters
			myStmt.setInt(1, theCustomer.getIRS_Number());
			myStmt.setInt(2, theCustomer.getSocial_Sec_Number());
			myStmt.setString(3, theCustomer.getLastName());
			myStmt.setString(4, theCustomer.getFirstName());
			myStmt.setString(5, theCustomer.getDriver_License());
			myStmt.setString(6, theCustomer.getFirstRegistration());
			myStmt.setString(7, theCustomer.getCity());
			myStmt.setInt(8, theCustomer.getPostalCode());
			myStmt.setString(9, theCustomer.getStreet());
			myStmt.setInt(10, theCustomer.getStreetNumber());
			myStmt.setInt(11, theCustomer.getCustomerID());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	}
	
	
	public void updateVehicleView1(VehicleView1 theVehicleView1) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update VehicleView1"
					+ " set Model=?, Make=?, Type=?, `Cylinder Capacity`=?, `Horse Power`=?"
					+ " where `License Plate` = ? ");
			
			// set parameters
			myStmt.setString(1, theVehicleView1.getModel());
			myStmt.setString(2, theVehicleView1.getMake());
			myStmt.setString(3, theVehicleView1.getType());
			myStmt.setInt(4, theVehicleView1.getCylinderCapacity());
			myStmt.setInt(5, theVehicleView1.getHorsePower());
			myStmt.setString(6, theVehicleView1.getLicensePlate());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			myStmt.close();
		}
		
	}
	
	public void addEmployee(Employee theEmployee) throws Exception{
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("insert into Employee"+
											 " (`IRS Number`, `Social Security Number`, `Driver License`, `First Name`, `Last Name`, Street, `Street Number`, `Postal Code`, City)"+
											 " values (?,?,?,?,?,?,?,?,?)");
			
			myStmt.setInt(1, theEmployee.getEmployeeIRS_Number());
			myStmt.setInt(2, theEmployee.getSocial_Sec_Number());
			myStmt.setString(3, theEmployee.getDriver_License());
			myStmt.setString(4, theEmployee.getFirstName());
			myStmt.setString(5, theEmployee.getLastName());
			myStmt.setString(6, theEmployee.getStreet());
			myStmt.setInt(7, theEmployee.getStreetNumber());
			myStmt.setInt(8, theEmployee.getPostalCode());
			myStmt.setString(9, theEmployee.getCity());
			
			myStmt.executeUpdate();
			
		}
		finally{
			myStmt.close();
		}
	}
	
	public void addStore(Store theStore) throws Exception{
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("insert into Store"+
											 " (`Store ID`, `Street`,`Street Number`, `Postal Code`, City)"+
											 " values (?,?,?,?,?)");
			
			myStmt.setInt(1, theStore.getStoreID());
			myStmt.setString(2, theStore.getStoreStreet());
			myStmt.setInt(3, theStore.getStoreStreetNumber());
			myStmt.setInt(4, theStore.getStorePostalCode());
			myStmt.setString(5, theStore.getStoreCity());
			
			myStmt.executeUpdate();
			
		}
		finally{
			myStmt.close();
		}
	}
	
	public void addCustomer(Customer theCustomer) throws Exception{
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("insert into Customer"+
											 " (`Customer ID`, `IRS Number`, `Social Security Number`, `Last Name`, `First Name`, `Driver License`, `First Registration`, `City`, `Postal Code`, `Street`, `Street Number`)"+
											 " values (?,?,?,?,?,?,?,?,?,?,?)");
			
			myStmt.setInt(1, theCustomer.getCustomerID());
			myStmt.setInt(2, theCustomer.getIRS_Number());
			myStmt.setInt(3, theCustomer.getSocial_Sec_Number());
			myStmt.setString(4, theCustomer.getLastName());
			myStmt.setString(5, theCustomer.getFirstName());
			myStmt.setString(6, theCustomer.getDriver_License());
			myStmt.setString(7, theCustomer.getFirstRegistration());
			myStmt.setString(8, theCustomer.getCity());
			myStmt.setInt(9, theCustomer.getPostalCode());
			myStmt.setString(10, theCustomer.getStreet());
			myStmt.setInt(11, theCustomer.getStreetNumber());
		
			
			myStmt.executeUpdate();
			
		}
		finally{
			myStmt.close();
		}
	}
	

	public void addVehicleView1(VehicleView1 theVehicleView1) throws Exception{
		PreparedStatement myStmt = null;
		
		try{
			myStmt = myConn.prepareStatement("insert into VehicleView1"+
											 " (`License Plate`, `Model`, `Make`, `Type`, `Cylinder Capacity`, `Horse Power`)"+
											 " values (?,?,?,?,?,?)");
			
			myStmt.setString(1, theVehicleView1.getLicensePlate());
			myStmt.setString(2, theVehicleView1.getModel());
			myStmt.setString(3, theVehicleView1.getMake());
			myStmt.setString(4, theVehicleView1.getType());
			myStmt.setInt(5, theVehicleView1.getCylinderCapacity());
			myStmt.setInt(6, theVehicleView1.getHorsePower());

			
			myStmt.executeUpdate();
			
		}
		finally{
			myStmt.close();
		}
	}
	
	
	
	public void deleteEmployee(int IRS_Number) throws SQLException{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from Employee where `IRS Number`=?");
			myStmt.setInt(1, IRS_Number);
			myStmt.executeUpdate();
		}
		finally{
			myStmt.close();
		}
	}
	
	public void deleteStore(int StoreID) throws SQLException{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from Store where `Store ID`=?");
			myStmt.setInt(1, StoreID);
			myStmt.executeUpdate();
		}
		finally{
			myStmt.close();
		}
	}
	
	public void deleteCustomer(int CustomerID) throws SQLException{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from Customer where `Customer ID`=?");
			myStmt.setInt(1, CustomerID);
			myStmt.executeUpdate();
		}
		finally{
			myStmt.close();
		}
	}
	
	public void deleteVehicleView1(String LicensePlate) throws SQLException{
		PreparedStatement myStmt = null;
		try {
			myStmt = myConn.prepareStatement("delete from VehicleView1 where `License Plate`=?");
			myStmt.setString(1, LicensePlate);
			myStmt.executeUpdate();
		}
		finally{
			myStmt.close();
		}
		
		
	}
	
	
}
