
public class Address {
// class level instance variables
	private String street;
	private String city;
	private String state;
	private int zip;
	
	// no argument constructor
	public Address() {
		
	}
	
	// overloaded constructor
	public Address(String street, int zip) {
		this.setStreet(street);
		this.setZip(zip);
	}
	
	// clone constructor
	
	public Address(Address toClone) {
		this.street = toClone.street;
		this.zip = toClone.zip;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public int getZip() {
		return zip;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public boolean equals(Address otherAddress) {
		return 	this.street.equals(otherAddress.street) 	&&
				//this.city.equals(otherAddress.city) 		&&
				//this.state.equals(otherAddress.state) 		&&
				this.zip == otherAddress.zip;
	}
	
	public String toString() {
		return street + ", " + zip;
	}
	
}

