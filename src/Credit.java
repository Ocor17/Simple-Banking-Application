/**
 * Credit class is the child class of Account and is used in Customer
 * @see Account
 * @see Customer
 *
 * Taken from both Alfredo and Juan
 *
 * @author Alfredo Rodriguez, Juan Gutierrez
 * @version 1.0, 10/27/2020
 * @since October 27, 2020
 */
public class Credit extends Account {

    private int identificationNumber;
    private double creditMax;

    /**
     * This is the default constructor
     */
    public Credit() {
        super();
    }

    /**
     * Constructor for Credit
     *
     * @param identificationNumberIn Receives ID number
     * @param accountNumberIn Receives account number @see Account
     * @param startingBalanceIn Receives starting balance @see Account
     */
    public Credit(int identificationNumberIn, int accountNumberIn, double startingBalanceIn, double creditMaxIn) {
        super(accountNumberIn, startingBalanceIn);
        this.identificationNumber = identificationNumberIn;
        this.creditMax = creditMaxIn;
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

    /**
     * This method sets the max credit balance
     *
     * @param creditMaxIn receives max credit balance
     */
    public void  setCreditMax(double  creditMaxIn){
        this.creditMax = creditMaxIn;
    }

    /**
     * This method gets the max credit balance available
     *
     * @return creditMax
     */
    public double getCreditMax(){
        return creditMax;
    }

}