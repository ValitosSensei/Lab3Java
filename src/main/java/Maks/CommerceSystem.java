package Maks;

public class CommerceSystem {
    public static void main(String[] args) {
        // Creating products
        Product laptop = new Product(1, "Laptop", 999.99F);
        Product smartphone = new Product(2, "Smartphone", 499.99F);

        // Creating a cart and adding products
        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(smartphone);

        // Displaying cart contents
        System.out.println("Cart Contents:");
        for (Product product : cart.getProducts()) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }

        // Placing an order
        Order order = new Order(cart.getProducts());
        System.out.println("\nOrder placed. Order ID: " + order.getOrderId());

        // Setting order status
        order.setStatus(Status.PROCESSING);
        System.out.println("Order Status: " + order.getStatus());
    }
}

