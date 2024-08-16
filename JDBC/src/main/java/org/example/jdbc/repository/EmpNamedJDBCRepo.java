package org.example.jdbc.repository;
import org.example.jdbc.entity.Employee;
import org.example.jdbc.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("empNamedJDBCRepo")
public class EmpNamedJDBCRepo implements EmployeeRepo {
    String sql;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int cnt() {
        return namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM employees", new MapSqlParameterSource(), Integer.class);
    }

    @Override
    public Employee findById(int id) {
         sql = "SELECT emp_id, emp_name, emp_sal FROM employees WHERE emp_id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, new EmpMapper());
    }

    @Override
    public List<Employee> findAll() {
         sql = "SELECT emp_id, emp_name, emp_sal FROM employees";
        return namedParameterJdbcTemplate.query(sql, new EmpMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, double salary) {
         sql = "SELECT emp_id, emp_name, emp_sal FROM employees WHERE emp_name = :name AND emp_sal = :salary";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("salary", salary);
        return namedParameterJdbcTemplate.query(sql, params, new EmpMapper());
    }

    @Override
    public int insert(Employee emp) {
         sql = "INSERT INTO employees (emp_id, emp_name, emp_sal) VALUES (:id, :name, :salary)";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(emp));
    }

    @Override
    public int update(Employee emp) {
         sql = "UPDATE employees SET emp_name = :name, emp_sal = :salary WHERE emp_id = :id";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(emp));
    }

    @Override
    public int delete(int id) {
         sql = "DELETE FROM employees WHERE emp_id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return namedParameterJdbcTemplate.update(sql, params);
    }
}
