package edu.depaul;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestShoppingCart {
    private ShoppingCart cart;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    public void setup() {
        cart = ShoppingCart.getInstance();
        product1 = new Clothing(1, "Men's Gloves", "Clothing", 7.99);
        product2 = new Books(2, "The Great Gatsby", "Books", 10.50);
        product3 = new Electronics(3, "Phone Speaker", "Electronics", 49.99);
    }

    @Test
    public void testAddItem() {
        cart.addItem(product1);
        assertFalse(cart.isEmpty());
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(product1);
        cart.removeItem(product1);
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testGetTotalAmount() {
        cart.addItem(product1);
        cart.addItem(product2);
        cart.addItem(product3);
        assertEquals(68.48, cart.getTotalAmount());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(cart.isEmpty());
        cart.addItem(product1);
        assertFalse(cart.isEmpty());
    }
}
