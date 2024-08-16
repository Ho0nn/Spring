package org.example.jdbc.controller;

import org.example.jdbc.entity.Employee;
import org.example.jdbc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpController {

    @Autowired
    @Qualifier("empNamedJDBCRepo")
    private EmployeeRepo employeeRepo;

    @GetMapping("/count")
    public int countEmployees() {
        return employeeRepo.cnt();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeRepo.findById(id);
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }
}
