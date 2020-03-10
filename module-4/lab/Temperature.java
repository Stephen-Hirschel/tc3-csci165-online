import java.lang.Math;
public class Temperature {
	
	// static class features
	//public static enum Scale{C,F};
	
	// instance variables
	private double temp = 0;
	private String scale = "C";
	private int result;
	// no argument constructor
	public Temperature() {
		temp = 0;
		scale = "C";
	}
	// overloaded constructor
	public Temperature(double t, String s) {
		setVal(t);
		setScale(s);
	
	}
	
	public void setVal(double t) {
		double min = -200;
		double max = 200;
		if(t >= min && t <= max)
			temp = t;
		else temp = 0;
	}
	
	public double getVal() {
		return temp;
	}
	
	public void setScale(String s) {
		s = s.toUpperCase();
			if(s == "F"){ 
				s = "F";
				scale = s;
			}
			if(s == "C") {
				s = "C";
				scale = s;
			}	
			if(s != "C" && s != "F") {
				s = "C";
				scale = s;
			}
	
	}
	public String getScale() {
		return scale;
	}
	public void setBoth(double t, String s) {
		setVal(t);
		setScale(s);
	}
	public double getCelsius() {
		double degreesC = temp;
		degreesC = (5* (temp - 32) / 9) ;
		double rnd = Math.round(degreesC * 10) / 10.0;
		return rnd;
		
	}
	
	public double getFahrenheit() {
		double degreesF = temp;
		degreesF = ((9 * (temp)) / 5) + 32;
		double rnd = Math.round(degreesF *10) / 10.0;
		return rnd;
	}
	
	// a helper method to convert temperatures
	public double setOppoTemp(double t) {
		String s = scale;
		t = temp;
		if(s == "F") {
			t = getCelsius();
		}
		if(s == "C") {
			t = getFahrenheit();
		}
		return t;
	}
	// a helper method to convert scale
	public String setOppoScale(String sc) {
		String s = scale;
		sc = s;
		if (s == "F") {
			sc = "C";
		}
		if (s == "C") {
			sc = "F";
		}
		return sc;
	}
	
	public String toString() {
		return temp + "° " + scale;
		
	}
	
	public boolean equals(Temperature t) {
		if(this.scale != t.scale) {
			if(this.scale == "C") {
				this.temp = this.getFahrenheit();
			}
			if(this.scale == "F") {
				this.temp = this.getCelsius();
			}
		}
		return this.temp == t.temp; 
		}
	
	public int compareTo(Temperature t) {
		if(this.scale != t.scale) {
			if(this.scale == "C") {
				this.temp = this.getFahrenheit();
			}
			if(this.scale == "F") {
				this.temp = this.getCelsius();
			}
		}
			if(this.temp > t.temp) {
					result = 1;
					}
				else if(this.temp < t.temp) {
					result = -1;
				}
				else if(this.temp == t.temp) {
					result = 0;				
				}			
		
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
	
		
	}

}
