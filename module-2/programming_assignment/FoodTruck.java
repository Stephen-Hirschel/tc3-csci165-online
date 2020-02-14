// import classes
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class FoodTruck{
  public static void main(String[] args){

    // initialize arrays for menu and prices
    String[] menu;
    menu = new String[3];

    double[] prices;
    prices = new double[3];

    // set counters to place menu and prices into empty array spots
    int menuNumber =  0;
    int priceNumber = 0;

    // access menu items from external file
    try{
      File menuItems = new File("menu.txt");

      // call Scanner to parse the file
      Scanner menuScan = new Scanner(menuItems);
      while(menuScan.hasNextLine()){
        menu[menuNumber] = menuScan.nextLine();
        menuNumber++;
      }
      menuScan.close();
    }
      catch(FileNotFoundException fnf){
        System.out.println("ERROR: FILE NOT FOUND");
      }

    // access prices from external file
    try{
      File priceItems = new File("prices.txt");
      Scanner priceScan = new Scanner(priceItems);
      while(priceScan.hasNextDouble()){
        prices[priceNumber] = priceScan.nextDouble();
        priceNumber++;
      }
      priceScan.close();
    }
      catch(FileNotFoundException fnf){
        System.out.println("ERROR: FILE NOT FOUND");
      }


      // Prompt user input for name
      System.out.println("\nWelcome to the NotSilo Food Truck! Consider Silo Food Truck instead!");
      System.out.print("\nPlease enter your first and last name: ");
      Scanner nameInput = new Scanner(System.in);
      String name = nameInput.nextLine();
      

      // Initialize array for quantities of each menu item
      int[] quantity;
      quantity = new int[3];

      System.out.println("\nEnter the quantity of each item");
      System.out.println("===============================");

      // loop through the menu and prices and get user input for quantites
      for(int i=0; i <= menu.length - 1; i++){
        System.out.printf("\n%s - %.2f:  ", menu[i], prices[i]);
        Scanner quantInput = new Scanner(System.in);
        quantity[i] = quantInput.nextInt();
    }

      // include current date and time
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
      DateTimeFormatter ttf = DateTimeFormatter.ofPattern("H:mm:ss");
      LocalDateTime ldt = LocalDateTime.now();
      String datenow = dtf.format(ldt);
      String timenow = ttf.format(ldt);

      // create unique invoice ID

      // convert first two initials of first and last name to upper case
      String fId = name.substring(0, 2);
      int lindex = name.indexOf(' ');
      int last1 = lindex + 1;
      int last2 = lindex + 3;
      String lId = name.substring(last1, last2);
      String FID = fId.toUpperCase();
      String LID = lId.toUpperCase();
      String NID = FID + LID;

      // acquire unicode values of first and last initials
      int unif = NID.codePointAt(0);
      int unil = NID.codePointAt(2);
      int uniSum = unif + unil;

      // acquire length of full name
      int nameLen = name.length();

      // multiply the sum of the unicode initials by the length of the name
      int idProd = uniSum * nameLen;

      // concatenate the product of the unicode values to the initial id
      String prodString = String.valueOf(idProd);
      String nameID = NID + prodString;

      // extract date and time with no punctuation
      DateTimeFormatter dtID = DateTimeFormatter.ofPattern("MddHHmm");
      String dateID = dtID.format(ldt);

      // concatenate nameID and dateID to form Invoice ID
      String invoiceID = nameID + dateID;

      //initialize FileWriter and BufferedWriter
      try{
        FileWriter fileWriter = new FileWriter(invoiceID + ".txt");
        BufferedWriter buffer = new BufferedWriter(fileWriter);

      // format a receipt
      System.out.println("\n************************************************************\n");
      String invoiceNum = "Invoice Number:";
      System.out.printf("%-25s %-25s %n", invoiceNum, invoiceID);
      String inVID = String.format("%-25s %-25s %n", invoiceNum, invoiceID);
      buffer.write(inVID);

      String daDate = "Date:";
      System.out.printf("%-25s %-25s %n", daDate, datenow);
      String inDATE = String.format("%-25s %-25s %n", daDate, datenow);
      buffer.write(inDATE);

      String daTime = "Time:";
      System.out.printf("%-25s %-25s %n", daTime, timenow);
      String inTIME = String.format("%-25s %-25s %n", daTime, timenow);
      buffer.write(inTIME);

      String items = "Item";
      String quantities = "Quantity";
      String price = "Price";
      String daTotal = "Total";
      System.out.printf("\n\n%-30s %-10s %-10s %-10s %n", items, quantities, price, daTotal);
      System.out.println("============================================================");
      String headings = String.format("\n\n%-30s %-10s %-10s %-10s %n", items, quantities, price, daTotal);
      String breaker = String.format("============================================================");
      buffer.write(headings);
      buffer.write(breaker);
      buffer.flush();

      // Initialize array for each menu item's total order price
      double[] itemTotal;
      itemTotal = new double[3];

      // loop through the menu items and prices and multiply by the quantity
      for(int j=0; j <= menu.length - 1; j++){
        itemTotal[j] = prices[j] * quantity[j];
        System.out.printf("\n%-30s %-10s $%-10.2f $%-10.2f %n", menu[j], quantity[j], prices[j], itemTotal[j]);
        String menuOut = String.format("\n%-30s %-10s $%-10.2f $%-10.2f %n", menu[j], quantity[j], prices[j], itemTotal[j]);
        buffer.write(menuOut);
        buffer.flush();
      }
      System.out.println(breaker);
      buffer.write(breaker);

      // obtain total sum of all food ordered
      double sum = 0;
      for(int k=0; k <= itemTotal.length -1; k++){
        sum += itemTotal[k];
      }
      String subtotal = "Subtotal:";
      System.out.printf("\n%-53s $%-10.2f", subtotal, sum);
      String subOut = String.format("\n%-53s $%-10.2f", subtotal, sum);
      buffer.write(subOut);

      // apply tax and calculate total cost
      double tax = (sum * 6.25) / 100;
      DecimalFormat df = new DecimalFormat("#.##");
      String salestax = "6.25% Sales Tax:";
      System.out.printf("\n%-53s $%-10s", salestax, df.format(tax));
      String taxOut = String.format("\n%-53s $%-10s", salestax, df.format(tax));
      buffer.write(taxOut);

      double total = sum + tax;
      String finalTotal = "Total:";
      System.out.printf("\n%-53s $%-10s", finalTotal, df.format(total));
      String totalOut = String.format("\n%-53s $%-10s", finalTotal, df.format(total));
      buffer.write(totalOut);
      buffer.flush();
      buffer.close();
    }
    catch(IOException ioe){
      System.out.println("Something bad happened with the file");

    }
  }
}
