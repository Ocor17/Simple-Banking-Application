import java.util.ArrayList;

/**
 * Account class is an abstract class that is the parent of Checking, Savings and Credit classes.
 * It includes getters and setters as well as multiple methods that will work with the main RunBank class and its child classes.
 * Taken from both Alfredo and Juan
 * @see Checking
 * @see Savings
 * @see Credit
 *
 * @author Alfredo Rodriguez, Juan Gutierrez
 * @version 1.0, 10/27/2020
 * @since October 27, 2020
 *
 */
    public abstract class Account {

    // initializing attributes
    private int accountNumber;
    private double startingBalance = Double.NaN;
    private double balance;

    /**
     * This is the default constructor
     */
    public Account() {
    }

    /**
     * Constructor for Account
     *
     * @param accountNumberIn   Either Checking, Savings or Credit account number.
     * @param startingBalanceIn Either Checking, Savings or Credit starting balance.
     */
    public Account(int accountNumberIn, double startingBalanceIn) {
        this.accountNumber = accountNumberIn;
        this.startingBalance = startingBalanceIn;
        this.balance = startingBalanceIn;
    }

    /**
     * This method gets the account number.
     *
     * @return account number
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * This method sets the account number.
     *
     * @param accountNumberIn Received account number.
     */
    public void setAccountNumber(int accountNumberIn) {
        this.accountNumber = accountNumberIn;
    }

    /**
     * This method gets the balance of the account.
     *
     * @return balance
     */
    public double getStartingBalance() {
        return this.startingBalance;
    }

    /**
     * This method sets the balance.
     *
     * @param startingBalanceIn Receives balance.
     */
    public void setStartingBalance(double startingBalanceIn) {

        this.startingBalance = startingBalanceIn;
    }

    /**
     * gets the balance of an account
     *
     * @return returns the balance of the account
     */

    public double getBalance() {
        return this.balance;
    }

    /**
     * sets the balance of an account
     *
     * @param balanceIn the amount to set the balance to
     */

    public void setBalance(double balanceIn) {
        if(Double.isNaN(startingBalance)){
            this.startingBalance = balanceIn;
        }
        this.balance = balanceIn;
    }

    /**
     *  searches for accounts based on account number
     *
     * @param customerArrayList the list of accounts in the bank
     * @param accountNumber the ID number of the current account
     * @return returns the index of the account matching the ID number
     */

    public int searchAccount(ArrayList<Customer> customerArrayList, int accountNumber) {

        int i;

        for (i = 0; i < customerArrayList.size(); i++) {
            if (accountNumber == customerArrayList.get(i).getCheckingAcc().getAccountNumber() || accountNumber == customerArrayList.get(i).getSavingsAcc().getAccountNumber() || accountNumber == customerArrayList.get(i).getCreditAcc().getAccountNumber()) {
                break;
            }
        }

        return i;
    }

}
