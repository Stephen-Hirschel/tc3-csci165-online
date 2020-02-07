//import classes
import java.util.Scanner; import java.math.*;
public class Primitives{

  public static void main(String[] args){
    // 1. Define and initialize variables of each primitive type
    byte bitten = 43;
    short shawty = 100;
    int intra = 90210;
    long longo = 7762249300L;
    float floaty = 23.524f;
    double dubstep = 3.16;
    char charo = 'f';
    char numb = '3';
    boolean judgy = true;
    byte slim = (byte)longo;
    long gains = (long)shawty;
    float fly = (float)intra;

    System.out.printf("\nA byte is %d", bitten);
    System.out.printf("\nA short is %d", shawty);
    System.out.printf("\nAn int is %d", intra);
    System.out.printf("\nA long is %d", longo);
    System.out.printf("\nA float is %f", floaty);
    System.out.printf("\nA double is %f", dubstep);
    System.out.printf("\nA char is %s", charo);
    System.out.printf("\nA numerical char is %s", numb);
    System.out.printf("\nA boolean is %b", judgy);
    System.out.printf("\nLet's narrow a long to a byte: %d", slim);
    System.out.printf("\nLet's widen a short to a long: %d", gains);
    System.out.printf("\nLet's float that int: %f", fly);

    //2. Ask the user to enter an integer, display square, cube and 4th power
    System.out.println("\n\n****************************************\n");
    System.out.print("\nPlease enter an integer: ");
    Scanner powinput = new Scanner(System.in);
    String boompow = powinput.nextLine();
    BigInteger b1, b2, b3, b4;
    b1 = new BigInteger(boompow);
    int squared = 2;
    int cubed = 3;
    int fourth = 4;
    b2 = b1.pow(squared);
    b3 = b1.pow(cubed);
    b4 = b1.pow(fourth);
    System.out.printf("\n%s squared is %d", boompow, b2);
    System.out.printf("\n%s cubed is %d", boompow, b3);
    System.out.printf("\n%s to the fourth power is %d", boompow, b4);

    //3. Create two INT variables, assign maximum and minimum values.
    System.out.println("\n\n****************************************\n");
    //BigInteger b5, b6, b7, b8, b9, b10;
    //b5 = new BigInteger("-2");
    //b6 = new BigInteger("2");
    //int mint = 31;
    //b7 = b5.pow(mint);
    //b8 = b6.pow(mint);
    //b9 = new BigInteger("1");
    //b10 = b8.subtract(b9);
    //final
    //System.out.printf("The minimum int is %d, and the maximum int is %d", b7, b10);
    int mint = Integer.MIN_VALUE;
    int maxint = Integer.MAX_VALUE;
    System.out.println("The minimum value of int is " + mint);
    System.out.println("The maximum value of int is  " + maxint);
    int compSign = Integer.compare(mint, maxint);
    int compUnsign= Integer.compareUnsigned(mint, maxint);
    System.out.println("\nThe minimum value compared to the maximum value with compSign returns " + compSign);
    System.out.println("The minimum value compared to the maximum values with compUnsign returns " + compUnsign);
    // You will run into issues when comparing unsigned values and signed values
    // because unsigned does not recognize negative integers, and signed integers
    // have undefined behaviors if they overflow.  Unsigned integers also have
    // different binary signatures, using the first bit to represent '+' or '-'
    // which leads to issues when comparing.

    System.out.println("\n\n****************************************\n");
    //4. Compute floor division and modulus from user input
    System.out.println("Time to divide and conquer!\n");
    System.out.print("Please enter an integer dividend: ");
    Scanner dividend = new Scanner(System.in);
    int divid = dividend.nextInt();
    System.out.print("\nPlease enter an integer divisor: ");
    Scanner divisor = new Scanner(System.in);
    int divis = divisor.nextInt();
    int quotient = Math.floorDiv(divid, divis);
    int quotient2 = divid / divis;
    int qmod = Math.floorMod(divid, divis);
    int qmod2 = divid % divis;
    System.out.printf("\nWith floorDiv, %d divided by %d is %d", divid, divis, quotient);
    System.out.printf("\nWith operator division, %d divided by %d is %d", divid, divis, quotient2);
    System.out.printf("\n\nWith floorMod, the remainder of %d divided by %d is %d", divid, divis, qmod);
    System.out.printf("\nWith operator modulus, the remainder of %d divided by %d is %d", divid, divis, qmod2);

  }
}
