package com.omelianenko.employeehandbook.dao;

import com.omelianenko.employeehandbook.models.Employee;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> findAllEmployees();

    Employee searchById(int id);

    void register(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);
}
