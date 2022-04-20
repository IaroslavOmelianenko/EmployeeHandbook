package com.omelianenko.employeehandbook.dao;

import com.omelianenko.employeehandbook.hibernate.HibernateSessionFactory;
import com.omelianenko.employeehandbook.models.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public List<Department> findAllDepartments() {
        List<Department> departmentsList = (List<Department>) HibernateSessionFactory.
                getSessionFactory().
                openSession().
                createQuery("From Department").list();
        return departmentsList;
    }

    @Override
    public Department searchById(int id) {
        return HibernateSessionFactory.
                getSessionFactory().
                openSession().
                get(Department.class, id);
    }

    @Override
    public void createDepartment(Department department){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(department);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Department department){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(department);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Department department = session.load(Department.class, id);
        if(department!=null) {
            session.delete(department);
        }
        transaction.commit();
        session.close();
    }
}

