package edu.depaul;

public interface ICartBuilder {
    ICartBuilder addItem(Product product);
    ICartBuilder removeItem(Product product);
    ICartBuilder setUser(UserAuthentication user);
    ShoppingCart build();
    
}
