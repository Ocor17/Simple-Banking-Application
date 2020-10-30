import java.io.FileWriter;
import java.io.IOException;
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



    /**
     * method to add bank manager functionality such as showing all aspects of an account
     * @param isBankManager confirms user is bank manager
     * @param acc the ArrayList of Customers
     */

    public static void bankManager(String isBankManager, ArrayList<Customer> acc){

        Scanner input = new Scanner(System.in);


        String firstName = "";
        String lastName ="";
        String payerID = "";
        int payerIndex = -1;
        String loginSelection;

        if (!isBankManager.toLowerCase().equals("y")){//Can delete lines of code with toLowerCase

            System.out.println("choose which account to lookup by entering 1 or 2:\n"+
                    "1. ID number e.g 00\n"+
                    "2. First name and last name\n"+
                    "Press any other key to exit completely");

            loginSelection = input.next();

            if (loginSelection.equals("1")){
                System.out.println("Enter ID number in full e.g 00:");
                payerID = input.next();
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

            for(int i=0; i<acc.size();i++){
                if(acc.get(i).getIdentificationNumber() == Integer.parseInt(payerID) || (acc.get(i).getFirstName().equals(firstName) && acc.get(i).getLastName().equals(lastName))){
                    payerIndex = i;
                }

            }
            if(payerIndex == -1){

                System.out.println("account does not exist");
                return;
            }
            //System.out.println(acc.get(payerIndex).printAllFields());


            return;
        }
        else{
            return;

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
        String payerID = "";
        int payerIndex = -1;
        String isBankManager;
        String loginSelection;


        System.out.println("Are you a Bank Manager? Y/N");
        isBankManager = input.next();

        if(isBankManager.equals("Y") || isBankManager.equals("y")){
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
            payerID = input.next();
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


        for(int i=0; i<acc.size();i++){
            if(acc.get(i).getIdentificationNumber() == Integer.parseInt(payerID) || (acc.get(i).getFirstName().equals(firstName) && acc.get(i).getLastName().equals(lastName))){
                payerIndex = i;
            }

        }
        if(payerIndex == -1){

            System.out.println("account does not exist");
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
                    balanceSubMenu(acc.get(payerIndex));//BALANCE
                    break;

                case "2":
                    transferSubMenu(acc.get(payerIndex));//TRANSFER
                    break;

                case "3":
                    depositSubMenu(acc.get(payerIndex));//DEPOSIT
                    break;

                case "4":
                    withdrawSubMenu(acc.get(payerIndex));//WITHDRAW
                    break;

                case "5":
                    paySomeoneSubMenu(acc.get(payerIndex), acc);//PAY SOMEONE
                    break;

                case "6":
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
    public static void balanceSubMenu(Customer acc){
        Scanner sc= new Scanner(System.in);
        String selection;

        while (true) {

            System.out.println("Choose account type:\n" +
                    "1. Checking\n" +
                    "2. Savings\n" +
                    "3. Credit\n" +
                    "4. Exit");

            selection = sc.nextLine();

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

    }


    /**
     * method to transfer money between any account available of one customer
     *
     * @param acc the customer account that we're transferring funds between
     */
    public static void transferSubMenu(Customer acc){

        Scanner input = new Scanner(System.in);
        String firstAccount;
        String secondAccount;

        double amount;

        while (true) {

            System.out.println("Choose account to transfer FROM:\n" +
                    "1. Checking\n" +
                    "2. Saving\n" +
                    "3. Credit\n" +
                    "4. exit without doing anything");
            firstAccount = input.next();

            if (firstAccount.equals("4")){
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

            switch (firstAccount) {

                case "1": //Transfer from Checking

                    if (secondAccount.equals("1")) { //Transfer to Checking

                        System.out.println("Cannot transfer from Checking to Checking");

                    } else if (secondAccount.equals("2")) {//Transfer to Savings

                        if (amount < acc.getCheckingAcc().getBalance()) {
                            acc.getCheckingAcc().setStartingBalance(acc.getCheckingAcc().getBalance() - amount);
                            acc.getSavingsAcc().setStartingBalance(acc.getSavingsAcc().getBalance() + amount);
                            System.out.println("$" + amount + " was transferred from Checking to Savings");

                            transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "checking", "savings");

                        } else {
                            System.out.println("not enough funds");
                        }
                    } else if (secondAccount.equals("3")) {//Transfer to Credit

                        if (amount < acc.getCheckingAcc().getBalance() && amount < Math.abs(acc.getCreditAcc().getBalance())) {
                            acc.getCheckingAcc().setStartingBalance(acc.getCheckingAcc().getBalance() - amount);
                            acc.getCreditAcc().setStartingBalance(acc.getCreditAcc().getBalance() + amount);
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
                            acc.getSavingsAcc().setStartingBalance(acc.getSavingsAcc().getBalance() - amount);
                            acc.getCheckingAcc().setStartingBalance(acc.getCheckingAcc().getBalance() + amount);
                            System.out.println("$" + amount + " was transferred from Savings to Checking");

                            transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "savings", "checking");

                        } else {
                            System.out.println("Not enough funds");
                        }

                    } else if (secondAccount.equals("2")) {//Transfer to Savings
                        System.out.println("Cannot transfer from Savings to Savings");

                    } else if (secondAccount.equals("3")) {//Transfer to Credit

                        if (amount < acc.getSavingsAcc().getBalance() && amount < Math.abs(acc.getCreditAcc().getBalance())) {
                            acc.getSavingsAcc().setStartingBalance(acc.getSavingsAcc().getBalance() - amount);
                            acc.getCreditAcc().setStartingBalance(acc.getCreditAcc().getBalance() + amount);
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

                        acc.getCreditAcc().setStartingBalance(acc.getCreditAcc().getBalance() - amount);
                        acc.getCreditAcc().setStartingBalance(acc.getCheckingAcc().getBalance() + amount);

                        System.out.println("$" + amount + " was transferred from Credit to Checking");

                        transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "credit", "checking");

                    } else if (secondAccount.equals("2")) {//Transfer to Savings

                        acc.getCreditAcc().setStartingBalance(acc.getCreditAcc().getBalance() - amount);
                        acc.getSavingsAcc().setStartingBalance(acc.getSavingsAcc().getBalance() + amount);

                        System.out.println("$" + amount + " was transferred from Credit to Savings");

                        transactionLog("transfer", acc.getFirstName() + " " + acc.getLastName(), "", amount, "credit", "savings");

                    } else if (secondAccount.equals("3")) {//Transfer to Credit

                        System.out.println("cannot transfer from Credit to Credit");

                    }
                    break;

            }
        }

    }

    /**
     * method to deposit money into any of the three accounts available of one customer
     *
     * @param acc the customer account that we're depositing money into
     */
    public static void depositSubMenu(Customer acc){
        Scanner sc = new Scanner(System.in);
        String selection ;
        double amount = -1;

        while (true) {
            System.out.println("Choose account type:\n" +
                    "1. Checking\n" +
                    "2. Savings\n" +
                    "3. Credit\n" +
                    "4. Exit");
            selection = sc.next();

            if (!selection.equals("4")) { //formatting line to skip this block of code appearing when exit is selected


                while (amount < 0) {
                    System.out.println("enter amount to deposit that is 0 or greater:");
                    try {
                        amount = sc.nextDouble(); //catches user trying to input non-numbers
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please input a number");
                    }
                }
            }

            switch (selection) {
                case "1":
                    acc.getCheckingAcc().setStartingBalance(acc.getCheckingAcc().getBalance() + amount);
                    System.out.println("Succesful deposit of $" + amount +
                            "\nnew balance is: " + acc.getCheckingAcc().getBalance());

                    transactionLog("deposit", acc.getFirstName() + " " + acc.getLastName(), "", amount, "", "checking");

                    break;

                case "2":

                    acc.getSavingsAcc().setStartingBalance(acc.getSavingsAcc().getBalance() + amount);
                    System.out.println("amount in Savings account: $" + amount +
                            "\nnew balance is: " + acc.getSavingsAcc().getBalance());

                    transactionLog("deposit", acc.getFirstName() + " " + acc.getLastName(), "", amount, "", "savings");

                    break;

                case "3":

                    if (amount > Math.abs(acc.getCreditAcc().getBalance())) {
                        System.out.println("Cannot deposit more than what is owed, end balance at most must be 0");
                    } else {
                        acc.getCreditAcc().setStartingBalance(acc.getCreditAcc().getBalance() + amount);
                        System.out.println("amount in Credit account: $" + amount +
                                "\nnew balance is: " + acc.getCreditAcc().getBalance());

                        transactionLog("deposit", acc.getFirstName() + " " + acc.getLastName(), "", amount, "", "credit");

                    }

                    break;

                case "4":
                    return;

            }

        }
    }

    /**
     * method to withdraw money from any available account of one customer
     *
     * @param acc the customer account that we're withdrawing from
     */
    public static void withdrawSubMenu(Customer acc){

        Scanner sc= new Scanner(System.in);
        String selection;
        double amount =0;

        while (true) {

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
                        if (amount <0){
                            System.out.println("cannot withdraw negative money enter 0 or a greater number:");

                        }
                        else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please input a number");
                    }
                }
            }
            switch (selection) {
                case "1":


                    if (acc.getCheckingAcc().getBalance() < amount){
                        System.out.println("not enough funds");
                    }
                    else {
                        acc.getCheckingAcc().setStartingBalance(acc.getCheckingAcc().getBalance()-amount);
                        System.out.println("Withdrew $"+amount+" from checking account, new balance: $" + acc.getCheckingAcc().getBalance());

                        transactionLog("withdraw", acc.getFirstName() + " " + acc.getLastName(), "", amount, "checking", "");

                    }

                    break;

                case "2":

                    if (acc.getSavingsAcc().getBalance() < amount){
                        System.out.println("not enough funds");
                    }
                    else {
                        acc.getSavingsAcc().setStartingBalance(acc.getSavingsAcc().getBalance()-amount);
                        System.out.println("Withdrew $"+amount+" from Savings account, new balance: $" + acc.getSavingsAcc().getBalance());

                        transactionLog("withdraw", acc.getFirstName() + " " + acc.getLastName(), "", amount, "savings", "");

                    }
                    break;

                case "3":
                    return;

            }
        }


    }


    /**
     * function to transfer money from the current customer to another customer
     *
     * @param currentAcc     the current account and account that will be paying
     * @param acc     the account that payer is transferring to
     */

    public static void paySomeoneSubMenu(Customer currentAcc, ArrayList<Customer> acc){

        Scanner sc = new Scanner(System.in);

        String payeeID = "";
        String payeeSelection;
        String payeeFirstName = "";
        String payeeLastName = "";
        String payerSelection;
        int payeeIndex = -1;
        double amount = 0;


        System.out.println("choose how find who you wish to pay by entering 1 or 2:\n"+
                "1. ID number e.g 00\n"+
                "2. First name and last name\n"+
                "Press any other key to exit completely");

        payeeSelection = sc.next();

        if (payeeSelection.equals("1")){
            System.out.println("Enter ID number in full e.g 00:\n");
            payeeID = sc.next();
        }
        else if (payeeSelection.equals("2")){

            System.out.println("Enter first name\n");
            payeeFirstName = sc.next();

            System.out.println("Enter last name\n");
            payeeLastName = sc.next();
        }
        else {
            System.out.println("Goodbye");
            return;
        }


        for(int i=0; i<acc.size();i++){
            if(acc.get(i).getIdentificationNumber() == Integer.parseInt(payeeID) || (acc.get(i).getFirstName().equals(payeeFirstName) && acc.get(i).getLastName().equals(payeeLastName))){
                payeeIndex = i;
            }
        }

        System.out.println("Choose account to pay from:\n" +
                "1. Checking\n" +
                "2. Credit");
        payerSelection = sc.next();

        System.out.println("enter amount to pay");

        try {
            amount = sc.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid input, please input a number");
        }

        if (payerSelection.equals("1")){

            currentAcc.getCheckingAcc().setStartingBalance(currentAcc.getCheckingAcc().getBalance()-amount);//set balance for payer

            acc.get(payeeIndex).getCheckingAcc().setStartingBalance(acc.get(payeeIndex).getCheckingAcc().getBalance()+amount);//set balance for payee



            System.out.println(currentAcc.getFirstName()+" "+currentAcc.getLastName()+" pays $"+amount+
                    " to "+acc.get(payeeIndex).getFirstName()+" "+acc.get(payeeIndex).getLastName());

            transactionLog("paySomeone", currentAcc.getFirstName() + " " + currentAcc.getLastName(), acc.get(payeeIndex).getFirstName() + " " + acc.get(payeeIndex).getLastName(), amount, "checking", "checking");
        }
        else if (payerSelection.equals("2")){

            currentAcc.getCreditAcc().setStartingBalance(currentAcc.getCreditAcc().getBalance()-amount);//set balance for payer

            acc.get(payeeIndex).getCheckingAcc().setStartingBalance(acc.get(payeeIndex).getCheckingAcc().getBalance()+amount);//set balance for payee

            System.out.println(currentAcc.getFirstName()+" "+currentAcc.getLastName()+" pays $"+amount+
                    " to "+acc.get(payeeIndex).getFirstName()+" "+acc.get(payeeIndex).getLastName());

            transactionLog("paySomeone", currentAcc.getFirstName() + " " + currentAcc.getLastName(), acc.get(payeeIndex).getFirstName() + " " + acc.get(payeeIndex).getLastName(), amount, "savings", "checking");

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

}