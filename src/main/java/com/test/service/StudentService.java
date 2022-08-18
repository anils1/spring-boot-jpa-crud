package com.test.service;

import java.util.List;

import com.test.entity.Student;
import com.test.model.StudentModel;
import com.test.response.ApiResponse;

public interface StudentService {
	public ApiResponse insertStudent(StudentModel studentModel);
	
	public ApiResponse getAllStudent();
	
	public ApiResponse getStudentById(Integer id);
	
	public boolean updateStudent(Integer id, Student student);

	public boolean deleteStudent(Integer id);

	public ApiResponse getStudentByName(String name);
}
