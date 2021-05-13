package com.garage.upskills.employmentportfolio.controller;

import com.garage.upskills.employmentportfolio.domain.Employee;
import com.garage.upskills.employmentportfolio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getEmployeeByRole/{role}")
    public List<Employee> getEmployeeByRole(@PathVariable String role) {
        return employeeService.getEmployeeByRole(role);
    }

    @GetMapping("/getEmployeeByCity/{city}")
    public List<Employee> getEmployeeByCity(@PathVariable String city) {
        return employeeService.getEmployeeByCity(city);
    }

    @PostMapping("/addEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveEmployees(employees);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
