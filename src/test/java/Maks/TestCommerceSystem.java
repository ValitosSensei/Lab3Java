package Maks;

import Maks.Cart;
import Maks.Order;
import Maks.Product;
import Maks.Status;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TestCommerceSystem {

    @Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        Product laptop = new Product(1, "Laptop", 999.99F);
        cart.addProduct(laptop);
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product laptop = new Product(1, "Laptop", 999.99F);
        cart.addProduct(laptop);
        cart.removeFromCart(laptop);
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testPlaceOrder() {
        Cart cart = mock(Cart.class);
        Product laptop = new Product(1, "Laptop", 999.99F);
        when(cart.getProducts()).thenReturn(List.of(laptop));
        Order order = new Order(cart.getProducts());
        assertEquals(1, order.getProducts().size());
        assertEquals(Status.PENDING, order.getStatus());
    }

    @Test
    public void testUpdateOrderStatus() {
        Order order = new Order(List.of());
        order.setStatus(Status.PROCESSING);
        assertEquals(Status.PROCESSING, order.getStatus());
    }

    @Test
    public void testGetOrderStatus() {
        Order order = mock(Order.class);
        when(order.getStatus()).thenReturn(Status.PROCESSING);
        Status status = order.getStatus();
        assertEquals(Status.PROCESSING, status);
    }
}
