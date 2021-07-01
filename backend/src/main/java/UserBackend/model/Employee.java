package UserBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//what gets mapped
//creates employee table
@Entity 
//specify table name so that it doesn't create a table based on the class 
@Table(name = "employees")
public class Employee {
	
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	//getters & setters
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
}	