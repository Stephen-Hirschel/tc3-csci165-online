import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Tickets{

    public static void main(String[] args){

        /*
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt

        */
        // Create an array to store all ticket numbers
        String[] tix;
        tix = new String[1000];
        // Use try/catch to avoid errors connecting to a file
        try{
          // Access text file using File instance
          File ticketMaster = new File("tickets.txt");

          // Call Scanner to parse tickets.txt
          Scanner rawTickets = new Scanner(ticketMaster);

          // I set these variables to ensure that I was capturing all of the
          // data from the file
          int lineNumber = 1;
          int tixNumber = 0;

          // Set a boolean to control a while loop to stop scanning when there are
          // no more lines to read
          while(rawTickets.hasNextLine()){

            // add ticket numbers to the array
            tix[tixNumber] = rawTickets.nextLine();
            // System.out.println("Ticket# " + lineNumber +" is "+ tix[tixNumber]);
            tixNumber++;

          }
          rawTickets.close(); // close the Scanner
        }
        catch(FileNotFoundException fnf){
          System.out.println("ERROR: FILE NOT FOUND!"); // failsafe for potential errors
        }
        // initialize FileWriter and BufferWriter to record results in a seperate file

        try{
          FileWriter fileWriter = new FileWriter("valid_tix.txt");
          BufferedWriter buffer = new BufferedWriter(fileWriter);


        for(int i=0; i <= tix.length -1; i++){
        // Assign ticket number as a String variable, because you want the value to be searchable,
        // extractable and easy to compare. Also immutable, so you won't lose the original value.
        String  ticket  = tix[i];
        // Assign a new variable to the substring necessary to perform the validation equation, while
        // leaving the original ticket number intact.  This variable will separate the last digit
        // from the ticket number for future use.
        String  last = ticket.substring(ticket.length() - 1);
        // Assign the last digit of the ticket as and int varaible, so that mathematical
        // functions may be done with it.
        int     last_digit = Integer.valueOf(last);
        // Assign a new String variable that consists of the original ticket without
        // the extracted last digit.
        String  reduced_ticket = ticket.substring(0, ticket.length() - 1);
        // Convert the reduced ticket to an int variable so that mathematical functions
        // may be used on it.
        int     ticket_number = Integer.valueOf(reduced_ticket);
        // Assign a new int variable to the value of the remaining ticket number and
        // do modulo division on it per the verification process.
        int     remainder = ticket_number % 7;
        // Validate ticket number with a boolean to determine if it is legitimate
        // per the verification process
        boolean validity = remainder == last_digit;
        // create an if statement to capture valid ticket numbers
          if(validity == true){
            buffer.write(tix[i] + "\n"); // write the data plus formatting
            buffer.flush(); // flush the buffer
          }

        }
        buffer.close(); //close the buffer
      }
      // include a failsafe for IOExceptions
        catch(IOException ioe){
          System.out.println("Something bad happened with the file");
        }
        // Consolidate all values determined during the verification process into a
        // new String variable in a format to be displayed to the user.
        // String  format = "Original Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n";
        // Display the outcome to the user.
        // System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity);

      }
    }
