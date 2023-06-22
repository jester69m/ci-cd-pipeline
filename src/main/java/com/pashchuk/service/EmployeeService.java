package com.pashchuk.service;

import com.pashchuk.entity.Employee;
import com.pashchuk.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public boolean addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public boolean removeEmployee(Employee employee) {
        return employeeRepository.removeEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }
}
