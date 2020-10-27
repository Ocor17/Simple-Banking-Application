import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the RunBank method where the main class it at.
 *
 * Class taken from both Alfredo and Juan
 *
 * @author Alfredo Rodriguez, Juan Gutierrez
 * @version 1.0 10/27/2020
 * @since October 27, 2020
 */
public class RunBank {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        String firstSelection = "";
        Customer managerCustomerObject = new Customer();
        Customer user = new Customer();
        ArrayList<Customer> accounts = managerCustomerObject.csvToArray();

        while (true) {
            System.out.println("What would you like to do\n" +
                    "1. create account\n" +
                    "2. continue\n" +
                    "3. exit");
            firstSelection = input.next();

            switch (firstSelection){
                case "1":
                    user.createAccount(accounts);
                    break;

                case "2":
//                    try {
//                        mainMenu(accounts);
//                        updatedLog(accounts);
//                    }
//                    catch (IOException e) {
//                        System.out.println("File missing");
//                    }
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }
}
