package com.omelianenko.employeehadbook.services;

import com.omelianenko.employeehandbook.dao.EmployeeDAOImpl;
import com.omelianenko.employeehandbook.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    public void setEmployeeDAO(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeServiceImpl(){}

    @Override
    @Transactional
    public Employee searchEmployee(int id){return employeeDAO.searchById(id);}

    @Override
    @Transactional
    public void updateEmployee(Employee employee){employeeDAO.update(employee);}

    @Override
    @Transactional
    public void registerEmployee(Employee employee){employeeDAO.register(employee);}

    @Override
    @Transactional
    public void deleteEmployee(int id){employeeDAO.delete(id);}

    @Override
    @Transactional
    public List<Employee> findAllEmployees(){return employeeDAO.findAllEmployees();}

}
