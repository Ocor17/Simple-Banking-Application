import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Bank Statement class to print out bank statements
 *
 * @author Alfredo Rodriguez
 * @version 1.0, 10/16/2020
 * @since October 15, 2020
 */
public class BankStatement {

    /**
     * This method is to print our the bank statement
     * @param customerArrayList Receives array list
     * @param index Receives index from array list
     * @param checkingStartingBalance Receives checking starting balance
     * @param savingsStartingBalance Receives savings starting balance
     * @param creditStartingBalance Receives credit starting balance
     */
    public void createBankStatement(ArrayList<Customer> customerArrayList, int index, double checkingStartingBalance,
                                    double savingsStartingBalance, double creditStartingBalance) {

        File transactionLog = new File("transactionLog.txt");
        Scanner scanner = null;
        // try and catch to prevent file not found exception
        try {
            scanner = new Scanner(transactionLog);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        // asserting scanner. this was suggested by IntelliJ
        // it would give me an exception without it sometimes
        assert scanner != null;

        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        String today = df.format(new Date());

        try (PrintWriter writer = new PrintWriter(customerArrayList.get(index).getFirstName() + "-BankStatement.txt")) {
            int count = 0;
            writer.println("Miner Bank" + "                                                    Checking Account Number: " + customerArrayList.get(index).getCheckingAcc().getAccountNumber());
            writer.println("                                                              Savings Account Number:  " + customerArrayList.get(index).getSavingsAcc().getAccountNumber());
            writer.println("                                                              Credit Account Number:   " + customerArrayList.get(index).getCreditAcc().getAccountNumber());
            writer.println("                                                              Statement Begin Date: " + today);
            writer.println("                                                              Statement End Date: " + today);
            writer.println(customerArrayList.get(index).getFirstName() + " " + customerArrayList.get(index).getLastName());
            writer.println(customerArrayList.get(index).getAddress());
            writer.println();
            writer.println();
            writer.println("___________________________________ Transactions ____________________________________");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] newLine = line.split(" ");
                if (newLine[0].equals(customerArrayList.get(index).getFirstName()) && newLine[1].equals(customerArrayList.get(index).getLastName())) {
                    writer.println(line);
                }
            }
            writer.println("_____________________________________________________________________________________");
            writer.println("Starting Balance                                                       Ending Balance");
            writer.println();
            writer.println("Checking: $" + checkingStartingBalance + "                                                     Checking: $" + customerArrayList.get(index).getCheckingAcc().getBalance());
            writer.println("Savings:  $" + savingsStartingBalance + "                                                     Savings:  $" + customerArrayList.get(index).getSavingsAcc().getBalance());
            writer.println("Credit:   $" + creditStartingBalance + "                                                    Credit:   $" + customerArrayList.get(index).getCreditAcc().getBalance());
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }

}
