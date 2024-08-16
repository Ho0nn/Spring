package org.example.jdbc.repository;

import org.example.jdbc.entity.Employee;

import java.util.List;

public interface EmployeeRepo {

    int cnt();

    Employee findById(int Id);
    List<Employee> findAll();
    List<Employee> findByNameAndSalary(String name , double salary);
    int insert(Employee emp);
    int update(Employee emp);
    int delete(int id);
}
