
import by.gsu.pms.Account;
import by.gsu.pms.CheckingAccount;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Account checking = new CheckingAccount("bff",100);

        System.out.println(checking);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Options\n");
            System.out.println("(1) - all account");
            System.out.println("(2) - exit");

            System.out.print("Please enter your selection:\t");
            int selection = scanner.nextInt();

            if (selection == 1) {

                System.out.println(checking);

            }
            else if (selection == 2) {
                break;
            }
        }

//        Materials COOPER = Materials.COOPER;
//        wire.setMaterials(COOPER);
//        System.out.println("The wire mass is " + wire.getMass() + " kg.");


    }

}

