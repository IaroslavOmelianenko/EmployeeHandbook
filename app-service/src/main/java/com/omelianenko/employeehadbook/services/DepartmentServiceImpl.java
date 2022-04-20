package com.omelianenko.employeehadbook.services;

import com.omelianenko.employeehandbook.dao.DepartmentDAOImpl;
import com.omelianenko.employeehandbook.models.Department;
import com.omelianenko.employeehandbook.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();

    public void setDepartmentDAO(DepartmentDAOImpl departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public DepartmentServiceImpl(){}

    @Override
    @Transactional
    public Department searchDepartment(int id){return departmentDAO.searchById(id);}

    @Override
    @Transactional
    public void createDepartment(Department department){departmentDAO.createDepartment(department);}

    @Override
    @Transactional
    public void updateDepartment(Department department){departmentDAO.update(department);}

    @Override
    @Transactional
    public void deleteDepartment(int id){departmentDAO.delete(id);}

    @Override
    @Transactional
    public List<Department> findAllDepartments(){return departmentDAO.findAllDepartments();}

}
