import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Customer class is child class of Person and implements Printable.
 * Uses Checking, Savings and Credit for accounts
 * Taken from both Alfredo and Juan
 * @see Person
 * @see Printable
 * @see Checking
 * @see Savings
 * @see Credit
 *
 *
 *
 * @author Alfredo Rodriguez, Juan Gutierrez
 * @version 1.0, 10/27/2020
 * @since October 27, 2020
 */
public class Customer extends Person implements Printable{

    private String password;
    private Savings savingsAcc;
    private Checking checkingAcc;
    private Credit creditAcc;


    /**
     * sets the password of customer
     *
     * @param passwordIn receives password of customer
     */
    public void setPassword(String passwordIn){//May need to be removed depending on how we implement
        this.password = passwordIn;

    }

    /**
     * This method sets the balance for checking account
     *
     * @param amount the amount of money set in checking account
     */
    void setCheckingBalance(double amount){
        checkingAcc.setBalance(amount);
    }

    /**
     * This method gets the balance for checking account
     *
     * @return returns the balance of checking account
     */
    double getCheckingBalance(){
        return checkingAcc.getBalance();
    }

    /**
     * This method sets the account number for checking account
     *
     * @param accountNum
     */
    void setCheckingNum(int accountNum){
        checkingAcc.setAccountNumber(accountNum);
    }

    /**
     *This method gets the checking number for checking account
     *
     * @return returns the account number for checking account
     */
    int getCheckingNum(){
        return checkingAcc.getAccountNumber();
    }

    /**
     *This method sets the account number for savings account
     *
     * @param accountNum the account number for savings account
     */
    void setSavingsNum(int accountNum){
        savingsAcc.setAccountNumber(accountNum);
    }

    /**
     *This method gets the account number for savings account
     *
     * @return returns the account number for savings account
     */
    int getSavingsNum(){
        return savingsAcc.getAccountNumber();
    }

    /**
     *This method sets the balance for savings account
     *
     * @param amount the amount the savings account is set to
     */
    void setSavingsBalance(double amount){
        savingsAcc.setBalance(amount);
    }

    /**
     *This method gets the balance of savings account
     *
     * @return returns the balance of savings account
     */
    double getSavingsBalance(){
        return savingsAcc.getBalance();
    }

    /**
     *This method sets the balance for credit account
     *
     * @param amount the amount the credit account is set to
     */
    void setCreditBalance(double amount){
        creditAcc.setBalance(amount);
    }

    /**
     *This method gets the balance for credit account
     *
     * @return returns the balance for credit account
     */
    double getCreditBalance(){
        return creditAcc.getBalance();
    }

    /**
     *This method sets the account number for credit account
     *
     * @param accountNum the account number for credit acocount
     */
    void setCreditNum(int accountNum){
        creditAcc.setAccountNumber(accountNum);
    }

    /**
     * gets the password of the current account
     *
     * @return returns the password of the current account
     */
    public String getPassword(){
        return this.password;
    }

    /**
     *This method gets the checking account
     *
     * @return returns the checking account as a whole
     */
    public Checking getCheckingAcc(){
        return this.checkingAcc;
    }

    /**
     *This method sets the checking account
     *
     * @param checkingAccIn the checking account as a whole
     */
    public void setCheckingAcc(Checking checkingAccIn){
        this.checkingAcc =checkingAccIn;
    }

    /**
     *This method gets the savings account
     *
     * @return returns the savings account as a whole
     */
    public Savings getSavingsAcc(){
        return this.savingsAcc;
    }

    /**
     *This method sets the savings account
     *
     * @param savingsAccIn the savings account as a whole
     */
    public void setSavingsAcc(Savings savingsAccIn){

        this.savingsAcc = savingsAccIn;

    }

    /**
     *This method gets the credit account
     *
     * @return returns the credit account as a whole
     */
    public Credit getCreditAcc(){
        return this.creditAcc;
    }

    /**
     *This method sets the credit account
     *
     * @param creditAccIn the credit account as a whole
     */
    public void setCreditAcc(Credit creditAccIn){

        this.creditAcc = creditAccIn;

    }

    public boolean getCheckingExists(){
        return checkingAcc.getExists();
    }

    public boolean getSavingsExists(){
        return savingsAcc.getExists();
    }

    public boolean getCreditExists(){
        return creditAcc.getExists();
    }


    /**
     * This is the default constructor
     */
    public Customer() {
        super();
    }

    /**
     * Constructor for Customer
     *
     * @param firstNameIn            Receives first name @see Person
     * @param lastNameIn             Receives last name @see Person
     * @param dateOfBirthIn          Receives date of birth @see Person
     * @param IDNumberIn             Receives ID number @see Person
     * @param addressIn              Receives address @see Person
     * @param phoneNumberIn          Receives phone number @see Person
     * @param emailIn                Receives the email @see Person
     * @param passwordIn             Receives the password
     * @param checkingAccIn          Receives the checking account @see Checking
     * @param savingsAccIn           Receives the savings account @see Savings
     * @param creditAccIn            Receives the credit account @see Credit
     *
     * @see Person
     * @see Checking
     * @see Savings
     * @see Credit
     */
    public Customer(String firstNameIn, String lastNameIn, String dateOfBirthIn, int IDNumberIn, String addressIn, long phoneNumberIn,String emailIn, String passwordIn , Checking checkingAccIn, Savings savingsAccIn, Credit creditAccIn){

        super(firstNameIn,lastNameIn,dateOfBirthIn,IDNumberIn,addressIn,phoneNumberIn, emailIn);

        this.password = passwordIn;
        this.checkingAcc = checkingAccIn;
        this.savingsAcc = savingsAccIn;
        this.creditAcc = creditAccIn;

    }

    /**
     *
     * @param firstNameIn            Receives first name @see Person
     * @param lastNameIn             Receives last name @see Person
     * @param dateOfBirthIn          Receives date of birth @see Person
     * @param IDNumberIn             Receives ID number @see Person
     * @param addressIn              Receives address @see Person
     * @param phoneNumberIn          Receives phone number @see Person
     * @param emailIn                Receives the email @see Person
     * @param passwordIn             Receives the password
     * @param checkingAccIn          Receives the checking account @see Checking
     * @param savingsAccIn           Receives the savings account @see Savings
     *
     */

    public Customer(String firstNameIn, String lastNameIn, String dateOfBirthIn, int IDNumberIn, String addressIn, long phoneNumberIn,String emailIn, String passwordIn , Checking checkingAccIn, Savings savingsAccIn){

        super(firstNameIn,lastNameIn,dateOfBirthIn,IDNumberIn,addressIn,phoneNumberIn, emailIn);

        this.password = passwordIn;
        this.checkingAcc = checkingAccIn;
        this.savingsAcc = savingsAccIn;

    }

    /**
     *
     * @param firstNameIn            Receives first name @see Person
     * @param lastNameIn             Receives last name @see Person
     * @param dateOfBirthIn          Receives date of birth @see Person
     * @param IDNumberIn             Receives ID number @see Person
     * @param addressIn              Receives address @see Person
     * @param phoneNumberIn          Receives phone number @see Person
     * @param emailIn                Receives the email @see Person
     * @param passwordIn             Receives the password
     * @param savingsAccIn           Receives the savings account @see Savings
     * @param creditAccIn            Receives the credit account @see Credit
     *
     */

    public Customer(String firstNameIn, String lastNameIn, String dateOfBirthIn, int IDNumberIn, String addressIn, long phoneNumberIn,String emailIn, String passwordIn ,Savings savingsAccIn, Credit creditAccIn){

        super(firstNameIn,lastNameIn,dateOfBirthIn,IDNumberIn,addressIn,phoneNumberIn, emailIn);

        this.password = passwordIn;
        this.savingsAcc = savingsAccIn;
        this.creditAcc = creditAccIn;

    }

    /**
     * converts the csv file "BankUsers.csv" to an ArrayList of customers with the files information
     *
     * Taken from Juan
     *
     * @return  returns ArrayList containing all information in the "BankUsers.csv" file in separate accounts
     *
     */
    public ArrayList<Customer> csvToArray() {

        //reading from CSV tutorial from javapoint.com
        //put directly into object and put object into array

        //counters used to figure out what data is where in the list
        //current data contains 15 fields, that will be used to compare with modulo
        int IDCount =0, savingNumCount =0, lastNamCount =0, DOBCount =0,
                checkingNumCount =0, creditNumCount =0, phoneNumCount =0, checkingBalCount =0,
                savingBalCount =0, creditMaxCount =0, creditBalCount =0, addressCount =0, firstNamCount =0,
                emailCount = 0, passwordCount =0;

        int mainCounter = 0;
        int columnNum;
        int currentCustomer;
        String current = "";
        //the number of fields


        ArrayList<Customer> accounts = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(new File("CS 3331 - Bank Users 5.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        assert sc != null;
        sc.useDelimiter(","); //from thinkgeek and stackoverflow

        //used to set where each field is to be used with modulo
        while (sc.hasNext() && mainCounter != 15) { //15 represents the number of fields

            if (mainCounter == 14) {
                current = sc.nextLine();
            }
            else {
                current = sc.next();
            }

            //sets values of parameters to be used to find which column their in

            mainCounter++;//iterates after each check
            switch (current) {
                case "Identification Number":
                    IDCount = mainCounter;

                    break;
                case "Savings Account Number":
                    savingNumCount = mainCounter;
                    break;

                case "Last Name":
                    lastNamCount = mainCounter;
                    break;

                case "Date of Birth":
                    DOBCount = mainCounter;

                    break;
                case "Checking Account Number":
                    checkingNumCount = mainCounter;
                    break;

                case "Credit Account Number":
                    creditNumCount = mainCounter;
                    break;

                case "Phone Number":
                    phoneNumCount = mainCounter;
                    break;
                case "Checking Starting Balance":
                    checkingBalCount = mainCounter;
                    break;

                case "Savings Starting Balance":
                    savingBalCount = mainCounter;
                    break;

                case "Credit Max":
                    creditMaxCount = mainCounter;
                    break;
                case "Credit Starting Balance":
                    creditBalCount = mainCounter;
                    break;

                case "Address":
                    addressCount = mainCounter;
                    break;

                case "First Name":
                    firstNamCount = mainCounter;
                    break;
                case "Email":
                    emailCount = mainCounter;
                    break;
                case "Password":
                    passwordCount = mainCounter;
                    break;

            }

        }

        columnNum = mainCounter; //sets columnNum to 15, the number of fields

        while (sc.hasNext()) {
            Checking checkingAcc = new Checking();
            Savings savingsAcc = new Savings();
            Credit creditAcc = new Credit();

            checkingAcc.setExists(true);
            savingsAcc.setExists(true);
            creditAcc.setExists(true);

            currentCustomer =1;
            Customer customerAcc = new Customer();

            customerAcc.setCheckingAcc(checkingAcc);
            customerAcc.setSavingsAcc(savingsAcc);
            customerAcc.setCreditAcc(creditAcc);

            while (currentCustomer <= columnNum) {
                mainCounter++;

                if (currentCustomer >= 15) {
                    current = sc.nextLine().substring(1);

                }
                else {
                    current = sc.next();
                }

                if(mainCounter%columnNum == IDCount) {
                    customerAcc.setIdentificationNumber(Integer.parseInt(current.replaceAll("[\\s\\-]", "")));

                }
                else if(mainCounter%columnNum == savingNumCount) {
                    customerAcc.savingsAcc.setAccountNumber(Integer.parseInt(current));

                }

                else if(mainCounter%columnNum == lastNamCount) {
                    customerAcc.setLastName(current);

                }
                else if(mainCounter%columnNum == DOBCount) {
                    customerAcc.setDateOfBirth(current.concat(", "+sc.next()));

                }
                else if(mainCounter%columnNum == checkingNumCount) {
                    customerAcc.checkingAcc.setAccountNumber(Integer.parseInt(current));

                }
                else if(mainCounter%columnNum == creditNumCount) {
                    customerAcc.creditAcc.setAccountNumber(Integer.parseInt(current));

                }
                else if(mainCounter%columnNum == phoneNumCount) {
                    customerAcc.setPhoneNumber(Long.parseLong(current.replaceAll("\\D", "")));

                }
                else if(mainCounter%columnNum == checkingBalCount) {
                    customerAcc.checkingAcc.setBalance(Double.parseDouble(current));

                }
                else if(mainCounter%columnNum == savingBalCount) {
                    customerAcc.savingsAcc.setBalance(Double.parseDouble(current));

                }
                else if(mainCounter%columnNum == creditMaxCount) {
                    customerAcc.creditAcc.setCreditMax(Integer.parseInt(current));

                }
                else if(mainCounter%columnNum == creditBalCount) {
                    customerAcc.creditAcc.setBalance(Double.parseDouble(current));

                }
                else if(mainCounter%columnNum == addressCount) {
                    customerAcc.setAddress(current.concat(","+sc.next().concat(","+sc.next())));

                }
                else if(mainCounter%columnNum == firstNamCount) {
                    customerAcc.setFirstName(current);

                }
                else if(mainCounter%columnNum == emailCount){
                    customerAcc.setEmail(current);
                }
                else if(mainCounter%columnNum == passwordCount){
                    customerAcc.setPassword(current);
                }
                else{
                    System.out.println("Error in counter, number of fields changed?");
                }

                currentCustomer++;
            }

            accounts.add(customerAcc);

        }

        sc.close();
        return accounts;

    }

    /**
     * This method creates a new account
     *
     * Taken from Alfredo
     *
     * @param customerArrayList Receives array list
     */
    public void createAccount(ArrayList<Customer> customerArrayList) {

        Scanner userInput = new Scanner(System.in);
        Scanner addressScanner = new Scanner(System.in);
        Scanner dobScanner = new Scanner(System.in);
        Checking newChecking = new Checking();
        Savings newSavings = new Savings();
        Credit newCredit =  new Credit();
        Customer customer = new Customer();

        customer.printWelcomeMessage();

        /*
        Code snippet below gets last account to figure out what to set new account IDs too
         */
        int lastAccountID = -1;
        Customer lastCustomer = new Customer();
        for(int i=0; i<customerArrayList.size(); i++){

            if(customerArrayList.get(i).getIdentificationNumber() > lastAccountID){
                lastAccountID = customerArrayList.get(i).getIdentificationNumber();
                lastCustomer = customerArrayList.get(i);
            }

        }

        System.out.println("Please include all fields");
        System.out.print("First name: ");
        String firstName = userInput.next();
        System.out.print("Last name: ");
        String lastName = userInput.next();
        System.out.print("Date of birth (Month Day, Year): ");
        String dateOfBirth = "\"" + dobScanner.nextLine() + "\"";
        System.out.print("Address: ");
        String address = "\"" + addressScanner.nextLine() + "\"";


        long  phoneNumber = 0; // initilization needed to avoid privatizing variable
        while (true) {
            try {
                System.out.print("10-digit phone number: ");
                phoneNumber = userInput.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, not a number");
                userInput.next();
            }
        }
        System.out.print("Email: ");
        String email = userInput.next();
        System.out.print("Password: ");
        String password = userInput.next();

        while (true) {
            try {

                newSavings.setExists(true);
                newSavings.setAccountNumber(lastCustomer.getSavingsNum()+1);
                System.out.println("Savings account number: "+ newSavings.getAccountNumber());
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input, not a number");
                userInput.next();
            }
        }
        while (true) {
            try {
                System.out.print("Amount to deposit into savings: ");
                double amountInput = userInput.nextDouble();
                customer.isAmountNegative(amountInput);
                newSavings.setBalance(amountInput);
                break;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input, not a number");
                userInput.next();

            }
        }
        int identificationNumber = lastCustomer.getIdentificationNumber()+1;

        System.out.println("Would you like to create a Checking account? (y/n)");
        String createAccount = userInput.next().toLowerCase();

        newChecking.setAccountNumber(0);
        newChecking.setStartingBalance(0);


        if (createAccount.equals("y")) {
            newChecking.setExists(true);
            while(true) {
                try {

                    newChecking.setAccountNumber(lastCustomer.getCheckingNum()+1);
                    System.out.println("Enter checking account number: "+newChecking.getAccountNumber());
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, not a number");
                    userInput.next(); //Resets scanner to avoid infinite loop
                }
            }
            while(true) {
                try {
                    System.out.print("Enter amount to deposit into checking: ");
                    newChecking.setBalance(userInput.nextDouble());
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, not a number");
                    userInput.next();
                }
                //checkingCurrentBalance = checkingStartingBalance;
            }
        }
        else{
            newChecking.setExists(false);
        }

        System.out.println("Would you like to create a Credit account? (y/n)");
        createAccount = userInput.next().toLowerCase();

        newCredit.setAccountNumber(0);
        double creditStartingBalance = 0;//DOUBLE CHECK IF NECCESSARY
        newCredit.setStartingBalance(0);
        newCredit.setCreditMax(5000);

        if (createAccount.equals("y")) {
            newCredit.setExists(true);
            while (true) {
                try {

                    newCredit.setAccountNumber(lastCustomer.getCreditAcc().getAccountNumber()+1);
                    System.out.println("Enter credit account number: "+newCredit.getAccountNumber());
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, not a number");
                    userInput.next();
                }
            }
            System.out.println("Congratulations! You were approved for $5000");
            creditStartingBalance = 0;
        }
        else{
            newCredit.setExists(false);
        }

        Customer customerInfo = new Customer(firstName, lastName, dateOfBirth, identificationNumber, address, phoneNumber, email, password, newChecking,newSavings,newCredit);

        customerArrayList.add(customerInfo);

        System.out.println("Information you entered: ");
        customer.printAllFields(customerArrayList.get(identificationNumber - 1));

        System.out.println("Your balance is: ");
        customer.printBalance(customerArrayList, identificationNumber - 1, "");

        System.out.println("Redirecting you to main menu...");
    }


    /**
     * method that prints all details of a single account
     *
     *
     * @param acc the account to print all details of
     */

    @Override
    public void printAllFields(Customer acc) {
        System.out.println("Name: " + acc.getFirstName() + " " + acc.getLastName());
        System.out.println("DOB: " + acc.getDateOfBirth());
        System.out.println("Address: " + acc.getAddress());
        System.out.println("ID: " + acc.getIdentificationNumber());
        System.out.println("Phone number: " + acc.getPhoneNumber());
        System.out.println("Email: " + acc.getEmail());
        System.out.println("Password: " + acc.getPassword());
        System.out.println("Savings Account Number: " + acc.getSavingsAcc().getAccountNumber());
        System.out.println("Checking Account Number: " + acc.getCheckingAcc().getAccountNumber());
        System.out.println("CreditAccount Number: " + acc.getCreditAcc().getAccountNumber());
    }

    /**
     * method that prints the balance of Checking, savings, and credit of an account
     *
     * @param accountList the list of accounts in the bank
     * @param i the index of the account we want from accountList
     * @param accountType the account type
     */

    @Override
    public void printBalance(ArrayList<Customer> accountList, int i, String accountType) {
        System.out.println();
        System.out.println("Checking $: " + accountList.get(i).getCheckingAcc().getBalance());
        System.out.println("Savings  $: " + accountList.get(i).getSavingsAcc().getBalance());
        System.out.println("Credit   $:" + accountList.get(i).getCreditAcc().getBalance());
        System.out.println();
    }


    /**
     * method that prints out a welcome message for a new user
     *
     */

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome new user!");
    }

    /**
     * Method that gives uses MyException when a negative number is found as input
     *
     * @param amount user amount
     * @throws MyException MyExeception
     */
    public void isAmountNegative(double amount) throws MyException {
        if (amount < 0) {
            throw new MyException("Amount invalid. Entering $0.00 as balance.");
        }
    }
}
