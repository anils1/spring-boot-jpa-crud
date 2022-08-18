package com.test.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.entity.Student;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

	private String mssg;
	private Student student;
	
	private List<Student> studentList;

	public String getMssg() {
		return mssg;
	}

	public void setMssg(String mssg) {
		this.mssg = mssg;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	
	
}
