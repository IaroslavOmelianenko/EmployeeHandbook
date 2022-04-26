package com.omelianenko.employeehadbook.services;

import com.omelianenko.employeehandbook.dao.EmployeeDAO;
import com.omelianenko.employeehandbook.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public Employee searchEmployee(int id){return employeeDAO.searchById(id);}
    @Override
    public void updateEmployee(Employee employee){employeeDAO.update(employee);}
    @Override
    public void registerEmployee(Employee employee){employeeDAO.register(employee);}
    @Override
    public void deleteEmployee(int id){employeeDAO.delete(id);}
    @Override
    public List<Employee> findAllEmployees(){return employeeDAO.findAllEmployees();}

}
