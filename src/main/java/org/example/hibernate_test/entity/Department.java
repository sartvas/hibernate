package org.example.hibernate_test.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public void addEmployeestoDepartmen(Employee employee){
        if(emps == null){
            emps = new ArrayList<>();
        }
        emps.add(employee);
        employee.setDepartment(this);
    }

    public Department() {
    }

    public Department(String name, int minSalary, int maxSalary) {
        this.departmentName = name;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public String getName() {
        return departmentName;
    }

    public void setName(String name) {
        this.departmentName = name;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name='" + departmentName + '\'' + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + '}';
    }
}
