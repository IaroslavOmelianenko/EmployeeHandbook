package com.omelianenko.employeehadbook.services;

import com.omelianenko.employeehandbook.models.Department;
import com.omelianenko.employeehandbook.models.Employee;

import java.util.List;

public interface DepartmentService {
    Department searchDepartment(int id);
    void createDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int id);
    List<Department> findAllDepartments();

}
