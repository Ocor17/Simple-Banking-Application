/**
 * Savings class is child class of Account and is used in Customer.
 * Taken from both Alfredo and Juan.
 *  @see Savings
 * @see Customer
 *
 *
 *
 * @author Alfredo Rodriguez, Juan Gutierrez
 * @version 1.0, 10/27/2020
 * @since October 27, 2020
 */
public class Savings extends Account {

    private int identificationNumber;

    /**
     * This is the default constructor
     */
    public Savings() {
        super();
    }

    /**
     * Constructor for Savings
     *
     * @param identificationNumberIn Receives ID number
     * @param accountNumberIn Receives account number @see Account
     * @param startingBalanceIn Receives starting balance @see Account
     */
    public Savings(int identificationNumberIn, int accountNumberIn, double startingBalanceIn) {
        super(accountNumberIn, startingBalanceIn);
        this.identificationNumber = identificationNumberIn;
    }

    /**
     * This method gets ID number
     *
     * @return ID number
     */
    public int getIdentificationNumber() {
        return this.identificationNumber;
    }

    /**
     * This method sets ID number
     *
     * @param identificationNumberIn Receives ID number
     */
    public void setIdentificationNumber(int identificationNumberIn) {
        this.identificationNumber = identificationNumberIn;
    }
}
