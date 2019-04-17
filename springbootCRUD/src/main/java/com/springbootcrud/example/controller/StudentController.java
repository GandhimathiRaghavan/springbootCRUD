package com.springbootcrud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.example.entity.StudentEntity;
import com.springbootcrud.example.service.Studentservice;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private Studentservice studentservice;
	
	@PostMapping
	public void addstudent(@RequestBody final StudentEntity student) {
		studentservice.upsertStudent(student);
	}

	@GetMapping("/{studentId}")
	public StudentEntity getstudent(@PathVariable("studentId") final Integer studentId) {
		return studentservice.getStudent(studentId);
	}

	@GetMapping
	public List<StudentEntity> getAllstudents(ModelMap map) {
		return studentservice.getAllStudents();
	}

	@PutMapping("/{studentId}")
	public void updatestudent(@RequestBody final StudentEntity student) {
		studentservice.upsertStudent(student);
	}

	@DeleteMapping("/{studentId}")
	public void deleteEmplyee(@PathVariable("studentId") final Integer studentId) {
		studentservice.deleteStudent(studentId);
	}

}
