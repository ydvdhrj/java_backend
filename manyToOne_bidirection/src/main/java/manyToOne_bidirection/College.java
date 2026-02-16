package manyToOne_bidirection;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "college")
	private List<Student> student;
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
