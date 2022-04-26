package com.omelianenko.employeehandbook.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int departmentID;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "director_id")
    private int director;

    @Column(name = "moderator_id")
    private int moderator;

    @Column(name = "head_department_id")
    private int headDepartment;

    @Column(name = "subordinate_department_id")
    private int subordinateDepartment;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = false)
    private List<Employee> departmentEmployees;

    public Department() {
    }


    public void addEmployee(Employee employee){
        employee.setDepartment(this);
        departmentEmployees.add(employee);
    }
    public void removeEmployee(Employee employee){
        departmentEmployees.remove(employee);
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    public int getModerator() {
        return moderator;
    }

    public void setModerator(int moderator) {
        this.moderator = moderator;
    }

    public int getHeadDepartment() {
        return headDepartment;
    }

    public void setHeadDepartment(int headDepartment) {
        this.headDepartment = headDepartment;
    }

    public int getSubordinateDepartment() {
        return subordinateDepartment;
    }

    public void setSubordinateDepartment(int subordinateDepartment) {
        this.subordinateDepartment = subordinateDepartment;
    }

    public List<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(List<Employee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", director='" + director + '\'' +
                ", moderator='" + moderator + '\'' +
                ", headDepartment='" + headDepartment + '\'' +
                ", subordinateDepartment='" + subordinateDepartment + '\'' +
                ", departmentEmployees=" + departmentEmployees +
                '}';
    }
}
