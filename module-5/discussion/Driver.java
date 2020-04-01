
public class Driver {

	public static void main(String[] args) {
		Address a1 = new Address("666 Broad Street", 66666);
		Customer c1 = new Customer("Gritty", "McGrit", "itMe@flyers.com", a1);
		
		System.out.println(c1);
		
		// demonstrate that access to private Address instance passed through the constructor can be maintained
		System.out.println(a1);
		
		
		// demonstrate that access to a private variable when calling setAddress can be maintained
		c1.setAddress(new Address("123 Sesame Street", 77777));
		System.out.println("\n" + c1);
		
		// demonstrate that access to a private variable when calling getAddress is possible
		System.out.println(c1.getAddress());
		
		// demonstrate that the zip code can be manipulated from outside the class
		a1.setZip(90210);
		System.out.println("\n" + c1);
		
	}

}
