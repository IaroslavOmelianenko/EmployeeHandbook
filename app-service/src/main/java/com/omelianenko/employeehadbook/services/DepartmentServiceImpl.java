package com.omelianenko.employeehadbook.services;

import com.omelianenko.employeehandbook.dao.DepartmentDAO;
import com.omelianenko.employeehandbook.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public Department searchDepartment(int id){return departmentDAO.searchById(id);}
    @Override
    public void createDepartment(Department department){departmentDAO.createDepartment(department);}
    @Override
    public void updateDepartment(Department department){departmentDAO.update(department);}
    @Override
    public void deleteDepartment(int id){departmentDAO.delete(id);}
    @Override
    public List<Department> findAllDepartments(){return departmentDAO.findAllDepartments();}

}
