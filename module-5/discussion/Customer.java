
public class Customer {
// class level instance variables
private String firstName;
private String lastName;
private String email;
private Address address;

// no argument constructor
public Customer() {

}

// overloaded constructor
public Customer(String firstName, String lastName, String email, Address address) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.setAddress(address);
}

public Customer(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
}
	
public Customer(Customer toClone) {
	this.firstName = toClone.firstName;
	this.lastName = toClone.lastName;
	this.email = toClone.email;
	this.address = toClone.address;
}

public void setName(String first, String last) {
	this.firstName = first;
	this.lastName = last;
}

public void setEmail(String email) {
	this.email = email;
}

public String getName() {
	return firstName + " " + lastName;
}

public String getEmail() {
	return email;
}

public void setAddress(Address addy){
	address = new Address(addy);
}

public Address getAddress(){
	Address a = new Address(this.address);
	return a;
}

public boolean equals(Customer otherCustomer) {
	return this.firstName.equals(otherCustomer.firstName) &&
			this.lastName.equals(otherCustomer.lastName)  &&
			this.email.contentEquals(otherCustomer.email) &&
			this.address == null ? null : this.address.equals(otherCustomer.address);
}

public String toString() {
	String addressString = address == null ? null : address.toString();
	
	return String.format("Name: %s\nEmail: %s\nAddress: %s\n", getName(), getEmail(), addressString);
}

public static void main(String[] args) {
		

	}

}
