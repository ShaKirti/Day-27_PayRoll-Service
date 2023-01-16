package com.day27assignment;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shashank
 */
public class EmpFileIO {
    public static String PAYROLL_FILE_NAME = "payroll-file.txt";
    /*
     * Create a method writeData List Of EmpPayRollData
     */

    public void writeData(List<EmpPayRollData> empPayRollDataList) {
        StringBuffer empBuffer = new StringBuffer();
        empPayRollDataList.forEach(employee -> {
            String empDataString = employee.toString().concat("\n");
            empBuffer.append(empDataString);
        });
        /*
         * try and catch block IOException
         */
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * try and catch block IOException forEach method
     */
    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * try and catch block IOException countEntries method
     */

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    /*
     * try and catch block IOException List<EmpPayRollData> readData() method
     */

    public List<EmpPayRollData> readData() {
        List<EmpPayRollData> empPayRollDataList = new ArrayList<>();
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(line -> line.trim())
                    .forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empPayRollDataList;
    }
}
