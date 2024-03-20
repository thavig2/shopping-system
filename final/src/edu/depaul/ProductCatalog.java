package edu.depaul;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProductCatalog {

    private static final String FILE_NAME = "C:/Users/thanu/Downloads/finalproject/final/src/edu/depaul/shopping.csv";
    static Map<String, Product> productMap = new LinkedHashMap<>();

    public static void readProductFile() {
        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);
            // Skip the header row
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.err.println("Invalid line: " + line);
                    continue; // Skip processing this line
                }
                int id = Integer.parseInt(parts[0].trim());
                String type = parts[1].trim();
                String name = parts[2].trim();
                double price = Double.parseDouble(parts[3].trim());
                Product product = ProductFactory.createProduct(id, type, name, price);
                productMap.put(name, product);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + FILE_NAME);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readProductFile();
        for (Product product : productMap.values()) {
            product.display();}
        }

        //display the product catalog
        public static void displayProductCatalog() {
            for (Product product : productMap.values()) {
                product.display();
            }
        }
    }