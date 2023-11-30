package Maks;

import java.util.Collections;
import java.util.List;

public class Order {
    private static int orderCounter = 1;
    private int orderId;
    private List<Product> products;
    private Status status;

    public Order(List<Product> products) {
        this.orderId = orderCounter++;
        this.products = Collections.unmodifiableList(products);
        this.status = Status.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order ID: ").append(orderId).append("\n");
        stringBuilder.append("Products:\n");
        for (Product product : products) {
            stringBuilder.append("- ").append(product.getName()).append(" - $").append(product.getPrice()).append("\n");
        }
        stringBuilder.append("Total Price: $").append(calculateTotalPrice()).append("\n");
        stringBuilder.append("Status: ").append(status).append("\n");
        return stringBuilder.toString();
    }
}
