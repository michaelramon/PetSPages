package framework.data;


public class CustomersData {
	String shipAddress1, shipAddress2, shipCity, shipZipcode, telephone,
			billAddress1, billAddress2, billCity, billZipcode, email, password,
			firstName, lastName, state, country, wishListName, item1, item2, item3;
	ImportCustomerData customer1;

	public CustomersData() {
		customer1 = new ImportCustomerData();
		setEmail();
		setPassword();
		setCountry();
		setTelephone();
		setState();
		setBillAddress1(customer1.billAddress1);
		setBillCity(customer1.billCity);
		setBillZipcode(customer1.billZipcode);
		setFirstName(customer1.firstName);
		setLastName(customer1.lastName);
		setShipAddress1(customer1.shipAddress1);
		setShipCity(customer1.shipCity);
		setShipZipcode(customer1.shipZipcode);
		setWishListName(customer1.wishListName);

	}

	public String getCountry(){
		return country;
	}
	
	public String setCountry(){
		return country = customer1.country;
	}
	
	public String setEmail() {
		return email = customer1.email;
	}

	public String setPassword() {
		return password = customer1.password;

	}
	
	public String setTelephone(){
		return telephone = customer1.telephone;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		 this.lastName = lastName;
	}
	
	public String getState() {
		return setState();
	}
	
	public String setState() {
		return customer1.state;
	}

	public String getShipAddress1() {
		return shipAddress1;
	}

	public void setShipAddress1(String shipAddress1) {
		this.shipAddress1 = shipAddress1;
	}

	public String getShipAddress2() {
		return shipAddress2;
	}

	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipZipcode() {
		return shipZipcode;
	}

	public void setShipZipcode(String shipZipcode) {
		this.shipZipcode = shipZipcode;
	}

	public String getBillAddress1() {
		return billAddress1;
	}

	public void setBillAddress1(String billAddress1) {
		this.billAddress1 = billAddress1;
	}

	public String getBillAddress2() {
		return billAddress2;
	}

	public void setBillAddress2(String billAddress2) {
		this.billAddress2 = billAddress2;
	}

	public String getBillCity() {
		return billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	public String getBillZipcode() {
		return billZipcode;
	}

	public void setBillZipcode(String billZipcode) {
		this.billZipcode = billZipcode;
	}
	
	public String getWishListName(){
		return wishListName;
	}
	
	public void setWishListName(String wishListName){
		this.wishListName = wishListName;
	}
	

}