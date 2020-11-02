import java.util.ArrayList;

/**
 * Printable is a class that is an interface used in Customer and MainMenu
 * @see MainMenu
 * @see Customer
 *
 *  @author Alfredo Rodriguez, Juan Gutierrez
 *  @version 1.0 10/27/2020
 *  @since October 27, 2020
 *
 */

public interface Printable {

    /**
     * this method is a template to print all customer details
     * @param acc the account of the customer
     */
    void printAllFields(Customer acc);

    /**
     * template prints the balance of a specific account of a customer
     *
     * @param accountList the list of customers in the bank
     * @param i the index of the selected customer
     * @param accountType the account to check the balance of
     */
    void printBalance(ArrayList<Customer> accountList, int i, String accountType);

    /**
     * template to print a welcome message
     *
     */
    void printWelcomeMessage();

}
