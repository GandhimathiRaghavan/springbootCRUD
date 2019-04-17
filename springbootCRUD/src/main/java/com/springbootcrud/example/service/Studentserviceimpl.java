package com.springbootcrud.example.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootcrud.example.entity.StudentEntity;
import com.springbootcrud.example.repository.Studentrepository;





@Service
public class Studentserviceimpl implements Studentservice {

	@Autowired
	private Studentrepository Repo;


	@Override
	@Transactional
	public void upsertStudent(StudentEntity Student) {
		Repo.save(Student);		
	}

	@Override
	@Transactional
	public StudentEntity getStudent(Integer StudentId) {
		final Optional<StudentEntity> emplyee = Repo.findById(StudentId);
		return emplyee.isPresent() ? emplyee.get() : null;
	}
	@Override
	@Transactional
	public List<StudentEntity> getAllStudents() {
		return Repo.findAll();
	}

	@Override
	@Transactional
	public void deleteStudent(Integer StudentId) {
		Repo.deleteById(StudentId);

		
	}
}
