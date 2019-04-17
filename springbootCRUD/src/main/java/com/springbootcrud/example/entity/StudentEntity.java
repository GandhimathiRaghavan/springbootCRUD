package com.springbootcrud.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="students")
public class StudentEntity {

	
	@Id
	@Column(name = "Rollno")
	@GeneratedValue
	private Integer id;

	@Column(name = "studentname")
	private String studentname;

	@Column(name = "studentsection")
	private String studentsection;

	
	@Column(name = "fathername")
	private String fathername;

	@Column(name = "mothername")
	private String mothername;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentsection() {
		return studentsection;
	}

	public void setStudentsection(String studentsection) {
		this.studentsection = studentsection;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", studentname=" + studentname + ", studentsection=" + studentsection
				+ ", fathername=" + fathername + ", mothername=" + mothername + "]";
	}
	
}
