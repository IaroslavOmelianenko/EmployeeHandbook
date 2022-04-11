package com.omelianenko.employeehandbook.dao;


import com.omelianenko.employeehandbook.hibernate.HibernateSessionFactory;
import com.omelianenko.employeehandbook.models.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employeesList = (List<Employee>) HibernateSessionFactory.
                getSessionFactory().
                openSession().
                createQuery("from Employee").list();
        return employeesList;
    }


    @Override
    public Employee searchById(int id) {
        return HibernateSessionFactory.
                getSessionFactory().
                openSession().
                get(Employee.class, id);
    }


    @Override
    public void register(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }
}

