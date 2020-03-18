
public class Driver {
	private static Fraction fracArray[] = new Fraction[9];
	private static int[] numerators = {1, 2, 3, 4, 11, 6, 7, 8, 13};
	private static int[] denominators = {2, 5, 4, 6, 3, 8, 21, 13, 5}; 
	
	public static void fracBuilder() {
		
		for(int i = 0; i < fracArray.length; i++) {
			fracArray[i] = new Fraction(numerators[i], denominators[i]);
			fracArray[i].reduce();
			System.out.println(fracArray[i]);
		}
		findMin();
		findMax();
	}
	private static void findMin() {
		Fraction min = fracArray[0];		
		for(int i = 0; i < fracArray.length; i++) {
			if(fracArray[i].compareTo(min) == -1)
				min = fracArray[i];
		}
		System.out.println("The smallest fraction in the array is: " + min);
	}
	private static void findMax() {
		Fraction fracMax[] = new Fraction[9];
		Fraction max = fracArray[0];
		for(int i = 0; i < fracMax.length; i++) {
			fracMax[i] = new Fraction(numerators[i], denominators[i]);
		}	
			
			for(int j = 0; j < fracMax.length; j++) {			
					if(fracMax[j].compareTo(max) == 1)
						max = fracMax[j];
		}
		System.out.println("The largest fraction in the array is: " + max);
	
	}
	
	
	public static void main(String[] args) {
		Fraction frac = new Fraction();
		frac.setNumerator(3);
		frac.setDenominator(16);
		int n = frac.getNumerator();
		int d = frac.getDenominator();
		
		System.out.printf("A fraction with a numerator of %d and a denominator of %d is: %s", n, d, frac);
		Fraction clone = new Fraction(frac);
		System.out.printf("%nWhen using .equals() the clone of %s is, of course, %s",frac, clone);
		System.out.print("\nBut using == method reveals: ");
		System.out.print(frac == clone);
		System.out.println("\nWhen we add the original to the clone we get: " + frac.add(clone));
		
		System.out.println("\nLet's work with some other fractions now!");
		Fraction frac1 = new Fraction(5, 6);
		Fraction frac2 = new Fraction();
		frac2.setNumerator(3);
		frac2.setDenominator(12);
		System.out.println(frac1 + " - " + frac2 + " = " + frac1.subtract(frac2));
		
		Fraction frac3 = new Fraction(15, 7);
		Fraction frac4 = new Fraction(10, 3);
		Fraction prod = new Fraction(frac3.multiply(frac4));
		System.out.println(frac3 + " * " + frac4 + " = " + prod);
		
		Fraction frac5 = new Fraction(4, 12);
		Fraction frac6 = new Fraction(3, 9);
		System.out.println("\nTrue or False: " + frac5 + " is the same as " + frac6 + ": " + frac5.equals(frac6));
		System.out.println("True or False: " + frac5 + " is the same as " + frac1 + ": " + frac5.equals(frac1));
		
		System.out.println("\nOh Magic 8-Ball, how does " + frac5 + " compare to " + frac2 + "?");
		System.out.println("Tell me using a scale of Equals = 0, less than = -1, greater than = 1");
		System.out.println(frac5.compareTo(frac2));
		
		System.out.println("Oh, of course! Because " + frac5 + " is " + frac5.toDecimal() + " and " + frac2 + " is " + frac2.toDecimal());
		System.out.println("\nHere is the array of fractions: ");
	
		Driver.fracBuilder();

	}

}
