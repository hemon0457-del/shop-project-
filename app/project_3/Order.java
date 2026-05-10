// Order.java
package project_3;
public class Order {

    private final String product;
    private final double price;
    private final int quantity;

    public Order(String product, double price, int quantity) {

        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {

        return String.format(
                "%-15s $%-8.2f x %-3d = $%.2f",
                product,
                price,
                quantity,
                getTotalPrice()
        );
    }
}