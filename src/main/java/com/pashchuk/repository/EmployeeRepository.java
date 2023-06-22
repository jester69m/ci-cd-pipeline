package com.pashchuk.repository;

import com.pashchuk.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        return employees.remove(employee);
    }

    public boolean updateEmployee(Employee employee) {
        for (Employee employee1 : employees) {
            if (employee1.getName().equals(employee.getName())) {
                employee1.setSurname(employee.getSurname());
                employee1.setPosition(employee.getPosition());
                employee1.setSalary(employee.getSalary());
                return true;
            }
        }
        return false;
    }
}
