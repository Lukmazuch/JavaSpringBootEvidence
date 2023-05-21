package org.example.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    private ArrayList<Employee> employeeList;

    public EmployeeService(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public ArrayList<Employee> getAllEmployees(){
        return employeeList;
    }

    public ArrayList<Employee> searchEmployee(String firstName, String lastName){
        ArrayList<Employee> searchedEmployees = new ArrayList<>();
        for(Employee employee : employeeList) {
            if ((employee.getFirstName().toLowerCase().trim().equals(firstName.toLowerCase().trim()))&&
                    (employee.getLastName().toLowerCase().trim().equals(lastName.toLowerCase().trim()))){
                searchedEmployees.add(employee);
            }
        }
        return searchedEmployees;
    }

}
