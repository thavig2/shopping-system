package edu.depaul;

import java.util.ArrayList;
import java.util.List;

public class Logging implements LoggingInterface{
    private List<String> logs = new ArrayList<>();

    public void logEvent(UserAuthentication user, String event) {
        if (user.isAdmin()){
            logs.add("Event: " + event);
        }
    }

    public void logTransaction(UserAuthentication user, String transaction) {
        if (user.isAdmin()) {
            logs.add("Transaction: " + transaction);
        }
    }

    public void viewLogs(UserAuthentication user) {
        if (user.isAdmin()) {
            if (logs.isEmpty()) {
                System.out.println("No logs to display");
            }
            else{ 
                for (String log : logs) {
                    System.out.println(log);
                }
            }
        }
    }
}