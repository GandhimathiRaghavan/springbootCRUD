package com.springbootcrud.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springbootcrud.example.entity.StudentEntity;

public interface Studentrepository extends CrudRepository<StudentEntity, Integer> {
	@Override
	List<StudentEntity> findAll();

}
