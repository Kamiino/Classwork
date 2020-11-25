import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ISBNValidator.java reads through a .dat file containing ISBNs and validates each one and sorts them into one of two
 * arrays: validNums for valid ISBNs and invalidNums for invalid ISBNs. The user can then decide whether they want to
 * view the valid or invalid ISBNs or quit.
 * @version 11/18/2020
 * @author 22tanaka
 */
public class ISBNValidator {

    private String[] validNums; // initialize to hold 1000 items
    private String[] invalidNums; // initialize to hold 1000 item
    ArrayList<String> toRead = new ArrayList<>();

    /**
     * Simple constructor; initializes arrays
     */
    public ISBNValidator() {
        validNums = new String[10000];
        invalidNums = new String[10000];
    }

    /**
     * Imports .dat file, calls isValidISBN method and stores Strings into corresponding arrays
     * note: using self-made isbn file right now; don't have the given isbndb.dat file. Do I need access to their API?
     */
    public void importData() {
        Scanner readFile = null;
        int nextValid = 0, nextInvalid = 0;
        toRead.add("isbn_files/isbn1.dat");
        toRead.add("isbn_files/isbn2.dat");
        toRead.add("isbn_files/isbn3.dat");
        try {
            for (String file : toRead) {
                readFile = new Scanner(new File(file)); // import .dat file
                while (readFile.hasNext()) {
                    String line = readFile.nextLine();
                    // add to validNums if ISBN is valid. if not, then add to invalidNums.
                    if (isValidISBN(line)) {
                        validNums[nextValid] = line;
                        nextValid++;
                        System.out.println(nextValid);
                    } else {
                        invalidNums[nextInvalid] = line;
                        nextInvalid++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error in importData(): " + e);
        }
    }
    /**
     * Determines validity of supplied ISBN number; called inside importData
     * @param isbn, the input ISBN to validate
     * @return a boolean representing whether or not the ISBN is valid
     */
    public boolean isValidISBN(String isbn) {
        String isbnReformat = String.join("", isbn.split("-")); // I wrote this program for ISBN written without delimiters
        if(isbnReformat.length() == 13 && Arrays.asList(new String[]{"978", "979"}).contains(isbnReformat.substring(0, 3))) { // Checks if ISBN length is 13 digits and EAN
            int checkSum = 0;
            String digits = "0123456789"; // valid characters for an ISBN (base 10 digits)
            for(int i = 0; i < isbnReformat.length(); i++) {
                if(!digits.contains(isbnReformat.substring(i, i + 1))) // Checks if the current ISBN character is a base 10 digit
                    return false;
                int c = Integer.parseInt(isbnReformat.substring(i, i+1));
                checkSum += (i+1)%2 == 0? 3*c : c;
            }
            return checkSum % 10 == 0; // checks if the checksum (aka check digit) is valid
        } else
            return false;
    }

    /**
     * Output the user-picked ISBN list or quit the application
     */
    public void runProgram() {
        Scanner hurryUpAndTellMeWhatYouWantToSee = new Scanner(System.in);
        String input;
        label:
        while(true) {
                System.out.println("All ISBN data has been imported and validated. Would you like to:\n" +
                        "\t1) View all valid ISBN numbers\n" +
                        "\t2) View all invalid ISBN numbers\n" +
                        "\t3) Quit\n");
                System.out.print("Your selection: ");
                input = hurryUpAndTellMeWhatYouWantToSee.nextLine();
            switch (input) {
                case "1": // Check valid ISBNs
                    if (validNums[0] == null)
                        System.out.println("All ISBNs in the file are invalid");
                    else for (String num : validNums) {
                        if (num != null)
                            System.out.println(num);
                    } break;
                case "2": // Check invalid ISBNs
                    if(invalidNums[0] == null)
                        System.out.println("All ISBNs in the file are valid");
                    else for (String num : invalidNums){
                        if (num != null)
                            System.out.println(num);
                    } break;
                case "3": // QUIT
                    break label;
                default: // Invalid input
                    System.out.println("Invalid input, please try again.");
            }
            System.out.println();
        }
    }

    /**
     * An inessential method to see if my program is working properly based n the isbn_invalid and valid_printout.txt files.
     * Note: There is only a need to check the invalidNums ISBNs because all validNums should already be filtered into validNums before
     * being able to get put into invalidNums.
     * @return a boolean: true if invalidISBN is confirmed to be invalid, otherwise false.
     */
    public void invalidResultChecker() {
        Scanner readInvalid = null;
        String invalidLine;
        ArrayList<String> confirmedInvalidFiles = new ArrayList<>(), confirmedInvalid = new ArrayList<>();
        confirmedInvalidFiles.add("isbn_files/isbn1_invalid_printout.txt");
        confirmedInvalidFiles.add("isbn_files/isbn2_invalid_printout.txt");
        confirmedInvalidFiles.add("isbn_files/isbn3_invalid_printout.txt");
        try {
            for(String file : confirmedInvalidFiles) {
                readInvalid = new Scanner(new File(file));
                while(readInvalid.hasNext()) {
                    confirmedInvalid.add(readInvalid.nextLine());
                }
            }
            for(String item : invalidNums) {
                if(!confirmedInvalid.contains(item)) {
                    System.out.println("False invalid ISBN: " + item);
                    System.exit(-1);
                }
            }
        } catch(Exception e) {
            System.out.println("Error in invalidResultChecker(): " + e);
        }
    }

    /**
     * Main method for class ISBNValidator
     * @param args, command line arguments, if needed
     */
    public static void main(String[] args){
        ISBNValidator app = new ISBNValidator();
        System.out.println("* ISBN Validator Program *");
        System.out.println("...Importing data...");
        app.importData(); // imports data from the text file
        app.runProgram(); // runs using a while loop; see examples
        System.out.println("* End of Program *");
    }

}