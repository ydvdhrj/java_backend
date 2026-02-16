package manyToOne_bidirection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	private int id;
	private String name;
	private String branch;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private College college;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	
}
