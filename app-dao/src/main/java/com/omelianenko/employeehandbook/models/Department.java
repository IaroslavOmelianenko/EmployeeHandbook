package com.omelianenko.employeehandbook.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentID;

    @Column
    private String departmentName;
    private String director;
    private String moderator;
    private String headDepartment;
    private String subordinateDepartment;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = false)
    private List<Employee> departmentEmployees;

    public Department() {
    }

    public Department(String departmentName, String director, String moderator, String headDepartment, String subordinateDepartment) {
        this.departmentName = departmentName;
        this.director = director;
        this.moderator = moderator;
        this.headDepartment = headDepartment;
        this.subordinateDepartment = subordinateDepartment;
        departmentEmployees = new ArrayList<>();
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    public String getHeadDepartment() {
        return headDepartment;
    }

    public void setHeadDepartment(String headDepartment) {
        this.headDepartment = headDepartment;
    }

    public String getSubordinateDepartment() {
        return subordinateDepartment;
    }

    public void setSubordinateDepartment(String subordinateDepartment) {
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
