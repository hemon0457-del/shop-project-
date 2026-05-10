// Main.java
package project_3;
import java.util.Scanner;

public class Main {

    public static final int MAX_ITEMS = 5;

    public static int getItemCount(Scanner input) {

        int item;

        while (true) {

            System.out.print("How many items would you like to buy? (1-5): ");

            if (input.hasNextInt()) {

                item = input.nextInt();
                input.nextLine();

                if (item > 0 && item <= MAX_ITEMS) {
                    return item;
                }

                System.out.println("Invalid! Enter between 1 to 5.");
            }

            else {
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\n*** Welcome To Lazy_$*$ Shop ***");
        System.out.println("***************************************");

        int itemCount = getItemCount(input);

        OrderManager orderManager = new OrderManager(input);

        for (int i = 0; i < itemCount; i++) {

            System.out.println("\nItem No: " + (i + 1));
            orderManager.addOrder();
        }

        orderManager.printReceipt();

        input.close();
    }
}
