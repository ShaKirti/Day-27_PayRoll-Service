package com.day27assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shashank
 */

/**
 * enum class to declare constants
 */
public class EmpPayRollImp {
    public enum IOService {
        FILE_IO, CONSOLE_IO, DB_IO, REST_IO
    }
    private List<EmpPayRollData> empPayRollDataList = new ArrayList<>();
    public EmpPayRollImp() {
        empPayRollDataList = new ArrayList<>();
    }

    public static void main(String[] args) {
        EmpPayRollImp empPayRollService = new EmpPayRollImp();
        Scanner consoleInputReader = new Scanner(System.in);
        empPayRollService.readEmployeePayrollData(consoleInputReader);
        empPayRollService.writeEmployeePayrollData();

    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        empPayRollDataList.add(new EmpPayRollData(id, name, salary));
    }

    private void writeEmployeePayrollData() {
        System.out.println("\nWriting Employee Payroll to console\n" + empPayRollDataList);
    }
}
