import java.util.ArrayList;

public interface Printable {

    void printAllFields(Customer acc);
    void printBalance(ArrayList<Customer> accountList, int i, String accountType);
    void printWelcomeMessage();

}
