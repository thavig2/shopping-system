package edu.depaul;

public interface LoggingInterface {
    //create a logging system that records important events and implements
    //the Logging class 

    public void logEvent(UserAuthentication user, String event);
    public void logTransaction(UserAuthentication user, String transaction);

    
    
}
