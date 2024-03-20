package edu.depaul;

public class CartBuilder implements ICartBuilder {
    private ShoppingCart cart;

    public CartBuilder() {
        this.cart = ShoppingCart.getInstance();
    }

    @Override
    public ICartBuilder addItem(Product product) {
        cart.addItem(product);
        return this;
    }

    @Override
    public ICartBuilder removeItem(Product product) {
        cart.removeItem(product);
        return this;
    }

    public ICartBuilder setUser(UserAuthentication user) {
        cart.setUser(user);
        return this;
    }

    @Override
    public ShoppingCart build() {
        return cart;
    }

}
