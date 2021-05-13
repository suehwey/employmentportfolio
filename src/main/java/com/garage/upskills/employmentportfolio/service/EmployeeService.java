package com.garage.upskills.employmentportfolio.service;

import com.garage.upskills.employmentportfolio.domain.Employee;
import com.garage.upskills.employmentportfolio.exceptions.BadEmployeeDataException;
import com.garage.upskills.employmentportfolio.exceptions.EmployeeNotFoundException;
import com.garage.upskills.employmentportfolio.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        if (employeeList.size() == 0)
            throw new EmployeeNotFoundException("No Employee Data");

        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public List<Employee> getEmployeeByRole(String role) {
        List<Employee> employeeList = employeeRepository.findByRole(role);
        if (employeeList.size() == 0)
            throw new EmployeeNotFoundException("No Employee of role - " + role);

        return employeeList;
    }

    public List<Employee> getEmployeeByCity(String city) {
        List<Employee> employeeList = employeeRepository.findByCity(city);
        if (employeeList.size() == 0)
            throw new EmployeeNotFoundException("No Employee lives in city - " + city);

        return employeeList;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public String deleteEmployeeById(int id) {
        Employee employee = this.getEmployeeById(id);  // will throw exception if employee id doesn't exist

        employeeRepository.deleteById(id);
        return employee + " has been deleted.";
    }

    public String updateEmployee(Employee employee) throws EmployeeNotFoundException{
        int empId = employee.getEmpId();
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();

        this.getEmployeeById(empId);
        if (firstName == null || lastName == null || firstName.length() == 0 || lastName.length() == 0)
            throw new BadEmployeeDataException("Employee First Name and Last Name can't be null.\n" + employee);

        employeeRepository.save(employee);
        return "Employee ID: " + empId + " has been updated:\n" + employee;
    }
}
