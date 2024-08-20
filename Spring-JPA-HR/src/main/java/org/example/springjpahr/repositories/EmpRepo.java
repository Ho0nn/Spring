package org.example.springjpahr.repositories;

import org.example.springjpahr.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends CrudRepository<Employee,Long> {
}
