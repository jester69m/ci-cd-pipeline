package com.pashchuk;

import com.pashchuk.entity.Employee;
import com.pashchuk.repository.EmployeeRepository;
import com.pashchuk.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    private List<Employee> employees;
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;


    @BeforeEach
    public void init() {

        Employee employee1 = new Employee("John0", "Smith0", "Developer", 1000);
        Employee employee2 = new Employee("John1", "Smith1", "Developer", 1000);
        Employee employee3 = new Employee("John2", "Smith2", "Developer", 1000);
        Employee employee4 = new Employee("John3", "Smith3", "Developer", 1000);
        Employee employee5 = new Employee("John4", "Smith4", "Developer", 1000);
        Employee employee6 = new Employee("John5", "Smith5", "Developer", 1000);
        Employee employee7 = new Employee("John6", "Smith6", "Developer", 1000);
        Employee employee8 = new Employee("John7", "Smith7", "Developer", 1000);
        employees = new ArrayList<>(List.of(
            employee1,  employee2,  employee3,  employee4, employee5,  employee6,  employee7,  employee8
        ));
        employeeRepository = new EmployeeRepository(employees);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void getByNameFromRepository() {
        Employee employee = new Employee("John", "Smith", "Developer", 1000);
        employeeRepository.addEmployee(employee);
        Employee found = employeeRepository.getEmployeeByName("John");
        Assertions.assertEquals(employee, found);
    }

    @Test
    public void getByNameFromService() {
        Employee employee = new Employee("John", "Smith", "Developer", 1000);
        employeeRepository.addEmployee(employee);
        Employee found = employeeService.getEmployeeByName("John");
        Assertions.assertEquals(employee, found);
    }

    @Test
    public void removeEmployeeFromRepository() {
        Employee employee = new Employee("John", "Smith", "Developer", 1000);
        employeeRepository.addEmployee(employee);
        Assertions.assertTrue(employeeRepository.removeEmployee(employee));
        Assertions.assertNull(employeeRepository.getEmployeeByName("John"));
    }

    @Test
    public void removeEmployeeFromService() {
        Employee employee = new Employee("John", "Smith", "Developer", 1000);
        employeeRepository.addEmployee(employee);
        Assertions.assertTrue(employeeService.removeEmployee(employee));
        Assertions.assertNull(employeeService.getEmployeeByName("John"));
    }

    @Test
    public void updateEmployeeFromRepository() {
        Employee employee = new Employee("John", "Smith", "Developer", 1000);
        employeeRepository.addEmployee(employee);
        Employee employee1 = new Employee("John", "Smith", "Developer", 2000);
        Assertions.assertTrue(employeeRepository.updateEmployee(employee1));
        Assertions.assertEquals(employee1, employeeRepository.getEmployeeByName("John"));
    }

    @Test
    public void updateEmployeeFromService() {
        Employee employee = new Employee("John", "Smith", "Developer", 1000);
        employeeRepository.addEmployee(employee);
        Employee employee1 = new Employee("John", "Smith", "Developer", 2000);
        Assertions.assertTrue(employeeService.updateEmployee(employee1));
        Assertions.assertEquals(employee1, employeeService.getEmployeeByName("John"));
    }


}
