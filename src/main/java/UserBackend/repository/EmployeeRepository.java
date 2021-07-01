package UserBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UserBackend.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByName(String name);

}