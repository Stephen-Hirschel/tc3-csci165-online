import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FractionTest {
	Fraction f;
	
	@Test
	void testFraction() {
		f = new Fraction();
		assertEquals(f.getNumerator(), 1);
		assertEquals(f.getDenominator(), 1);
	}
	
	@Test
	void testFractionIntInt() {
		f = new Fraction(1, 2);
		assertEquals(f.getNumerator(), 1);
		assertEquals(f.getDenominator(), 2);
		
		f = new Fraction(-1, -2);
		assertEquals(f.getNumerator(), 1);
		assertEquals(f.getDenominator(), 2);
		
		f = new Fraction(1, 0);
		assertEquals(f.getNumerator(), 1);
		assertEquals(f.getDenominator(), 1);
	}

	@Test
	void testSetDenominator() {
		f = new Fraction();
		f.setDenominator(5);
		assertEquals(f.getDenominator(), 5);
		
		f = new Fraction();
		f.setDenominator(0);
		assertEquals(f.getDenominator(), 1);
		
		f = new Fraction();
		f.setDenominator(-5);
		assertEquals(f.getDenominator(), 5);
		
	}

	@Test
	void testSetNumerator() {
		f = new Fraction();
		f.setNumerator(5);
		assertEquals(f.getNumerator(), 5);
		
		f = new Fraction();
		f.setDenominator(-5);
		assertEquals(f.getDenominator(), 5);
	}

	@Test
	void testToDecimal() {
		f = new Fraction(13, 8);
		assertEquals(f.toDecimal(), 1.625);
		
		f = new Fraction(1, 8);
		assertEquals(f.toDecimal(), .125);
		
		f = new Fraction(-13, -8);
		assertEquals(f.toDecimal(), 1.625);
		
		f = new Fraction(0, 0);
		assertEquals(f.toDecimal(), 1.0);
		
		f = new Fraction(2, 0);
		assertEquals(f.toDecimal(), 2.0);
		
		f = new Fraction(-1, 2);
		assertEquals(f.toDecimal(), .5);
		
		f = new Fraction(1, -2);
		assertEquals(f.toDecimal(), .5);
	}

	@Test
	void testEqualsFraction() {
		f = new Fraction(1, 2);
		Fraction test = new Fraction(1, 2);
		assertTrue(f.equals(test));
		assertEquals(f.compareTo(test), 0);
		
		test = new Fraction(3, 4);
		assertFalse(f.equals(test));
		assertFalse(f.compareTo(test) == 0);
		
		f	 = new Fraction(-17, 3);
		test = new Fraction(17, -3);
		assertTrue(f.equals(test));
		assertEquals(f.compareTo(test),0);
		
		f	 = new Fraction(3, 17);
		test = new Fraction(17, 3);
		assertFalse(f.equals(test));
		assertFalse(f.compareTo(test) == 0);
		
	}
	
	@Test
	void testCompareTo() {
		f = new Fraction(1, 2);
		Fraction test = new Fraction(1, 2);
		assertEquals(f.compareTo(test), 0);
		
		test = new Fraction(3, 4);
		assertEquals(f.compareTo(test), -1);
		
		test = new Fraction(1, -4);
		assertEquals(f.compareTo(test),1);
		
		f	 = new Fraction(3, 17);
		test = new Fraction(17, 3);
		assertEquals(f.compareTo(test), -1);
	}

	@Test
	void testReduce() {
		f = new Fraction(5, 10);
		f.reduce();
		assertEquals(f.getNumerator(), 1);
		assertEquals(f.getDenominator(), 2);
		
		f = new Fraction(15, 35);
		f.reduce();
		assertEquals(f.getNumerator(), 3);
		assertEquals(f.getDenominator(), 7);
		
		f = new Fraction(34, 119);
		f.reduce();
		assertEquals(f.getNumerator(), 2);
		assertEquals(f.getDenominator(), 7);
		
		f = new Fraction(33, 121);
		f.reduce();
		assertEquals(f.getNumerator(), 3);
		assertEquals(f.getDenominator(), 11);
		
	}

	@Test
	void testAdd() {
		f = new Fraction(1, 4);
		Fraction f2 = new Fraction(1, 4);
		assertTrue(f.add(f2).equals(new Fraction(1, 2)));
		
		f 	= new Fraction(1, 2);
		f2 	= new Fraction(1, 4);
		assertTrue(f.add(f2).equals(new Fraction(3, 4)));
		
		f 	= new Fraction(1, 3);
		f2 	= new Fraction(1, 4);
		assertTrue(f.add(f2).equals(new Fraction(7, 12)));
		
		f 	= new Fraction(3, 4);
		f2 	= new Fraction(2, 5);
		assertTrue(f.add(f2).equals(new Fraction(23, 20)));
		
		f 	= new Fraction(5, 6);
		f2 	= new Fraction(3, 7);
		assertTrue(f.add(f2).equals(new Fraction(53, 42)));
		
	}

	@Test
	void testSubtract() {
		f = new Fraction(5, 6);
		Fraction f2 = new Fraction(3, 7);
		assertTrue(f.subtract(f2).equals(new Fraction(17, 42)));
		
		f 	= new Fraction(5, 7);
		f2 	= new Fraction(1, 2);
		assertTrue(f.subtract(f2).equals(new Fraction(3, 14)));
		
		f 	= new Fraction(-5, 7);
		f2 	= new Fraction(1, 2);
		assertTrue(f.subtract(f2).equals(new Fraction(3, 14)));
		
		f 	= new Fraction(5, -7);
		f2 	= new Fraction(1, 2);
		assertTrue(f.subtract(f2).equals(new Fraction(3, 14)));
		
		f 	= new Fraction(5, 0);
		f2 	= new Fraction(1, 2);
		assertTrue(f.subtract(f2).equals(new Fraction(9, 2)));
	}

	@Test
	void testMultiply() {
		f = new Fraction(5, 6);
		Fraction f2 = new Fraction(3, 7);
		assertTrue(f.multiply(f2).equals(new Fraction(5, 14)));
		
		f 	= new Fraction(5, 7);
		f2 	= new Fraction(1, 2);
		assertTrue(f.multiply(f2).equals(new Fraction(5, 14)));
		
		f 	= new Fraction(5, 0);
		f2 	= new Fraction(1, 2);
		assertTrue(f.multiply(f2).equals(new Fraction(5, 2)));
		
		f 	= new Fraction(5, -7);
		f2 	= new Fraction(1, 2);
		assertTrue(f.multiply(f2).equals(new Fraction(5, 14)));
		
		f 	= new Fraction(15, 6);
		f2 	= new Fraction(11, 7);
		assertTrue(f.multiply(f2).equals(new Fraction(165, 42)));
	}
	
	@Test
	void testToString() {
		f = new Fraction(5, 14);
		assertTrue(f.toString().equals("5/14"));
		
		f = new Fraction(5, 2);
		assertTrue(f.toString().equals("2 1/2"));
		
		f = new Fraction(165, 42);
		assertTrue(f.toString().equals("3 13/14"));
		
		f = new Fraction(17, 42);
		assertTrue(f.toString().equals("17/42"));
		
		f = new Fraction(137, 23);
		assertTrue(f.toString().equals("5 22/23"));
	}

}
