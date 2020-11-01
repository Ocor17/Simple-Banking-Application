import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Customer class is child class of Person
 *
 * Taken from both Alfredo and Juan
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

    void setCheckingBalance(double amount){
        checkingAcc.setBalance(amount);
    }

    double getCheckingBalance(){
        return checkingAcc.getBalance();
    }

    void setCheckingNum(int accountNum){
        checkingAcc.setAccountNumber(accountNum);
    }

    int getCheckingNum(){
        return checkingAcc.getAccountNumber();
    }

    void setSavingsNum(int accountNum){
        savingsAcc.setAccountNumber(accountNum);
    }

    int getSavingsNum(){
        return savingsAcc.getAccountNumber();
    }

    void setSavingsBalance(double amount){
        savingsAcc.setBalance(amount);
    }

    double getSavingsBalance(){
        return savingsAcc.getBalance();
    }

    void setCreditBalance(double amount){
        creditAcc.setBalance(amount);
    }

    double getCreditBalance(){
        return creditAcc.getBalance();
    }

    void setCreditNum(int accountNum){
        creditAcc.setAccountNumber(accountNum);
    }

    /**
     * gets the password of the current account
     *
     * @return password
     */
    public String getPassword(){
        return this.password;
    }

    public Checking getCheckingAcc(){
        return this.checkingAcc;
    }

    public void setCheckingAcc(Checking checkingAccIn){
        this.checkingAcc =checkingAccIn;
    }

    public Savings getSavingsAcc(){
        return this.savingsAcc;
    }

    public void setSavingsAcc(Savings savingsAccIn){

        this.savingsAcc = savingsAccIn;

    }

    public Credit getCreditAcc(){
        return this.creditAcc;
    }

    public void setCreditAcc(Credit creditAccIn){

        this.creditAcc = creditAccIn;

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
     * @param IDNumberIn Receives ID number @see Person
     * @param addressIn              Receives address @see Person
     * @param phoneNumberIn          Receives phone number @see Person
     */
    public Customer(String firstNameIn, String lastNameIn, String dateOfBirthIn, int IDNumberIn, String addressIn, long phoneNumberIn,String emailIn, String passwordIn , Checking checkingAccIn, Savings savingsAccIn, Credit creditAccIn){

        super(firstNameIn,lastNameIn,dateOfBirthIn,IDNumberIn,addressIn,phoneNumberIn, emailIn);

        this.password = passwordIn;
        this.checkingAcc = checkingAccIn;
        this.savingsAcc = savingsAccIn;
        this.creditAcc = creditAccIn;

    }

    /**
     * converts the csv file "BankUsers.csv" to an ArrayList of customers with the files information
     *
     * Taken from Juan
     *
     * @return                          returns ArrayList containing all information in the "BankUsers.csv" file in separate accounts
     *
     */
    public ArrayList<Customer> csvToArray() {

        //reading from CSV tutorial from javapoint.com
        //put directly into object and put object into array

        //counters used to figure out what data is where in the list
        //current data contains 13 fields, that will be used to compare with modulo
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
            sc = new Scanner(new File("CS 3331 - Bank Users 4.csv"));
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

        columnNum = mainCounter; //sets columnNum to 13, the number of fields

        while (sc.hasNext()) {
            Checking checkingAcc = new Checking();
            Savings savingsAcc = new Savings();
            Credit creditAcc = new Credit();

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
                    System.out.println("YOU SHOULD NOT SEE THIS SOMETHING HAS GONE WRONG WITH COUNTER");
                }

                currentCustomer++;
            }

            accounts.add(customerAcc);

        }

        sc.close();
        //System.out.println(accounts.size());
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

        System.out.println("Please include all fields");
        System.out.print("First name: ");
        String firstName = userInput.next();
        System.out.print("Last name: ");
        String lastName = userInput.next();
        System.out.print("Date of birth (Month Day, Year): ");
        String dateOfBirth = "\"" + dobScanner.nextLine() + "\"";
        System.out.print("Address: ");
        String address = "\"" + addressScanner.nextLine() + "\"";
        System.out.print("10-digit phone number: ");
        long phoneNumber = userInput.nextLong();
        System.out.print("Email: ");
        String email = userInput.next();
        System.out.print("Password: ");
        String password = userInput.next();
        System.out.print("Savings account number: ");
        newSavings.setAccountNumber(userInput.nextInt());
        System.out.print("Amount to deposit into savings: ");
        newSavings.setBalance(userInput.nextDouble());
        int identificationNumber = customerArrayList.size() + 1;

        System.out.println("Would you like to create a Checking account? (y/n)");
        String createAccount = userInput.next().toLowerCase();

        newChecking.setAccountNumber(0);
        newChecking.setStartingBalance(0);


        if (createAccount.equals("y")) { 
            System.out.print("Enter checking account number: ");
            newChecking.setAccountNumber(userInput.nextInt());
            System.out.print("Enter amount to deposit into checking: ");
            newChecking.setBalance(userInput.nextDouble());
            //checkingCurrentBalance = checkingStartingBalance;
        }

        System.out.println("Would you like to create a Credit account? (y/n)");
        createAccount = userInput.next().toLowerCase();

        newCredit.setAccountNumber(0);
        double creditStartingBalance = 0;//DOUBLE CHECK IF NECCESSARY
        newCredit.setStartingBalance(0);
        newCredit.setCreditMax(5000);

        if (createAccount.equals("y")) {
            System.out.print("Enter credit account number: ");
            newCredit.setAccountNumber(userInput.nextInt());
            System.out.print("Congratulations! You were approved for $5000");
            creditStartingBalance = 0;
        }

        Customer customerInfo = new Customer(firstName, lastName, dateOfBirth, identificationNumber, address, phoneNumber, email, password, newChecking,newSavings,newCredit);

        customerArrayList.add(customerInfo);

        System.out.println("Information you entered: ");
        customer.printAllFields(customerArrayList.get(identificationNumber - 1));

        System.out.println("Your balance is: ");
        customer.printBalance(customerArrayList, identificationNumber - 1, "");

        System.out.println("Redirecting you to main menu...");
    }

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

    @Override
    public void printBalance(ArrayList<Customer> accountList, int i, String accountType) {
        System.out.println();
        System.out.println("Checking $: " + accountList.get(i).getCheckingAcc().getBalance());
        System.out.println("Savings  $: " + accountList.get(i).getSavingsAcc().getBalance());
        System.out.println("Credit   $:" + accountList.get(i).getCreditAcc().getBalance());
        System.out.println();
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome new user!");
    }
}
