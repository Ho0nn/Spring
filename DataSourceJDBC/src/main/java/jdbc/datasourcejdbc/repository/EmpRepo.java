package jdbc.datasourcejdbc.repository;

import jdbc.datasourcejdbc.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends CrudRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByNameStartingWithAndSalary(String name, Double salary);
}
