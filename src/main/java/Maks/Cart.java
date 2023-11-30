package Maks;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> listOfProducts = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) {
            listOfProducts.add(product);
            System.out.println(product.getName() + " has been added to the cart");
        } else {
            System.out.println("Cannot add null product to the cart");
        }
    }

    public void removeFromCart(Product product) {
        if (listOfProducts.remove(product)) {
            System.out.println(product.getName() + " has been removed from the cart");
        } else {
            System.out.println(product.getName() + " is not in the cart");
        }
    }

    public List<Product> getProducts() {
        return new ArrayList<>(listOfProducts);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : listOfProducts) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}

