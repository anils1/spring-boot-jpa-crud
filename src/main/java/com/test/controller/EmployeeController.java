package com.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.model.StudentModel;
import com.test.response.ApiResponse;
import com.test.service.StudentService;

@RestController
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> saveData(@RequestBody StudentModel studentModel) {
		return new ResponseEntity<ApiResponse>(studentService.insertStudent(studentModel), HttpStatus.OK);
	}

	@GetMapping("/get-all-student")
	public ResponseEntity<ApiResponse> getAllStudent() {
		return new ResponseEntity<ApiResponse>(studentService.getAllStudent(), HttpStatus.OK);
	}

	@GetMapping("/get-student-by-id/{id}")
	public ResponseEntity<ApiResponse> getStudentById(@PathVariable("id") Integer id) {
		logger.info("student is calling with id : " + id);
		return new ResponseEntity<ApiResponse>(studentService.getStudentById(id), HttpStatus.OK);
	}

	@PutMapping("/update-student/{id}")
	public String updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
		boolean status = studentService.updateStudent(id, student);
		if (status) {
			return "data updated successfully";
		} else {
			return "data not found with id : " + id;
		}
	}

	@DeleteMapping("/delete-student-by-id/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		boolean status = studentService.deleteStudent(id);
		if (status) {
			return "data deleted successfully";
		} else {
			return "data not found with id : " + id + " for deletion";
		}
	}
	
	@GetMapping("/get-all-student-by-name/{name}")
	public ResponseEntity<ApiResponse> getAllStudentByName(@PathVariable("name")String name) {
		logger.info("student is calling with id : " + name);
		return new ResponseEntity<ApiResponse>(studentService.getStudentByName(name), HttpStatus.OK);
	}
}
