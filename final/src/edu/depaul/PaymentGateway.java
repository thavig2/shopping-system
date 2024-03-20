package edu.depaul;

public class PaymentGateway implements PaymentInterface{

    private static PaymentGateway instance;

    private PaymentGateway() {}

    public static PaymentGateway getInstance() {
        if (instance == null) {
            instance = new PaymentGateway();
        }
        return instance;
    }

    public void processPayment(UserAuthentication user, double amount) {
        System.out.println("Payment processed for " + user.getUsername() + " for amount " + amount);
    }
    
}
