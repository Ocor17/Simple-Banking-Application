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

    void printAllFields(Customer acc);
    void printBalance(ArrayList<Customer> accountList, int i, String accountType);
    void printWelcomeMessage();

}
