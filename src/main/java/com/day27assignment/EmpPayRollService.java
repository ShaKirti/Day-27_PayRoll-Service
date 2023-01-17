package com.day27assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shashank
 */
public class EmpPayRollService {
    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }
    private static final String FILE_PATH = "C:\\Users\\shash\\Shashank.txt";
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
        for (int i = 0; i < 3; i++) {
            empPayRollService.writeEmployeePayRollData(consoleInputReader);
            empPayRollService.readEmployeePayRollData();
            empPayRollService.printData(IOService.FILE_IO);
        }
        System.out.println(empPayRollService.countEntries(IOService.CONSOLE_IO));
    }
    /**
     * method count entries
     * @param consoleIo
     * @return - number of entries
     */
    private long countEntries(IOService consoleIo) {
        long entries = 0;
        try {
            entries = Files.lines(new File(FILE_PATH).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    /**
     * method to print data
     * @param fileIo
     */
    private void printData(IOService fileIo) {
        if (fileIo.equals(IOService.FILE_IO)) {
            new EmpFileIO().printData();
        }
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
        checkFile();
        StringBuffer empBuffer = new StringBuffer();
        empPayRollDataList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(FILE_PATH), empBuffer.toString().getBytes());
        } catch (IOException e) {

            e.printStackTrace();
        }
        fileReader();
    }

    /**
     * method to create file if file doesn't exist
     */
    private void checkFile() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Created a file at " + FILE_PATH);
            }
        } catch (IOException e1) {
            System.err.println("Problem encountered while creating a file");
        }
    }

    /**
     * method to read file
     */
    public void fileReader(){
        try {
            BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\shash\\Shashank.txt"));
            String s;
            while ((s = b.readLine()) != null){
                System.out.println(s);
            }
        }
        catch (Exception e){
            return;
        }
    }
}