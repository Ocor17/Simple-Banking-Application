import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the RunBank method where the main class it at utilizes MainMenu and Customer.
 * Class taken from both Alfredo and Juan
 * @see MainMenu
 * @see Customer
 *
 *
 *
 * @author Alfredo Rodriguez, Juan Gutierrez
 * @version 1.0 10/27/2020
 * @since October 27, 2020
 */
public class RunBank {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String firstSelection = "";
        Customer managerCustomerObject = new Customer();
        Customer user = new Customer();
        ArrayList<Customer> accounts = managerCustomerObject.csvToArray();
        MainMenu mainMenu = new MainMenu(accounts);
        //mainMenu.test(); //testing main menu variables actually get set

        while (true) {
            System.out.println("What would you like to do\n" +
                    "1. create account\n" +
                    "2. customer login\n" +
                    "3. bank manager\n"+
                    "4. Transaction Reader\n" +
                    "5. exit");
            firstSelection = input.next();

            switch (firstSelection){
                case "1":
                    user.createAccount(accounts);
                    break;

                case "2":
                    mainMenu.mainMenu(accounts);
                    break;

                case "3":
                    mainMenu.bankManager(accounts);
                    break;

                case "4":
                    transactionReader(accounts, "Transaction Actions.csv");
                    break;

                case "5":
                    mainMenu.newBalanceSheet(accounts);
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }

    /**
     * This method reads a transaction action file and performs given operations
     *
     * @param customerArrayList the list of customers of the bank
     * @param fileName receives file name
     */
    public static void transactionReader(ArrayList<Customer> customerArrayList, String fileName) {

        MainMenu mainMenu = new MainMenu();

        int fromFirstNameIndex, fromLastNameIndex, fromWhereIndex, actionIndex, toFirstNameIndex, toLastNameIndex,
                toWhereIndex, actionAmountIndex;
        fromFirstNameIndex = fromLastNameIndex = fromWhereIndex = actionIndex = toFirstNameIndex = toLastNameIndex =
                toWhereIndex = actionAmountIndex = 0;

        // reading csv file
        File transactionActions = new File(fileName);
        Scanner scanner = null;
        // try and catch to prevent file not found exception
        try {
            scanner = new Scanner(transactionActions);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        // asserting scanner. this was suggested by IntelliJ
        // it would give me an exception without it sometimes
        assert scanner != null;

        String header = scanner.nextLine();
        String[] headerArray = header.split(",");

        int i;
        for (i = 0; i < headerArray.length; i++) {

            if (headerArray[i].equals("From First Name")) fromFirstNameIndex = i;
            if (headerArray[i].equals("From Last Name")) fromLastNameIndex = i;
            if (headerArray[i].equals("From Where")) fromWhereIndex = i;
            if (headerArray[i].equals("Action")) actionIndex = i;
            if (headerArray[i].equals("To First Name")) toFirstNameIndex = i;
            if (headerArray[i].equals("To Last Name")) toLastNameIndex = i;
            if (headerArray[i].equals("To Where")) toWhereIndex = i;
            if (headerArray[i].equals("Action Amount")) actionAmountIndex = i;

        }

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] newLine = nextLine.split(",");

            String fromFirstName = null;
            String fromLastName = null;
            String fromWhere = null;
            String toFirstName = null;
            String toLastName = null;
            String toWhere = null;
            double actionAmount = 0;

            String action = newLine[actionIndex];
            if (!action.equals("deposits")) {
                fromFirstName = newLine[fromFirstNameIndex];
                fromLastName = newLine[fromLastNameIndex];
                fromWhere = newLine[fromWhereIndex];
            }
            if (!action.equals("inquires")) {
                if (!action.equals("withdraws")) {
                    toFirstName = newLine[toFirstNameIndex];
                    toLastName = newLine[toLastNameIndex];
                    toWhere = newLine[toWhereIndex];
                }
                String actionAmountString = newLine[actionAmountIndex];
                actionAmount = Double.parseDouble(actionAmountString);
            }

            Customer fromUser = new Customer();
            Customer toUser = new Customer();
            Checking checkingObject = new Checking();

            int fromUserIndex = 0;
            int toUserIndex = 0;

            if (fromFirstName != null) {
                for (i = 0; i < customerArrayList.size(); i++) {
                    if (customerArrayList.get(i).getFirstName().equals(fromFirstName) && customerArrayList.get(i).getLastName().equals(fromLastName)) {
                        fromUserIndex = i;
                    }
                }
            }
            if (toFirstName != null) {
                for (i = 0; i < customerArrayList.size(); i++) {
                    if (customerArrayList.get(i).getFirstName().equals(toFirstName) && customerArrayList.get(i).getLastName().equals(toLastName)) {
                        toUserIndex = i;
                    }
                }
            }

            if (action.equals("pays")) {
                mainMenu.paySomeoneSubMenu(customerArrayList.get(fromUserIndex), customerArrayList, fromWhere, toWhere, toUserIndex, actionAmount);
            }
            if (action.equals("transfers")) {
                mainMenu.transferSubMenu(customerArrayList.get(fromUserIndex), fromWhere, toWhere, actionAmount);
            }
            if (action.equals("inquires")) {
                mainMenu.balanceSubMenu(customerArrayList.get(fromUserIndex), fromWhere);
            }
            if (action.equals("withdraws")) {
                mainMenu.withdrawSubMenu(customerArrayList.get(fromUserIndex), fromWhere, actionAmount);
            }
            if (action.equals("deposits")) {
                mainMenu.depositSubMenu(customerArrayList.get(toUserIndex), actionAmount, toWhere);
            }

        }
    }
}
