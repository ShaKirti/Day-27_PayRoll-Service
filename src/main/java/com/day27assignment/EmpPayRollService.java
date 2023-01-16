package com.day27assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shashank
 */
public class EmpPayRollService {
    void welcomeMessage(){
        System.out.println("Welcome to Employee Pay Roll Service Program");
    }
    private List<EmpPayRollData> empPayRollDataList;
    /**
     * Non-parameterized constructor of the main class
     * 1) accessing the list of the employee
     */
    public EmpPayRollService() {
        empPayRollDataList = new ArrayList<>();
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
        Scanner consoleInputReader = new Scanner(System.in);
        empPayRollService.writeEmployeePayRollData(consoleInputReader);
        empPayRollService.readEmployeePayRollData();

    }
    /**
     * This method will take the user input
     * @param consoleInputReader
     */
    private void writeEmployeePayRollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        empPayRollDataList.add(new EmpPayRollData(id, name, salary));
    }
    /**
     * This method will read the data from the list
     */
    private void readEmployeePayRollData() {
        System.out.println("\nReading Employee Payroll to console\n" + empPayRollDataList);
    }
}
