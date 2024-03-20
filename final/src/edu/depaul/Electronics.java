package edu.depaul;

import java.util.Objects;

public class Electronics implements Product {
    private String name;
    private double price;
    private int id;
    private String type;

    public Electronics(int id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Product product = (Product) obj;
    return id == product.getID();
    }

    @Override
    public int hashCode() {
    return Objects.hash(id);
    }   

    @Override
    public String getType() {
        return "Electronics";
    }

    @Override
    public void display() {
        System.out.println("ID: " + id + ", Type: " + type + ", Name: " + name + ", Price: " + price);
    }
}