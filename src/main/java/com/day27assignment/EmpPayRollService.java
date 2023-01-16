package com.day27assignment;

/**
 * @author Shashank
 */
public class EmpPayRollService {
    void welcomeMessage(){
        System.out.println("Welcome to Employee Pay Roll Service Program");
    }

    /**
     * 1) creating object of main class to use methods of this class
     * 2) using object reference calling welcomeMessage() method inside the main method
     * @param args
     */
    public static void main(String[] args) {
        /*
        1) creating object of main class to use methods of this class
         */
        EmpPayRollService empPayRollService = new EmpPayRollService();
        /*
        2) using object reference calling welcomeMessage() method inside the main method
         */
        empPayRollService.welcomeMessage();
    }
}
