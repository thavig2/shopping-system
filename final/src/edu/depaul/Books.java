package edu.depaul;

import java.util.Objects;

public class Books implements Product {
    
    private int id;
    private String name;
    private double price;
    private String type;
    
    public Books(int id, String name, String type, double price){
        this.name = name;
        this.price = price;
        this.id = id;
        this.type = type;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public int getID(){
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
    public String getType(){
        return "Books";
    }

    @Override
    public void display() {
        System.out.println("ID: " + id + ", Type: " + type + ", Name: " + name + ", Price: " + price);
    }
}