package org.example.springjpahr.service;

import org.example.springjpahr.entity.Employee;
import org.example.springjpahr.repositories.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;
    public Employee findById(Long id) {
       return empRepo.findById(id).orElseThrow();
    }
}
