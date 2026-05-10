// OrderManager.java

package project_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {

    private static final double PREMIUM_DISCOUNT_LIMIT = 100;
    private static final double NORMAL_DISCOUNT_LIMIT = 50;

    private static final double PREMIUM_DISCOUNT = 0.20;
    private static final double NORMAL_DISCOUNT = 0.10;
    private static final double BASIC_DISCOUNT = 0.05;

    private static final int DELIVERY_FEE = 5;

    private final List<Order> orders;
    private final Scanner input;

    private double subtotal;

    public OrderManager(Scanner input) {

        this.input = input;
        this.orders = new ArrayList<>();
    }

    public void addOrder() {

        String product;
        double price;
        int quantity;

        System.out.print("Enter product name: ");
        product = input.nextLine();

        while (true) {

            System.out.print("Enter unit price: $");

            if (input.hasNextDouble()) {

                price = input.nextDouble();
                input.nextLine();

                if (price > 0) {
                    break;
                }

                System.out.println("Price must be greater than 0.");
            }

            else {

                System.out.println("Invalid price input.");
                input.nextLine();
            }
        }

        while (true) {

            System.out.print("Enter quantity: ");

            if (input.hasNextInt()) {

                quantity = input.nextInt();
                input.nextLine();

                if (quantity > 0) {
                    break;
                }

                System.out.println("Quantity must be greater than 0.");
            }

            else {

                System.out.println("Invalid quantity input.");
                input.nextLine();
            }
        }

        Order order = new Order(product, price, quantity);

        orders.add(order);

        subtotal += order.getTotalPrice();
    }

    public double calculateDiscount() {

        if (subtotal > PREMIUM_DISCOUNT_LIMIT) {
            return subtotal * PREMIUM_DISCOUNT;
        }

        else if (subtotal > NORMAL_DISCOUNT_LIMIT) {
            return subtotal * NORMAL_DISCOUNT;
        }

        return subtotal * BASIC_DISCOUNT;
    }

    public int calculateDeliveryFee() {

        return subtotal > PREMIUM_DISCOUNT_LIMIT ? 0 : DELIVERY_FEE;
    }

    public void printReceipt() {

        System.out.println("\n========== FINAL RECEIPT ==========\n");

        int count = 1;

        for (Order order : orders) {

            System.out.println(count + ". " + order);
            count++;
        }

        double discount = calculateDiscount();
        int deliveryFee = calculateDeliveryFee();

        double finalPrice = subtotal - discount + deliveryFee;

        System.out.println("\n-----------------------------------");

        System.out.printf("Subtotal      : $%.2f\n", subtotal);
        System.out.printf("Discount      : $%.2f\n", discount);
        System.out.printf("Delivery Fee  : $%d\n", deliveryFee);

        System.out.println("-----------------------------------");

        System.out.printf("Final Price   : $%.2f\n", finalPrice);

        System.out.println("\nThank you for shopping with us!");
    }
}