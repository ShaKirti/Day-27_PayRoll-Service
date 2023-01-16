package com.day27assignment;

/**
 * @author Shashank
 */
public class EmpPayRollData {
    /*
    1) declaring variables
     */
    private int empID;
    private String empName;
    private double empSalary;
    /**
     * Parameterized constructor
     * @param empID - takes the employee ID as int type
     * @param empName - takes the employee name as string type
     * @param empSalary - takes the employee salary as double type
     */
    public EmpPayRollData(int empID, String empName, double empSalary) {
        this.empID = empID;
        this.empName = empName;
        this.empSalary = empSalary;
    }
    /**
     * This is used to write the data
     * @return - details of the employee
     */
    @Override
    public String toString() {
        return "EmpPayRollData {" +
                "empID = " + empID +
                ", empName = '" + empName + '\'' +
                ", empSalary = " + empSalary +
                '}';
    }
}
