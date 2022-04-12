package com.omelianenko.employeehadbook.services;

import com.omelianenko.employeehandbook.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee searchEmployee(int id);

    void updateEmployee(Employee employee);

    void registerEmployee(Employee employee);

    void deleteEmployee(int id);

    List<Employee> findAllEmployees();
}
