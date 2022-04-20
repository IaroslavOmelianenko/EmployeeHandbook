package com.omelianenko.employeehandbook.dao;

import com.omelianenko.employeehandbook.models.Department;
import com.omelianenko.employeehandbook.models.Employee;

import java.util.List;


public interface DepartmentDAO {

    List<Department> findAllDepartments();

    Department searchById(int id);

    void createDepartment(Department department);

    void update(Department department);

    void delete(int id);
}
