package com.springbootcrud.example.service;

import java.util.List;

import com.springbootcrud.example.entity.StudentEntity;


public interface Studentservice {
		public void upsertStudent(StudentEntity Student);

		public StudentEntity getStudent(Integer StudentId);

		public List<StudentEntity> getAllStudents();

		public void deleteStudent(Integer StudentId);
	}


