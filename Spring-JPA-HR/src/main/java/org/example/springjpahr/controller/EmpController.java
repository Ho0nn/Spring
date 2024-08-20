package org.example.springjpahr.controller;

import org.example.springjpahr.entity.Employee;
import org.example.springjpahr.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return empService.findById(id);
    }
}
