package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findAllByName(String name);
	
}
