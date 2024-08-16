package org.example.jdbc.repository;

import org.example.jdbc.entity.Employee;
import org.example.jdbc.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("empJDBCRepo")
public class EmpJDBCRepo implements EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int cnt() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM employees", Integer.class);
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees where emp_id=?",new Object[]{id},
               new EmpMapper());
    }
    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees ",
                new EmpMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, double salary) {
        return List.of();
    }

    @Override
    public int insert(Employee emp) {
        return jdbcTemplate.update("insert into employees (emp_id ,emp_name , emp_sal )values(?,?,?) ",new Object[]{
                emp.getId(),emp.getName(),emp.getSalary()});
    }

    @Override
    public int update(Employee emp) {
        return jdbcTemplate.update("update employees set  ,emp_name=? , emp_sal=?  ",new Object[]{
                emp.getId(),emp.getName(),emp.getSalary()});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from employees where emp_id=?",new Object[]{id});
    }
}
