import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * BaseConverter.java reads files containing the input value, input base, and output base, converts the input values to
 * the output base, prints the input and output values and bases, and writes the results in a new file, "converted.dat".
 * @version 11/19/2020
 * @author 22tanaka
 */
public class BaseConverter {

    private final String hex = "0123456789ABCDEF";

    /**
     * Constructor for class BaseConverter.
     */
    public BaseConverter() {}

    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num, a String representing the original value
     * @param fromBase, a String representing the original base
     * @return a base 10-int
     */
    public int strToInt(String num, String fromBase) {
        int returnInt = 0;
        for (int i = 0; i < num.length(); i++) {
            returnInt += (int)(hex.indexOf(num.charAt(i)) * Math.pow(Integer.parseInt(fromBase), num.length()-i-1));
        }
        return returnInt;
    }

    /**
     * Convert a base-10 int to a String number of base toBase.
     * @param num, a base 10 integer
     * @param toBase, the desired base to convert to
     * @return the resulting value in the desired base as a String
     */
    public String intToStr(int num, int toBase) {
        int addHex;
        String returnStr = "";
        while (num > 0) {
            addHex = num % toBase;
            num /= toBase;
            returnStr = hex.charAt(addHex) + returnStr;
        }
        return returnStr.equals("")? "0" : returnStr;
    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        Scanner input = null, askChoose = new Scanner(System.in);
        String result, toWrite = "datafiles/converted.dat";
        ArrayList<String> toRead = new ArrayList<>();
        try {
            System.out.print("Type 1 to choose a file or 0 to select the default files (values10.dat, values20.dat, values30.dat): ");
            String choice = askChoose.nextLine();
            if(choice.equals("1")) {
                JFileChooser chooseFile = new JFileChooser();
                chooseFile.setCurrentDirectory(new File(System.getProperty("user.home")));
                int res = chooseFile.showOpenDialog(null);
                if (res == JFileChooser.APPROVE_OPTION) {
                    File selFile = chooseFile.getSelectedFile();
                    toRead.add(selFile.getAbsolutePath());
                    System.out.println("Selected File: " + selFile.getAbsolutePath());
                }
            } else if (choice.equals("0")) {
                toRead.add("datafiles/values10.dat");
                toRead.add("datafiles/values20.dat");
                toRead.add("datafiles/values30.dat");
            }
            else {
                System.out.println("Invalid input. Please type 1 or 0.");
                System.out.print("To choose a file, type 1. To select the default files (values10.dat, values20.dat, values30.dat), type 0: ");
            }
            FileWriter write = new FileWriter(toWrite);
            boolean success = false;
            for(String readFile : toRead) {
                input = new Scanner(new File(readFile));
                while (input.hasNext()) {
                    String[] line = input.nextLine().split("\t");

                    if (Integer.parseInt(line[1]) < 2 || Integer.parseInt(line[1]) > 16) {
                        System.out.println("Invalid input base " + line[1]);
                    } else if (Integer.parseInt(line[2]) < 2 || Integer.parseInt(line[2]) > 16) {
                        System.out.println("Invalid output base " + line[2]);
                    } else {
                        result = intToStr(strToInt(line[0], line[1]), Integer.parseInt(line[2]));
                        System.out.println(line[0] + " base " + line[1] + " = " + result + " base " + line[2]);
                        write.write(line[0] + "\t" + line[1] + "\t" + result + "\t" + line[2] + "\n");
                    }
                }
                System.out.println("\n");
                input.close();
                success = true;
            }
            write.close();
            if(!success)
                System.out.println("Selection did not o");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Main method for class BaseConverter
     * @param args, command line arguments, if needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}