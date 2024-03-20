package edu.depaul;

public class ProductFactory {
    public static Product createProduct(int id, String type, String name, double price) {
        switch (type) {
            case "Clothing":
                return new Clothing(id, name,type, price);
            case "Books":
                return new Books(id, name, type, price);
            case "Electronics":
                return new Electronics(id, name, type, price);
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}





