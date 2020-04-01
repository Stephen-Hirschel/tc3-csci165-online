import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	Customer c1;
	Address a1;
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Address("42 Renholm Drive", 11899);
		c1 = new Customer("Maurice", "Moss", "mmoss@renholmindustries.uk", a1);
	}

	@Test
	void testCustomerStringStringStringAddress() {
		
		String st = a1.getStreet();
		assertEquals(st, "42 Renholm Drive" );
	}

	@Test
	void testSetAddress() {	
		a1.setStreet("13 Denholm Street");
		a1.setZip(97253);
		c1.setAddress(a1);
		String st = a1.toString();
		String re = c1.getAddress().toString();
		assertEquals(st, re);
	}

	@Test
	void testGetAddress() {
		String st = c1.getAddress().toString();
		assertEquals(st, "42 Renholm Drive, 11899");
	}

}
