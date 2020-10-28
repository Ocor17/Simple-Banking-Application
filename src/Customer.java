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
public class Customer extends Person {

    private int checkingAccountNumber;
    private double checkingStartingBalance;
    private double checkingCurrentBalance;
    private int savingsAccountNumber;
    private double savingsStartingBalance;
    private double savingsCurrentBalance;
    private int creditAccountNumber;
    private double creditStartingBalance;
    private double creditCurrentBalance;
    private int creditMax;
    private String password;
    //private final Checking userChecking = new Checking();

    /**
     * This method gets the checking account number
     *
     * @return checking account number
     */
    public int getCheckingAccountNumber() {
        return this.checkingAccountNumber;
    }

    /**
     * This method sets checking account number
     *
     * @param checkingAccountNumberIn Receives checking account number
     */
    public void setCheckingAccountNumber(int checkingAccountNumberIn) {
        this.checkingAccountNumber = checkingAccountNumberIn;
    }

    /**
     * This method gets the starting balance
     *
     * @return checking starting balance
     */
    public double getCheckingStartingBalance() {
        return this.checkingStartingBalance;
    }

    /**
     * This method sets the checking starting balance
     *
     * @param checkingStartingBalanceIn Receives checking starting balance
     */
    public void setCheckingStartingBalance(double checkingStartingBalanceIn) {
        this.checkingStartingBalance = checkingStartingBalanceIn;
    }

    /**
     * This method gets the checking current balance
     *
     * @return checking current balance
     */
    public double getCheckingCurrentBalance() {
        return this.checkingCurrentBalance;
    }

    /**
     * This method sets the checking current balance
     *
     * @param checkingCurrentBalanceIn Receives checking current balance
     */
    public void setCheckingCurrentBalance(double checkingCurrentBalanceIn) {
        this.checkingCurrentBalance = checkingCurrentBalanceIn;
    }

    /**
     * This method gets the savings account number
     *
     * @return savings account number
     */
    public int getSavingsAccountNumber() {
        return this.savingsAccountNumber;
    }

    /**
     * This method sets savings account number
     *
     * @param savingsAccountNumberIn receives savings account number
     */
    public void setSavingsAccountNumber(int savingsAccountNumberIn) {
        this.savingsAccountNumber = savingsAccountNumberIn;
    }

    /**
     * This method gets the savings starting balance
     *
     * @return savings starting balance
     */
    public double getSavingsStartingBalance() {
        return this.savingsStartingBalance;
    }

    /**
     * This method sets the savings starting balance
     *
     * @param savingsStartingBalanceIn Receives savings starting balance
     */
    public void setSavingsStartingBalance(double savingsStartingBalanceIn) {
        this.savingsStartingBalance = savingsStartingBalanceIn;
    }

    /**
     * This method gets the savings current balance
     *
     * @return savings current balance
     */
    public double getSavingsCurrentBalance() {
        return this.savingsCurrentBalance;
    }

    /**
     * This method sets savings current balance
     *
     * @param savingsCurrentBalanceIn Receives savings current balance
     */
    public void setSavingsCurrentBalance(double savingsCurrentBalanceIn) {
        this.savingsCurrentBalance = savingsCurrentBalanceIn;
    }

    /**
     * This method gets the credit account number
     *
     * @return credit account number
     */
    public int getCreditAccountNumber() {
        return this.creditAccountNumber;
    }

    /**
     * This method sets credit account number
     *
     * @param creditAccountNumberIn Receives credit account number
     */
    public void setCreditAccountNumber(int creditAccountNumberIn) {
        this.creditAccountNumber = creditAccountNumberIn;
    }

    /**
     * This method gets the credit starting balance
     *
     * @return credit starting balance
     */
    public double getCreditStartingBalance() {
        return this.creditStartingBalance;
    }

    /**
     * This method sets the credit starting balance
     *
     * @param creditStartingBalanceIn Receives credit starting balance
     */
    public void setCreditStartingBalance(double creditStartingBalanceIn) {
        this.creditStartingBalance = creditStartingBalanceIn;
    }

    /**
     * This method gets the credit current balance
     *
     * @return credit current balance
     */
    public double getCreditCurrentBalance() {
        return this.creditCurrentBalance;
    }

    /**
     * This method sets credit current balance
     *
     * @param creditCurrentBalanceIn Receives credit current balance
     */
    public void setCreditCurrentBalance(double creditCurrentBalanceIn) {
        this.creditCurrentBalance = creditCurrentBalanceIn;
    }

    /**
     * This method gets credit max
     *
     * @return credit max
     */
    public int getCreditMax() {
        return this.creditMax;
    }

    /**
     * This method sets credit max
     *
     * @param creditMaxIn Receives credit max
     */
    public void setCreditMax(int creditMaxIn) {
        this.creditMax = creditMaxIn;
    }

    /**
     * This is the default constructor
     */


    /**
     * sets the password of customer
     *
     * @param passwordIn receives password of customer
     */
    public void setPassword(String passwordIn){//May need to be removed depending on how we implement
        this.password = passwordIn;

    }

    /**
     * gets the password of the current account
     *
     * @return password
     */
    public String getPassword(){
        return this.password;
    }

    public Customer() {
        super();
    }

    /**
     * Constructor for Customer
     *
     * @param firstNameIn            Receives first name @see Person
     * @param lastNameIn             Receives last name @see Person
     * @param dateOfBirthIn          Receives date of birth @see Person
     * @param identificationNumberIn Receives ID number @see Person
     * @param addressIn              Receives address @see Person
     * @param phoneNumberIn          Receives phone number @see Person
     */
    public Customer(String firstNameIn, String lastNameIn, String dateOfBirthIn, int identificationNumberIn, String addressIn,
                    long phoneNumberIn, int checkingAccountNumberIn, int savingsAccountNumberIn, int creditAccountNumberIn,
                    double checkingStartingBalanceIn, double savingsStartingBalanceIn, double creditStartingBalanceIn, double checkingCurrentBalanceIn, double savingsCurrentBalanceIn, double creditCurrentBalanceIn, int creditMaxIn) {
        super(firstNameIn, lastNameIn, dateOfBirthIn, identificationNumberIn, addressIn, phoneNumberIn);
        this.checkingAccountNumber = checkingAccountNumberIn;
        this.savingsAccountNumber = savingsAccountNumberIn;
        this.creditAccountNumber = creditAccountNumberIn;
        this.checkingStartingBalance = checkingStartingBalanceIn;
        this.savingsStartingBalance = savingsStartingBalanceIn;
        this.creditStartingBalance = creditStartingBalanceIn;
        this.checkingCurrentBalance = checkingCurrentBalanceIn;
        this.savingsCurrentBalance = savingsCurrentBalanceIn;
        this.creditCurrentBalance = creditCurrentBalanceIn;
        this.creditMax = creditMaxIn;
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
                savingBalCount =0, creditMaxCount =0, creditBalCount =0, addressCount =0, firstNamCount =0;

        int mainCounter = 0;
        int columnNum;
        int currentCustomer;
        String current = "";
        //the number of fields


        ArrayList<Customer> accounts = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(new File("CS 3331 - Bank Users 3.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        assert sc != null;
        sc.useDelimiter(","); //from thinkgeek and stackoverflow

        //used to set where each field is to be used with modulo
        while (sc.hasNext() && mainCounter != 13) {

            if (mainCounter == 12) {
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

            }

        }

        columnNum = mainCounter; //sets columnNum to 13, the number of fields

        while (sc.hasNext()) {

            currentCustomer =1;
            Customer customerAcc = new Customer();

            while (currentCustomer <= columnNum) {
                mainCounter++;

                if (currentCustomer >= 13) {
                    current = sc.nextLine().substring(1);

                }
                else {
                    current = sc.next();
                }

                if(mainCounter%columnNum == IDCount) {
                    customerAcc.setIdentificationNumber(Integer.parseInt(current.replaceAll("[\\s\\-]", "")));

                }
                else if(mainCounter%columnNum == savingNumCount) {
                    customerAcc.setSavingsAccountNumber(Integer.parseInt(current));

                }

                else if(mainCounter%columnNum == lastNamCount) {
                    customerAcc.setLastName(current);

                }
                else if(mainCounter%columnNum == DOBCount) {
                    customerAcc.setDateOfBirth(current);

                }
                else if(mainCounter%columnNum == checkingNumCount) {
                    customerAcc.setCheckingAccountNumber(Integer.parseInt(current));

                }
                else if(mainCounter%columnNum == creditNumCount) {
                    customerAcc.setCreditAccountNumber(Integer.parseInt(current));

                }
                else if(mainCounter%columnNum == phoneNumCount) {
                    customerAcc.setPhoneNumber(Long.parseLong(current.replaceAll("\\D", "")));

                }
                else if(mainCounter%columnNum == checkingBalCount) {
                    customerAcc.setCheckingStartingBalance(Double.parseDouble(current));
                    customerAcc.setCheckingCurrentBalance(Double.parseDouble(current));

                }
                else if(mainCounter%columnNum == savingBalCount) {
                    customerAcc.setSavingsStartingBalance(Double.parseDouble(current));
                    customerAcc.setSavingsCurrentBalance(Double.parseDouble(current));

                }
                else if(mainCounter%columnNum == creditMaxCount) {
                    customerAcc.setCreditMax(Integer.parseInt(current));

                }
                else if(mainCounter%columnNum == creditBalCount) {
                    customerAcc.setCreditStartingBalance(Double.parseDouble(current));
                    customerAcc.setCreditCurrentBalance(Double.parseDouble(current));

                }
                else if(mainCounter%columnNum == addressCount) {
                    customerAcc.setAddress(current.concat(","+sc.next().concat(","+sc.next())));

                }
                else if(mainCounter%columnNum == firstNamCount) {
                    customerAcc.setFirstName(current);

                }
                else{
                    System.out.println("YOU SHOULD NOT SEE THIS SOMETHING HAS GONE WRONG WITH COUNTER");
                }

                currentCustomer++;
            }
            //System.out.println(customerAcc.printAllFields());

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
        System.out.print("Savings account number: ");
        int savingsAccountNumber = userInput.nextInt();
        System.out.print("Amount to deposit into savings: ");
        double savingsStartingBalance = userInput.nextDouble();
        double savingsCurrentBalance = savingsStartingBalance;
        int identificationNumber = customerArrayList.size() + 1;

        System.out.println("Would you like to create a Checking account? (y/n)");
        String createAccount = userInput.next().toLowerCase();

        int checkingAccountNumber = 0;
        double checkingStartingBalance = 0;
        double checkingCurrentBalance = checkingStartingBalance;

        if (createAccount.equals("y")) {
            System.out.print("Enter checking account number: ");
            checkingAccountNumber = userInput.nextInt();
            System.out.print("Enter amount to deposit into checking: ");
            checkingStartingBalance = userInput.nextDouble();
            checkingCurrentBalance = checkingStartingBalance;
        }

        System.out.println("Would you like to create a Credit account? (y/n)");
        createAccount = userInput.next().toLowerCase();

        int creditAccountNumber = 0;
        double creditStartingBalance = 0;
        double creditCurrentBalance = 0;
        int creditMax = 5000;

        if (createAccount.equals("y")) {
            System.out.print("Enter credit account number: ");
            creditAccountNumber = userInput.nextInt();
            System.out.print("Congratulations! You were approved for $5000");
            creditStartingBalance = 0;
        }

        Customer customerInfo = new Customer(firstName, lastName, dateOfBirth, identificationNumber, address, phoneNumber, checkingAccountNumber, savingsAccountNumber, creditAccountNumber, checkingStartingBalance, savingsStartingBalance, creditStartingBalance, checkingCurrentBalance, savingsCurrentBalance, creditCurrentBalance, creditMax);

        customerArrayList.add(customerInfo);

        System.out.println("Redirecting you to main menu...");
    }
}
