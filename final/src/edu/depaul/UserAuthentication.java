package edu.depaul;


public class UserAuthentication {
    private String username;
    private String password;
    private ShoppingCart cart;
    private boolean isAdmin;

    public UserAuthentication(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.cart = ShoppingCart.getInstance();
        this.isAdmin = isAdmin;

       
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public boolean isAdmin() {
        return isAdmin;
    }



    
}


