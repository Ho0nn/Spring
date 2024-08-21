package org.example.springjpahr.controller;

import org.example.springjpahr.entity.Employee;
import org.example.springjpahr.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return empService.findById(id);
    }

    @GetMapping("/filter")
    public List<Employee> findByName(@RequestParam String name) {
        return empService.filter(name);
    }

    @PostMapping()
    public Long insert(@RequestBody Employee emp) {
        Employee inserted = empService.insert(emp);
        return inserted.getId();
    }

    @PutMapping()
    public Employee update(@RequestBody Employee emp) {
        return empService.update(emp);
    }
    @GetMapping("/department/{deptId}")
    public ResponseEntity<List<Employee>> findByDepartmentId(@PathVariable Long deptId) {
        List<Employee> employees = empService.findByDepartmentId(deptId);
        return ResponseEntity.ok(employees);
    }
    @GetMapping()
    public List<Employee> findAll() {

        return empService.findAll();
    }
}
