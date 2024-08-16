package org.example.jdbc.mapper;

import org.example.jdbc.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs , int rowNum)throws SQLException {
        return new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getDouble("emp_sal"));

    }
}
