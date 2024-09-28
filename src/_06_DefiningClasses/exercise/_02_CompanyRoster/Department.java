package _06_DefiningClasses.exercise._02_CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Department {
    int n;
    List<Employee> employeeList;

    public Department(int n ){
        this.n = n;
        this.employeeList = new ArrayList<>();
    }

    public void add(Employee employee){
        if (employeeList.size() <= n){
            employeeList.add(employee);
        }
    }

    private String getHighestAverageSalaryDepartment(){
        String highestDepartment = "";
        double highestAverageSalary = 0.0;

        for (Employee employee : this.employeeList){
            String departmentName = employee.getDepartment();
            double totalSalary = 0.0;
            int numberOfEmployers = 0;
            for (Employee employer : this.employeeList){
                if (departmentName.equals(employer.getDepartment())){
                    totalSalary += employer.getSalary();
                    numberOfEmployers++;
                }
            }
            double averageSalary = totalSalary / numberOfEmployers;
            if (averageSalary > highestAverageSalary){
                highestDepartment = departmentName;
                highestAverageSalary = averageSalary;
            }
        }
        return highestDepartment;
    }

    private double getHighestAverageSalary () {
        String highestDepartment = "";
        double highestAverageSalary = 0.0;

        for (Employee employee : this.employeeList) {
            String departmentName = employee.getDepartment();
            double totalSalary = 0.0;
            int numberOfEmployers = 0;
            for (Employee employer : this.employeeList) {
                if (departmentName.equals(employer.getDepartment())) {
                    totalSalary += employer.getSalary();
                    numberOfEmployers++;
                }
            }
            double averageSalary = totalSalary / numberOfEmployers;
            if (averageSalary > highestAverageSalary) {
                highestDepartment = departmentName;
                highestAverageSalary = averageSalary;
            }
        }
        return highestAverageSalary;
    }

    public String getInfo () {
        String name = getHighestAverageSalaryDepartment();
        double averageSalary = getHighestAverageSalary();
        String output = "";
        output += String.format("Highest Average Salary: %s%n", name);
        Collections.sort(employeeList, Comparator.comparingDouble(Employee::getSalary).reversed());
        for (Employee employee : this.employeeList) {
            if (employee.getDepartment().equals(name)) {
                output += String.format("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
            }
        }
        return output;
    }
}
