package edu.depaul;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        UserAuthentication currentUser = null; // User will be assigned after login or registration
        Logging logging = new Logging();

        while (true) {
            try {
                System.out.println("1. Register a new user");
                System.out.println("2. Login as the new user");
                System.out.println("3. Add items to the cart from the product catalog");
                System.out.println("4. Remove an item from the cart");
                System.out.println("5. Display items in the cart");
                System.out.println("6. Checkout");
                System.out.println("7. Logout");
                System.out.println("8. Log an event (admin only)");
                System.out.println("9. Log a transaction (admin only)");
                System.out.println("10. View logs (admin only)");
                System.out.println("11. Exit the system");
                System.out.println("Enter your choice:");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter username:");
                        String username = scanner.next();
                        System.out.println("Enter password:");
                        String password = scanner.next();
                        System.out.println("Is this an admin account? (true/false):");
                        boolean isAdmin = scanner.nextBoolean();
                        currentUser = new UserAuthentication(username, password, isAdmin);
                        System.out.println("User registered successfully.");
                        break;
                    case 2:
                        System.out.println("Enter username:");
                        username = scanner.next();
                        System.out.println("Enter password:");
                        password = scanner.next();
                        if (currentUser != null && currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
                            System.out.println("Login successful.");
                        } else {
                            System.out.println("Invalid username or password.");
                        }
                        break;
                    case 3:
                        // Read and display the product file
                        ProductCatalog.readProductFile();
                        System.out.println("Product Catalog:");
                        ProductCatalog.displayProductCatalog();
                
                        // Prompt the user to enter the name of the product to add to the cart
                        System.out.println("Enter the name of the product you want to add to the cart:");
                        scanner.nextLine(); // Consume newline character
                        String productName = scanner.nextLine();
                    
                        // Look up the product by its name
                        Product product = ProductCatalog.productMap.get(productName);
                        if (product != null) {
                            // If the product is found, add it to the cart
                            currentUser.getCart().addItem(product);
                            System.out.println("Product added to cart.");
                        } else {
                            // If the product is not found, print an error message
                            System.out.println("Invalid product name.");
                        }
                        break;
                    case 4:
                        // Read and display the product file
                        ProductCatalog.readProductFile();
                        System.out.println("Product Catalog:");
                        
                
                        // Prompt the user to enter the name of the product to remove from the cart
                        System.out.println("Enter the name of the product you want to remove from the cart:");
                        scanner.nextLine(); // Consume newline character
                        productName = scanner.nextLine();
                    
                        // Look up the product by its name
                        product = ProductCatalog.productMap.get(productName);
                        if (product != null) {
                            // If the product is found, remove it from the cart
                            currentUser.getCart().removeItem(product);
                            System.out.println("Product removed from cart.");
                        } else {
                            // If the product is not found, print an error message
                            System.out.println("Invalid product name.");
                        }
                        break;  
                    case 5:
                        //display items in user's cart
                        System.out.println("Items in the cart:");
                        if (currentUser.getCart().isEmpty()) {
                            System.out.println("The cart is empty.");
                        } else {
                            currentUser.getCart().displayItems();
                        }
                        break;
                    case 6:
                        System.out.println("Processing payment...");
                        PaymentGateway paymentGateway = PaymentGateway.getInstance();
                        double amount = currentUser.getCart().getTotalAmount(); 
                        paymentGateway.processPayment(currentUser, amount);
                        break;
                    case 7:
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    case 8:
                        if (currentUser != null && currentUser.isAdmin()) {
                            System.out.println("Enter event to log:");
                            String event = scanner.nextLine();
                            logging.logEvent(currentUser, event);
                        } else {
                            System.out.println("You must be an admin to log an event.");
                        }
                        break;
                    case 9:
                        if (currentUser != null && currentUser.isAdmin()) {
                            System.out.println("Enter transaction to log:");
                            String transaction = scanner.nextLine();
                            logging.logTransaction(currentUser, transaction);
                        } else {
                            System.out.println("You must be an admin to log a transaction.");
                        }
                        break;
                    case 10:
                        if (currentUser != null && currentUser.isAdmin()) {
                            logging.viewLogs(currentUser);
                        } else {
                            System.out.println("You must be an admin to view logs.");
                        }
                        break;
                    case 11:
                        System.out.println("Exiting the system...");
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume newline character
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}





    