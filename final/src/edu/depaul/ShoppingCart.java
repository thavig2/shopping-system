package edu.depaul;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static ShoppingCart instance = null;
    private List<Product> cartItems;
    private UserAuthentication user;

    private ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }
    
    public void addItem(Product product) {
        cartItems.add(product);
    }

    public void removeItem(Product product) {
        cartItems.remove(product);
    }

    public void displayItems() {
        for (Product product : cartItems) {
            product.display();
        }
    }

    public void setUser(UserAuthentication user) {
        this.user = user;
    }

    public double getTotalAmount() {

        double total=0;
        for (Product product : cartItems) {
            total+=product.getPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    
}