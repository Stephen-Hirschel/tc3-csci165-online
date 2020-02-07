import java.lang.*; import java.util.Scanner;
public class GMT{
  public static void main(String[] args){
    // Prompt user for input
    System.out.print("\nInput the timezone offset to GMT: ");
    Scanner zone = new Scanner(System.in);
    long offset = zone.nextLong();
    // Get current GMT
    long gmtime = System.currentTimeMillis();
    // Offset timezone
    long houroff = gmtime + (3600000 * offset);
    // Remove days
    long nodays = houroff % 86400000;
    // Remove nanoseconds
    long nonanos = nodays / 1000;
    // Modulo out hours, minutes and seconds
    long hours = (nonanos / 3600) % 24;
    long minutes = (nonanos / 60) % 60;
    long seconds = nonanos % 60;

    // Display time
    System.out.printf("\nCurrent time is %02d:%02d:%02d", hours, minutes, seconds);
  }
}
