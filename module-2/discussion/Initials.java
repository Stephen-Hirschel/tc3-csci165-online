// Import classes
import java.util.Scanner;
public class Initials{

  public static void main(String[] args){

    // Ask user for their first and last name, stored as a single variable
    System.out.print("\nPlease enter your first and last name: ");
    Scanner name = new Scanner(System.in);
    String inits = name.nextLine();

    // Print the characters individually
    char first = inits.charAt(0);
    System.out.println("\n" + first);
    int lindex = inits.indexOf(' ');
    int lastdex = lindex + 1;
    char last = inits.charAt(lastdex);
    System.out.println(last);
    System.out.println("\n");

    // Print the Unicode values of the initials
    int unif = inits.codePointAt(0);
    int unil = inits.codePointAt(lastdex);
    System.out.println(first + " is located at unicode " + unif);
    System.out.println(last + " is located at unicode " + unil);

    // Print the sum of the unicode values
    int sum = unif + unil;
    System.out.printf("The sum of your unicode initials is %d", sum);

    // Print the initials concatenated together as a string
    String initials = String.valueOf(first) + String.valueOf(last);
    System.out.printf("\n\nYour initials are %S", initials);
  }
}
