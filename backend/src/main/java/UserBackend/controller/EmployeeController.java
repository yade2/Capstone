package UserBackend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UserBackend.exception.ResourceNotFoundException;
import UserBackend.model.Employee;
import UserBackend.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3001")
//restful app
@RestController
@RequestMapping("/api/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	//get all employees
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found:" + id));
		return ResponseEntity.ok(employee);
	}
	
	//update employee info
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeworker){
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found:" + id));
		
		employee.setFirstName(employeeworker.getFirstName());
		employee.setLastName(employeeworker.getLastName());
		employee.setemail(employeeworker.getemail());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	//delete employee info
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id){
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found:" + id));
		employeeRepository.deleteById(id);
		return "This employee with id: "+ id + " have been removed from the database.";
	}
	
	
}