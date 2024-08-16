package jdbc.datasourcejdbc.controller;

import jdbc.datasourcejdbc.entity.Employee;
import jdbc.datasourcejdbc.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpController {
    private final EmpRepo empRepo;

    @Autowired
    public EmpController(EmpRepo empRepo) {
        this.empRepo = empRepo;
    }

    @GetMapping("/count")
    public Long cntEmp() {
        return empRepo.count();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Integer id) {
        return empRepo.findById(id).get();
    }
    @GetMapping("/filter/{name}/{salary}")
    public List<Employee> filter (@PathVariable String name,@PathVariable Double salary){
        return empRepo.findByNameStartingWithAndSalary(name, salary);
    }

    @GetMapping("/add")
    public Employee addEmp() {
        return empRepo.save(new Employee(4,"honn",44444));
    }
    @GetMapping("/update")
    public Employee updateEmp() {
        return empRepo.save(new Employee(4,"heena",6666));
    }
}
