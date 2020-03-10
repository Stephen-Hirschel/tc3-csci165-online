import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		Temperature temperature = new Temperature();
		temperature.setVal(42);
		temperature.setScale("C");
		double t = temperature.getVal();
		String s = temperature.getScale();
		double f = temperature.setOppoTemp(t);
		String sc = temperature.setOppoScale(s);
		Temperature oppo = new Temperature(f, sc);
		System.out.println("The temperature is " + temperature + ", which converts to " + oppo);
		Temperature t2 = new Temperature();
		t2.setBoth(69.0, "F");
		t = t2.getVal();
		s = t2.getScale();
		f = t2.setOppoTemp(t);
		sc = t2.setOppoScale(s);
		Temperature oppo2 = new Temperature(f, sc);
		System.out.println("\nThe temperature is " + t2 + ", which converts to " + oppo2);

		Temperature t3 = new Temperature(72, "F");
		System.out.println(t3 + "\n");
		
		Temperature t4 = new Temperature(37, "C");
		System.out.println(t4 +"\n");
		
		Temperature obj[] = new Temperature[5];
		obj[0] = new Temperature(32, "F");
		obj[1] = new Temperature(17.4, "C");
		obj[2] = new Temperature(75, "F");
		obj[3] = new Temperature(55.4, "F");
		obj[4] = new Temperature(30, "C");
		for(int i = 0; i < obj.length; i++)
			System.out.println(obj[i]);
		
		Temperature comp1 = new Temperature();
		Temperature comp2 = new Temperature();
		comp1.setVal(98.6);
		comp1.setScale("F");
		comp2.setVal(37);
		comp2.setScale("C");
		if(comp2.equals(comp1)) System.out.println(comp2 + " == " + comp1);
		else System.out.println(comp2 + " != " + comp1);
		comp1.setVal(98.6);
		comp1.setScale("F");
		comp2.setVal(37);
		comp2.setScale("C");		
		comp1.compareTo(comp2);		
		
		comp1.setVal(15);
		comp1.setScale("C");
		comp2.setVal(59);
		comp2.setScale("F");
		comp1.compareTo(comp2);
		
		
	}

}
