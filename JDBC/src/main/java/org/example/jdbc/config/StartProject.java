package org.example.jdbc.config;

import org.example.jdbc.entity.Employee;
import org.example.jdbc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartProject implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Qualifier("empNamedJDBCRepo")
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("drop table if exists employees");
        jdbcTemplate.execute("create table employees(emp_id int ,emp_name varchar(255),emp_sal DECIMAL)");
        if (employeeRepo.cnt() == 0) {
            employeeRepo.insert(new Employee(1, "Haneen", 500000));
            employeeRepo.insert(new Employee(2, "Mohamed", 70000));
            employeeRepo.insert(new Employee(3, "Hon", 1000));
            employeeRepo.insert(new Employee(4, "Reem", 9500.50));
        }
    }
}
