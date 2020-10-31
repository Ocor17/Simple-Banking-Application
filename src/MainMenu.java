import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/*

METHODS WILL NEED TO BE EDITED IF CUSTOMER STRUCTURE STAYS AS IS IN 1ST
VERSION BUT SHOULD FIX IF WE CHANGE WHERE WE HAVE CERTAIN ACCOUNT METHODS

 */

public class MainMenu {

    ArrayList<Customer> accounts;

    public MainMenu(){

    }

    public MainMenu(ArrayList<Customer> accountsIn){
        this.accounts = accountsIn;

    }


    public void test(){
        System.out.println(accounts.size());
        for (int i =0; i < accounts.size();i++) {

            System.out.println(accounts.get(i).getFirstName()+", "+accounts.get(i).getCheckingAcc().getBalance()+", "+accounts.get(i).getCheckingAcc().getStartingBalance());
        }
    }


    /**
     * method to add bank manager functionality such as showing all aspects of an account
     * @param isBankManager confirms user is bank manager
     * @param acc the ArrayList of Customers
     */


    public static void bankManager(String isBankManager, ArrayList<Customer> acc){

        Scanner input = new Scanner(System.in);


        String firstName = "";
        String lastName ="";
        int payerID = 0;
        int payerIndex = -1;
        String loginSelection;
        boolean menuExit = false;
        Checking managerObject = new Checking();
        BankStatement manager = new BankStatement();

        while (!menuExit) {
            System.out.println("choose which account to lookup:\n" +
                    "1. Inquire account by type/number\n" +
                    "2. First name and last name\n" +
                    "3. Inquire all accounts\n" +
                    "4. Print bank statement\n" +
                    "Press any other key to exit completely");

            loginSelection = input.next();

            if (loginSelection.equals("1")) {
                System.out.println("What account type?");
                System.out.println("1. Checking");
                System.out.println("2. Savings");
                System.out.println("3. Credit");
                int accountTypeInput = input.nextInt();
                System.out.println("What is the account number?");
                int accountNumberInput = input.nextInt();
                if (accountTypeInput == 1) {
                    int userAccountIndex = managerObject.searchAccount(acc, accountNumberInput);
                    try {
                        managerObject.inquireBalance(acc, userAccountIndex, "checking");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Account does not exist. Returning to menu.");
                    }
                }
                if (accountTypeInput == 2) {
                    int userAccountIndex = managerObject.searchAccount(acc, accountNumberInput);
                    try {
                        managerObject.inquireBalance(acc, userAccountIndex, "savings");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Account does not exist. Returning to menu.");
                    }
                }
                if (accountTypeInput == 3) {
                    int userAccountIndex = managerObject.searchAccount(acc, accountNumberInput);
                    try {
                        managerObject.inquireBalance(acc, userAccountIndex, "credit");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Account does not exist. Returning to menu.");
                    }
                }

            } else if (loginSelection.equals("2")) {

                System.out.println("Enter first name");
                firstName = input.next();

                System.out.println("Enter last name");
                lastName = input.next();

                int userAccountIndex = -1;

                for (int i = 0; i < acc.size(); i++) {
                    if (firstName.equals(acc.get(i).getFirstName()) && lastName.equals(acc.get(i).getLastName())) {
                        userAccountIndex = i;
                    }
                }

                if (userAccountIndex == -1) System.out.println("Account not found. Returning to main menu.");
                else {
                    System.out.println("Account Summary");
                    System.out.println("Checking: $" + acc.get(userAccountIndex).getCheckingAcc().getBalance());
                    System.out.println("Savings:  $" + acc.get(userAccountIndex).getSavingsAcc().getBalance());
                    System.out.println("Credit:   $" + acc.get(userAccountIndex).getCreditAcc().getBalance());
                }


            } else if (loginSelection.equals("3")) {
                for (int i = 0; i < acc.size(); i++) {
                    System.out.println(acc.get(i).getFirstName() + " " + acc.get(i).getLastName());
                    System.out.println("Checking: $" + acc.get(i).getCheckingAcc().getBalance());
                    System.out.println("Savings:  $" + acc.get(i).getSavingsAcc().getBalance());
                    System.out.println("Credit:   $" + acc.get(i).getCreditAcc().getBalance());
                }
            } else if (loginSelection.equals("4")) {
                Scanner lastNameScanner = new Scanner(System.in);
                System.out.println("Please enter customer's information.");
                System.out.print("First name: ");
                String managerFirstNameInput = input.next();
                System.out.print("Last name: ");
                String managerLastNameInput = lastNameScanner.nextLine();
                int userAccountIndex = -1;
                for (int i = 0; i < acc.size(); i++) {
                    if (managerFirstNameInput.equals(acc.get(i).getFirstName()) && managerLastNameInput.equals(acc.get(i).getLastName())) {
                        userAccountIndex = i;
                    }
                }
                if (userAccountIndex != -1) {
                    manager.createBankStatement(acc, userAccountIndex, acc.get(userAccountIndex).getCheckingAcc().getBalance(), acc.get(userAccountIndex).getSavingsAcc().getBalance(), acc.get(userAccountIndex).getCreditAcc().getBalance());
                }
            } else {
                System.out.println("Goodbye");
                return;
            }

        }

    }


    /**
     * a function that displays the main menu used to select and perform common banking functions such as:
     * <ul>
     *    <li>show balance</li>
     *    <li>transfer money</li>
     *    <li>deposit money</li>
     *    <li>withdraw money</li>
     *    <li>exit</li>
     * </ul>
     * @param acc The array list containing the accounts of the bank
     */
    public static void mainMenu(ArrayList<Customer> acc){

        /**
         * @param input scanner class initilization to take user input
         * @param selection used to make a selection in the main menu
         * @param firstName used to take in the accounts first name for login
         * @param lastName used to take in the accounts last name for login
         * @param payerID used to take in the accounts ID number for login
         * @param payerIndex used to gain the array index for the current account
         * @param isBankManager checks if user is the bank manager
         * @param loginSelection hold the current selection for the menu
         */
        Scanner input = new Scanner(System.in);

        String selection;
        String firstName = "";
        String lastName ="";
        int payerID = -1;
        int payerIndex = -1;
        String isBankManager;
        String loginSelection;
        String password;


        System.out.println("Are you a Bank Manager? Y/N");
        isBankManager = input.next();

        if(isBankManager.toLowerCase().equals("y")){
            bankManager(isBankManager, acc);
            return;

        }
        else {
            System.out.println("Proceed to user login");
        }

        System.out.println("choose how to login by entering 1 or 2:\n"+
                "1. ID number e.g 00\n"+
                "2. First name and last name\n"+
                "Press any other key to exit completely");

        loginSelection = input.next();

        if (loginSelection.equals("1")){
            System.out.println("Enter ID number in full e.g 00:");
            payerID = input.nextInt();
        }
        else if (loginSelection.equals("2")){

            System.out.println("Enter first name");
            firstName = input.next();

            System.out.println("Enter last name");
            lastName = input.next();
        }
        else {
            System.out.println("Goodbye");
            return;
        }

        //System.out.println(payerID+" "+firstName+" "+lastName);
        for(int i=0; i<acc.size();i++){
            if(acc.get(i).getIdentificationNumber() == payerID || (acc.get(i).getFirstName().equals(firstName) && acc.get(i).getLastName().equals(lastName))){
                payerIndex = i;
            }

        }
        if(payerIndex == -1){

            System.out.println("account does not exist");
            return;
        }

        System.out.println("enter password:");
        password = input.next();
        if(acc.get(payerIndex).getPassword().equals(password)){
            System.out.println("password correct!");
        }
        else {
            System.out.println("Wrong password! Exiting!");
            return;
        }

        while (true) {
            System.out.println("Select what you want to do by typing only the number\n" +
                    "1. Show balance\n" +
                    "2. Transfer money\n" +
                    "3. Deposit money\n" +
                    "4. Withdraw money\n" +
                    "5. Pay someone\n"+
                    "6. Exit");

            selection = input.next();


            switch (selection) {

                case "1":
                    balanceSubMenu(acc.get(payerIndex), "");//BALANCE
                    break;

                case "2":
                    transferSubMenu(acc.get(payerIndex), "", "", 0);//TRANSFER
                    break;

                case "3":
                    depositSubMenu(acc.get(payerIndex), 0, "");//DEPOSIT
                    break;

                case "4":
                    withdrawSubMenu(acc.get(payerIndex), "", 0);//WITHDRAW
                    break;

                case "5":
                    paySomeoneSubMenu(acc.get(payerIndex), acc, "", "", 0, 0);//PAY SOMEONE
                    break;

                case "6":
                    System.out.println("Returning to home page...");
                    newBalanceSheet(acc);
                    return;

                default:
                    System.out.println("-----------Invalid input!-----------");
            }
        }
    }

    /**
     * balance submenu to help not clutter main menu
     *
     * @param acc the customer account that we're looking for the current balance
     */
    public static void balanceSubMenu(Customer acc, String fromWhere){
        Scanner sc= new Scanner(System.in);
        String selection = "";

        if (fromWhere.equals("")) {
            System.out.println("Choose account type:\n" +
                    "1. Checking\n" +
                    "2. Savings\n" +
                    "3. Credit\n" +
                    "4. Exit");

            selection = sc.nextLine();
        } else {
            if (fromWhere.equals("checking")) selection = "1";
            if (fromWhere.equals("savings")) selection = "1";
            if (fromWhere.equals("credit")) selection = "1";
        }

        switch (selection) {
            case "1":
                System.out.println("amount in Checking account: $" + acc.getCheckingAcc().getBalance());

                transactionLog("inquire balance", acc.getFirstName() + " " + acc.getLastName(), "", 0, "checking", "");

                break;

            case "2":
                System.out.println("amount in Savings account: $" + acc.getSavingsAcc().getBalance());

                transactionLog("inquire balance", acc.getFirstName() + " " + acc.getLastName(), "", 0, "savings", "");

                break;

            case "3":
                System.out.println("amount in Credit account: $" + acc.getCreditAcc().getBalance());

                transactionLog("inquire balance", acc.getFirstName() + " " + acc.getLastName(), "", 0, "credit", "");

                break;

            case "4":

                return;
        }

    }


    /**
     * method to transfer money between any account available of one customer
     *
     * @param acc the customer account that we're transferring funds between
     */
    public static void transferSubMenu(Customer acc, String fromWhere, String toWhere, double actionAmount){

        if (fromWhere.equals("Checking")) fromWhere = "1";
        if (fromWhere.equals("Savings")) fromWhere = "2";
        if (fromWhere.equals("Credit")) fromWhere = "3";
        if (toWhere.equals("Checking")) toWhere = "1";
        if (toWhere.equals("Savings")) toWhere = "2";
        if (toWhere.equals("Credit")) toWhere = "1";

        Scanner input = new Scanner(System.in);
        String firstAccount = fromWhere;
        String secondAccount = toWhere;

        double amount = actionAmount;

        if (firstAccount.equals("")) {
            System.out.println("Choose account to transfer FROM:\n" +
                    "1. Checking\n" +
                    "2. Saving\n" +
                    "3. Credit\n" +
                    "4. exit without doing anything");
            firstAccount = input.next();

            if (firstAccount.equals("4")) {
                return;
            }

            System.out.println("Choose account to transfer TO:\n" +
                    "1. Checking\n" +
                    "2. Saving\n" +
                    "3. Credit\n" +
                    "4. exit without doing anything");
            secondAccount = input.next();

            if (secondAccount.equals("4")) {
                return;
            }

            System.out.println("enter amount to transfer:");
            amount = input.nextDouble();
        }

        switch (firstAccount) {

            case "1": //Transfer from Checking

                if (secondAccount.equals("1")) { //Transfer to Checking

                    System.out.println("Cannot transfer from Checking to Checking");

                } else if (secondAccount.equals("2")) {//Transfer to Savings

                    if (amount < acc.getCheckingAcc().getBalance()) {
                        acc.getCheckingAcc().setBalance(acc.getCheckingAcc().getBalance() - amount);
                        acc.getSavingsAcc().setBalance(acc.getSavingsAcc().getBalance() + amount);
                        System.out.println("$" + amount + " was transferred from Checking to Savings");

                        transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "checking", "savings");

                    } else {
                        System.out.println("not enough funds");
                    }
                } else if (secondAccount.equals("3")) {//Transfer to Credit

                    if (amount < acc.getCheckingAcc().getBalance() && amount < Math.abs(acc.getCreditAcc().getBalance())) {
                        acc.getCheckingAcc().setBalance(acc.getCheckingAcc().getBalance() - amount);
                        acc.getCreditAcc().setBalance(acc.getCreditAcc().getBalance() + amount);
                        System.out.println("$" + amount + " was transferred from Checking to Credit");

                        transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "checking", "credit");

                    } else if (amount > acc.getCheckingAcc().getBalance()) {
                        System.out.println("not enough funds");
                    } else {
                        System.out.println("cannot deposit more than what is owed");
                    }
                }

                break;

            case "2"://Transfer from Savings

                if (secondAccount.equals("1")) {//Transfer to Checking

                    if (amount < acc.getSavingsAcc().getBalance()) {
                        acc.getSavingsAcc().setBalance(acc.getSavingsAcc().getBalance() - amount);
                        acc.getCheckingAcc().setBalance(acc.getCheckingAcc().getBalance() + amount);
                        System.out.println("$" + amount + " was transferred from Savings to Checking");

                        transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "savings", "checking");

                    } else {
                        System.out.println("Not enough funds");
                    }

                } else if (secondAccount.equals("2")) {//Transfer to Savings
                    System.out.println("Cannot transfer from Savings to Savings");

                } else if (secondAccount.equals("3")) {//Transfer to Credit

                    if (amount < acc.getSavingsAcc().getBalance() && amount < Math.abs(acc.getCreditAcc().getBalance())) {
                        acc.getSavingsAcc().setBalance(acc.getSavingsAcc().getBalance() - amount);
                        acc.getCreditAcc().setBalance(acc.getCreditAcc().getBalance() + amount);
                        System.out.println("$" + amount + " was transferred from Savings to Credit");

                        transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "savings", "credit");

                    } else if (amount > acc.getSavingsAcc().getBalance()) {
                        System.out.println("not enough funds");
                    } else {
                        System.out.println("cannot deposit more than what is owed");
                    }

                }
                break;

            case "3"://Transfer from Credit
                if (secondAccount.equals("1")) {//Transfer to Checking

                    acc.getCreditAcc().setBalance(acc.getCreditAcc().getBalance() - amount);
                    acc.getCreditAcc().setBalance(acc.getCheckingAcc().getBalance() + amount);

                    System.out.println("$" + amount + " was transferred from Credit to Checking");

                    transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "credit", "checking");

                } else if (secondAccount.equals("2")) {//Transfer to Savings

                    acc.getCreditAcc().setBalance(acc.getCreditAcc().getBalance() - amount);
                    acc.getSavingsAcc().setBalance(acc.getSavingsAcc().getBalance() + amount);

                    System.out.println("$" + amount + " was transferred from Credit to Savings");

                    transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "credit", "savings");

                } else if (secondAccount.equals("3")) {//Transfer to Credit

                    System.out.println("cannot transfer from Credit to Credit");

                }
                break;

        }

    }

    /**
     * method to deposit money into any of the three accounts available of one customer
     *
     * @param acc the customer account that we're depositing money into
     */
    public static void depositSubMenu(Customer acc, double actionAmount, String toWhere){

        if (toWhere.equals("Checking")) toWhere = "1";
        if (toWhere.equals("Savings")) toWhere = "2";
        if (toWhere.equals("Credit")) toWhere = "3";

        Scanner sc = new Scanner(System.in);
        String selection = toWhere;
        double amount = actionAmount;

        if (selection.equals("")) {
            System.out.println("Choose account type:\n" +
                    "1. Checking\n" +
                    "2. Savings\n" +
                    "3. Credit\n" +
                    "4. Exit");
            selection = sc.next();

            if (!selection.equals("4")) { //formatting line to skip this block of code appearing when exit is selected


                while (amount <= 0) {
                    System.out.println("enter amount to deposit that is 0 or greater:");
                    try {
                        amount = sc.nextDouble(); //catches user trying to input non-numbers
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please input a number");
                    }
                }
            }
        }

        switch (selection) {
            case "1":
                acc.getCheckingAcc().setBalance(acc.getCheckingAcc().getBalance() + amount);
                System.out.println("Succesful deposit of $" + amount +
                        "\nnew balance is: " + acc.getCheckingAcc().getBalance());

                transactionLog("deposit", acc.getFirstName() + " " + acc.getLastName(), "", amount, "", "checking");

                break;

            case "2":

                acc.getSavingsAcc().setBalance(acc.getSavingsAcc().getBalance() + amount);
                System.out.println("amount in Savings account: $" + amount +
                        "\nnew balance is: " + acc.getSavingsAcc().getBalance());

                transactionLog("deposit", acc.getFirstName() + " " + acc.getLastName(), "", amount, "", "savings");

                break;

            case "3":

                if (amount > Math.abs(acc.getCreditAcc().getBalance())) {
                    System.out.println("Cannot deposit more than what is owed, end balance at most must be 0");
                } else {
                    acc.getCreditAcc().setBalance(acc.getCreditAcc().getBalance() + amount);
                    System.out.println("amount in Credit account: $" + amount +
                            "\nnew balance is: " + acc.getCreditAcc().getBalance());

                    transactionLog("deposit", acc.getFirstName() + " " + acc.getLastName(), "", amount, "", "credit");

                }

                break;

            case "4":
                return;

        }
    }

    /**
     * method to withdraw money from any available account of one customer
     *
     * @param acc the customer account that we're withdrawing from
     */
    public static void withdrawSubMenu(Customer acc, String fromWhere, double actionAmount){

        if (fromWhere.equals("Checking")) fromWhere = "1";
        if (fromWhere.equals("Savings")) fromWhere = "2";

        Scanner sc= new Scanner(System.in);
        String selection = fromWhere;
        double amount = actionAmount;

        if (selection.equals("")) {
            System.out.println("Choose account type:\n" +
                    "1. Checking\n" +
                    "2. Savings\n" +
                    "3. Exit");

            selection = sc.next();
            if (!selection.equals("4")) { //formatting line to skip this block of code appearing when exit is selected
                System.out.println("enter amount to withdraw:");

                while (true) {
                    try {
                        amount = sc.nextDouble(); //catches user trying to input non-numbers
                        if (amount < 0) {
                            System.out.println("cannot withdraw negative money enter 0 or a greater number:");

                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please input a number");
                    }
                }
            }
        }
        switch (selection) {
            case "1":


                if (acc.getCheckingAcc().getBalance() < amount){
                    System.out.println("not enough funds");
                }
                else {
                    acc.getCheckingAcc().setBalance(acc.getCheckingAcc().getBalance()-amount);
                    System.out.println("Withdrew $"+amount+" from checking account, new balance: $" + acc.getCheckingAcc().getBalance());

                    transactionLog("withdraw", acc.getFirstName() + " " + acc.getLastName(), "", amount, "checking", "");

                }

                break;

            case "2":

                if (acc.getSavingsAcc().getBalance() < amount){
                    System.out.println("not enough funds");
                }
                else {
                    acc.getSavingsAcc().setBalance(acc.getSavingsAcc().getBalance()-amount);
                    System.out.println("Withdrew $"+amount+" from Savings account, new balance: $" + acc.getSavingsAcc().getBalance());

                    transactionLog("withdraw", acc.getFirstName() + " " + acc.getLastName(), "", amount, "savings", "");

                }
                break;

            case "3":
                return;

        }


    }


    /**
     * function to transfer money from the current customer to another customer
     *
     * @param currentAcc     the current account and account that will be paying
     * @param acc     the account that payer is transferring to
     */

    public static void paySomeoneSubMenu(Customer currentAcc, ArrayList<Customer> acc, String fromWhere, String toWhere, int toUserIndex, double actionAmount){

        if (fromWhere.equals("Checking")) fromWhere = "1";
        if (fromWhere.equals("Savings")) fromWhere = "2";
        if (toWhere.equals("Checking")) toWhere = "1";
        if (toWhere.equals("Savings")) toWhere = "2";

        Scanner sc = new Scanner(System.in);

        String payeeID = "";
        String payeeSelection = toWhere;
        String payeeFirstName = "";
        String payeeLastName = "";
        String payerSelection = fromWhere;
        String toAccount = "";
        int payeeIndex = toUserIndex;
        double amount = actionAmount;

        if (fromWhere.equals("")) {
            System.out.println("Choose account to pay from:\n" +
                    "1. Checking\n" +
                    "2. Savings");
            payerSelection = sc.next();

            System.out.println("choose how find who you wish to pay by entering 1 or 2:\n" +
                    "1. ID number e.g 00\n" +
                    "2. First name and last name\n" +
                    "Press any other key to exit completely");

            payeeSelection = sc.next();

            if (payeeSelection.equals("1")) {
                System.out.println("Enter ID number in full e.g 00:");
                payeeID = sc.next();
            } else if (payeeSelection.equals("2")) {

                System.out.println("Enter first name\n");
                payeeFirstName = sc.next();

                System.out.println("Enter last name\n");
                payeeLastName = sc.next();
            } else {
                System.out.println("Goodbye");
                return;
            }

            for (int i = 0; i < acc.size(); i++) {
                if (acc.get(i).getIdentificationNumber() == Integer.parseInt(payeeID) || (acc.get(i).getFirstName().equals(payeeFirstName) && acc.get(i).getLastName().equals(payeeLastName))) {
                    payeeIndex = i;
                }
            }

            System.out.println("Please select the other person's account:\n" +
                    "1. Checking\n" +
                    "2. Savings");
            toAccount = sc.next();

            System.out.println("enter amount to pay");

            try {
                amount = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
            }
        }

        if (payerSelection.equals("1")){

            assert currentAcc != null;
            currentAcc.getCheckingAcc().setBalance(currentAcc.getCheckingAcc().getBalance()-amount);//set balance for payer


            System.out.println(currentAcc.getFirstName()+" "+currentAcc.getLastName()+" pays $"+amount+
                    " to "+acc.get(payeeIndex).getFirstName()+" "+acc.get(payeeIndex).getLastName());

            transactionLog("paySomeone", currentAcc.getFirstName() + " " + currentAcc.getLastName(), acc.get(payeeIndex).getFirstName() + " " + acc.get(payeeIndex).getLastName(), amount, "checking", "checking");
        }
        else if (payerSelection.equals("2")){

            assert currentAcc != null;
            currentAcc.getSavingsAcc().setBalance(currentAcc.getSavingsAcc().getBalance()-amount);//set balance for payer

            System.out.println(currentAcc.getFirstName()+" "+currentAcc.getLastName()+" pays $"+amount+
                    " to "+acc.get(payeeIndex).getFirstName()+" "+acc.get(payeeIndex).getLastName());

            transactionLog("paySomeone", currentAcc.getFirstName() + " " + currentAcc.getLastName(), acc.get(payeeIndex).getFirstName() + " " + acc.get(payeeIndex).getLastName(), amount, "savings", "checking");

        }

        //set balance for payee
        if (toAccount.equals("1") || toWhere.equals("checking")) {
            acc.get(payeeIndex).getCheckingAcc().setBalance(acc.get(payeeIndex).getCheckingAcc().getBalance()+amount);
        }
        if (toAccount.equals("2") || toWhere.equals("savings")) {
            acc.get(payeeIndex).getSavingsAcc().setBalance(acc.get(payeeIndex).getSavingsAcc().getBalance()+amount);
        }
        else {
            return;
        }
    }

    public static void transactionLog(String transactionType, String userName, String otherUserName, double amount, String fromAccount, String toAccount) {

        // using try and catch to prevent IOException error
        // file will be created if it does not exist, otherwise it will append information
        // adding if statements that will write different info depending on transaction types
        try {
            FileWriter transLogWriter = new FileWriter("transactionLog.txt", true);
            if (transactionType.equals("inquire balance")) {
                transLogWriter.write(userName + " inquired his/her " + fromAccount + " balance.\n");
            }
            if (transactionType.equals("paySomeone")) {
                transLogWriter.write(userName + " payed $" + amount + " to " + otherUserName + ".\n");
            }
            if (transactionType.equals("deposit")) {
                transLogWriter.write(userName + " deposited $" + amount + " into their " + fromAccount + " account.\n");
            }
            if (transactionType.equals("transfer")) {
                transLogWriter.write(userName + " transferred $" + amount + " from their " + fromAccount + " account to their " + toAccount + ".\n");
            }
            if (transactionType.equals("withdraw")) {
                transLogWriter.write(userName + " withdrew $" + amount + " from their " + fromAccount + " account.\n");
            }
            transLogWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     * This method is used to keep track of the new balances on a csv file called newBalanceSheet.csv
     *
     * @param customerArrayList Receives customer array list.
     */
    public static void newBalanceSheet(ArrayList<Customer> customerArrayList) {

        try (PrintWriter writer = new PrintWriter("New Balance Sheet.csv")) {
            writer.println("First Name,Last Name,Date of Birth,IdentificationNumber,Address,Phone Number,Checking Account Number,Savings Account Number,Credit Account Number,Checking Starting Balance,Savings Starting Balance,Credit Starting Balance, Password, Email,Credit Max");
            for (int i = 0; i < customerArrayList.size(); i++) {
                writer.print(customerArrayList.get(i).getFirstName() + ",");
                writer.print(customerArrayList.get(i).getLastName() + ",");
                writer.print(customerArrayList.get(i).getDateOfBirth() + ",");
                writer.print(customerArrayList.get(i).getIdentificationNumber() + ",");
                writer.print(customerArrayList.get(i).getAddress() + ",");
                writer.print(customerArrayList.get(i).getPhoneNumber() + ",");
                writer.print(customerArrayList.get(i).getCheckingAcc().getAccountNumber() + ",");
                writer.print(customerArrayList.get(i).getSavingsAcc().getAccountNumber() + ",");
                writer.print(customerArrayList.get(i).getCreditAcc().getAccountNumber() + ",");
                writer.print(customerArrayList.get(i).getCheckingAcc().getBalance() + ",");
                writer.print(customerArrayList.get(i).getSavingsAcc().getBalance() + ",");
                writer.print(customerArrayList.get(i).getCreditAcc().getBalance() + ",");
                writer.print(customerArrayList.get(i).getPassword() + ",");
                writer.print(customerArrayList.get(i).getEmail() + ",");
                writer.println(customerArrayList.get(i).getCreditAcc().getCreditMax());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }

}