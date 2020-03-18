import java.text.DecimalFormat;

public class Fraction {
	// 2 private integers that will represent the numerator and denominator
	private int num;
	private int den;
	
	// no argument constructor
	public Fraction() {
		num = 1;
		den = 1;
	}
	
	// overloaded constructor
	public Fraction(int num, int den) {
		setNumerator(num);
		setDenominator(den);
	}
	
	// copy constructor
	public Fraction(Fraction f) {
		this.num = f.num;
		this.den = f.den;
		
	}
	
	public void setDenominator(int d) {
		if(d == 0)
			d = 1;
		den = Math.abs(d);
	}
	
	public int getDenominator() {
		return den;
	}
	
	public void setNumerator(int n) {
		if(n == 0)
			n = 1;
		num = Math.abs(n);
	}
	
	public int getNumerator() {
		return num;
	}
	
	public double toDecimal() {
		DecimalFormat df = new DecimalFormat("#.###");		
		double dec = (double) num / den;
		String s = df.format(dec);
		dec = Double.valueOf(s);
		return dec;
		
	}
	public void reduce() {
		int g = gcd(num, den);
		num = num / g;
		den = den / g;
	}
	
	private int gcd(int x, int y) {
		int gcd = 0;
		for(int i = 1; i <= x && i <= y; i++) {
			if(x % i == 0 && y % i == 0)
				gcd = i;
		}
		return gcd;
	}
	
	public String toString() {
		int r;
		if((num / den) > 1) {
			r = num / den;
			num = num % den;
			reduce();
			String s = String.format("%d %d/%d", r, num, den);
			return s;
		}
		else {
		return num + "/" + den; 
		}
	}
	
	public Fraction add(Fraction f) {
		int num1 = 1;
		int den1 = 1;
		if(this.den != f.den) {
			num1 = ((this.num * f.den) + (f.num * this.den));
			den1 = this.den * f.den;			
		}
		else if(this.den == f.den){
			num1 = this.num + f.num;
			den1 = f.den;
		}
		
		
		Fraction sum = new Fraction(num1, den1);
		sum.reduce();
		return sum;
	}
	
	public Fraction subtract(Fraction f) {
		if(this.den != f.den) {
			setNumerator(((this.num * f.den) - (f.num * this.den)));
			setDenominator(this.den * f.den);			
		}
		else if(this.den == f.den){
			setNumerator(this.num - f.num);
			setDenominator(f.den);
		}
		
		reduce();
		Fraction sum = new Fraction(num, den);
		return sum;
	}
	
	public Fraction multiply(Fraction f) {
		int num1 = (this.num * f.num);
		int den1 = (this.den * f.den);
		Fraction prod = new Fraction(num1, den1);
		prod.reduce();
		return prod;
		
	}
	
	public boolean equals(Fraction f) {
		double f1 = this.toDecimal();
		double f2 = f.toDecimal();
		return f1 == f2;
		
	}
	
	public int compareTo(Fraction f) {
		int outcome = 0;
		double f1 = this.toDecimal();
		double f2 = f.toDecimal();
		if(f1 == f2)
			outcome = 0;
		if(f1 < f2)
			outcome = -1;
		if(f1 > f2)
			outcome = 1;
		return outcome;
		
	}
	

	public static void main(String[] args) {

	}

}
