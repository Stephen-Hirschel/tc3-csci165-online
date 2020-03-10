import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureTest {

	@Test
	void testTemperatureDoubleString() {
		// set values in test object
		Temperature testTemp = new Temperature(39, "C");
		// set variables to retrieve values
		double v = testTemp.getVal();
		String s = testTemp.getScale();

		// test values
		assertEquals(v, 39);
		assertEquals(s, "C");
		
		// test with invalid data
		testTemp = new Temperature(300, "r");
		v = testTemp.getVal();
		s = testTemp.getScale();
		
		// invalid temp value should return 0
		assertEquals(v, 0);
		
		//invalid scale value should return "C"
		assertEquals(s, "C");
		
	}

	@Test
	void testSetVal() {
		Temperature testVal = new Temperature();
		// test with valid data
		testVal.setVal(40);
		double v = testVal.getVal();
		assertEquals(v, 40);
		
		testVal.setVal(194);
		v = testVal.getVal();
		assertEquals(v, 194);
		
		// test with invalid data, should return 0
		testVal.setVal(-220);
		v = testVal.getVal();
		assertEquals(v, 0);
		
		testVal.setVal(420);
		v = testVal.getVal();
		assertEquals(v, 0);
	}



	@Test
	void testSetScale() {
		Temperature testScale = new Temperature();
		// test with valid data
		testScale.setScale("C");
		String s = testScale.getScale();
		assertEquals(s, "C");
		
		testScale.setScale("F");
		s = testScale.getScale();
		assertEquals(s, "F");
		
		// test with invalid data, should return "C"
		testScale.setScale("g");
		s = testScale.getScale();
		assertEquals(s, "C");
		
		testScale.setScale("M");
		s = testScale.getScale();
		assertEquals(s, "C");
	}

	@Test
	void testSetBoth() {
		Temperature testBoth = new Temperature();
		// test with valid data
		testBoth.setBoth(52, "F");
		double v = testBoth.getVal();
		String s = testBoth.getScale();
		assertEquals(v, 52);
		assertEquals(s, "F");
		
		testBoth.setBoth(4, "C");
		v = testBoth.getVal();
		s = testBoth.getScale();
		assertEquals(v, 4);
		assertEquals(s, "C");
		
		// test with invalid data
		testBoth.setBoth(256, "g");
		v = testBoth.getVal();
		s = testBoth.getScale();
		assertEquals(v, 0);
		assertEquals(s, "C");
		
		testBoth.setBoth(-666, "H");
		v = testBoth.getVal();
		s = testBoth.getScale();
		assertEquals(v, 0);
		assertEquals(s, "C");
	}

	@Test
	void testGetCelsius() {
		Temperature testCels = new Temperature();
		// test with valid data
		testCels.setVal(32);
		double c = testCels.getCelsius();
		assertEquals(c, 0);
		
		testCels.setVal(98.6);
		c = testCels.getCelsius();
		assertEquals(c, 37);
		
		// test with invalid data
		testCels.setVal(-543);
		c = testCels.getCelsius();
		assertEquals(c, -17.8); // 17.8 is O degrees Fahrenheit
		
		testCels.setVal(9000);
		c = testCels.getCelsius();
		assertEquals(c, -17.8);
	}

	@Test
	void testGetFahrenheit() {
		Temperature testFahr = new Temperature();
		// test with valid data
		testFahr.setVal(100);
		double c = testFahr.getFahrenheit();
		assertEquals(c, 212); //https://www.youtube.com/watch?v=xYxbXzLNn0w
		
		testFahr.setVal(26);
		c = testFahr.getFahrenheit();
		assertEquals(c, 78.8);
		
		// test with invalid data
		testFahr.setVal(333);
		c = testFahr.getFahrenheit();
		assertEquals(c, 32);
		
		testFahr.setVal(-666);
		c = testFahr.getFahrenheit();
		assertEquals(c, 32);
		
	}

	@Test
	void testSetOppoTemp() {
		Temperature testOppo = new Temperature();
		// test with valid data
		testOppo.setBoth(23, "C");
		double t =testOppo.getVal();
		double v = testOppo.setOppoTemp(t);
		assertEquals(v, 73.4);
		
		testOppo.setBoth(59, "F");
		t = testOppo.getVal();
		v = testOppo.setOppoTemp(t);
		assertEquals(v, 15);
		
		// test with invalid data
		testOppo.setBoth(369, "g");
		t = testOppo.getVal();
		v = testOppo.setOppoTemp(t);
		assertEquals(v, 32); // default invalid input is set
							// to 0 C, so conversion to F works
		testOppo.setBoth(-527, "J");
		t = testOppo.getVal();
		v = testOppo.setOppoTemp(t);
		assertEquals(v, 32);
	}



	@Test
	void testToString() {
		Temperature testToString = new Temperature();
		// test with valid data
		testToString.setBoth(55, "F");
		String s = testToString.toString();
		assertEquals(s,"55.0° F");
		
		testToString.setBoth(25.3, "C");
		s = testToString.toString();
		assertEquals(s, "25.3° C");
		
		// test with invalid data
		testToString.setBoth(241, "e");
		s = testToString.toString();
		assertEquals(s, "0.0° C");
		
		testToString.setBoth(-742, "x");
		s = testToString.toString();
		assertEquals(s,  "0.0° C");
	}
	@Test
	void testCompareTo() {
		Temperature testComp1 = new Temperature();
		Temperature testComp2 = new Temperature();
		
		// test for equals to = 0
		testComp1.setVal(98.6);
		testComp1.setScale("F");
		testComp2.setVal(37);
		testComp2.setScale("C");
		int n = testComp1.compareTo(testComp2);
		assertEquals(n, 0);
		
		testComp1.setVal(15);
		testComp1.setScale("C");
		testComp2.setVal(59);
		testComp2.setScale("F");
		n = testComp1.compareTo(testComp2);
		assertEquals(n, 0);
		
		// test for testComp1 greater than, returns 1
		testComp1.setVal(25);
		testComp1.setScale("C");
		testComp2.setVal(59);
		testComp2.setScale("F");
		n = testComp1.compareTo(testComp2);
		assertEquals(n, 1);
		
		testComp1.setVal(100);
		testComp1.setScale("F");
		testComp2.setVal(36);
		testComp2.setScale("C");
		n = testComp1.compareTo(testComp2);
		assertEquals(n, 1);
		
		// test for testComp1 less than, returns -1
		testComp1.setVal(13);
		testComp1.setScale("C");
		testComp2.setVal(59);
		testComp2.setScale("F");
		n = testComp1.compareTo(testComp2);
		assertEquals(n, -1);
		
		testComp1.setVal(74);
		testComp1.setScale("F");
		testComp2.setVal(24);
		testComp2.setScale("C");
		n = testComp1.compareTo(testComp2);
		assertEquals(n, -1);
	}
}
