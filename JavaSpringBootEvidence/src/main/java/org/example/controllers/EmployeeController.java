package org.example.controllers;

import org.example.models.Employee;
import org.example.models.EmployeeService;
import org.example.models.SearchedEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String renderIndex(){
        return "index";
    }

    @GetMapping("/form")
    public String index(Model model){
        model.addAttribute("userForm", new Employee());
        return "form";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee employee, Model model){
        System.out.println(employee.toString());
        employeeService.addEmployee(employee);
        model.addAttribute("userForm", new Employee());
        return "index";
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("searchForm", new SearchedEmployee());
        return "search";
    }

    @PostMapping("/searchedEmployees")
    public String searchEmployee(@ModelAttribute SearchedEmployee searchedEmployee, Model model){
        model.addAttribute("searchForm", new SearchedEmployee());
        model.addAttribute("searchedEmployees", employeeService.searchEmployee(searchedEmployee.getFirstName(), searchedEmployee.getLastName()));
        return "searchedEmployees";
    }

}
