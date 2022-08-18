package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.constants.GlobalConstants;
import com.test.entity.Student;
import com.test.model.StudentModel;
import com.test.repository.StudentRepository;
import com.test.response.ApiResponse;
import com.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ApiResponse insertStudent(StudentModel studentModel) {

		ApiResponse response = new ApiResponse();
		try {
			Student student = new Student();
			student.setAge(studentModel.getAge());
			student.setName(studentModel.getName());
			student.setDesignation(studentModel.getDesignation());
			student.setSalary(studentModel.getSalary());

			// student = StringUtils.copyProperties(source,student)

			studentRepository.save(student);// insert int into db
			response.setMssg(GlobalConstants.insertSuccessMssg);
		} catch (Exception e) {
			response.setMssg(GlobalConstants.insertFailMssg);
		}
		return response;
	}

	@Override
	public ApiResponse getAllStudent() {

		ApiResponse response = new ApiResponse();

		List<Student> studentList = new ArrayList<Student>();

		try {
			studentList = studentRepository.findAll();
			response.setStudentList(studentList);

			response.setMssg("success");
		} catch (Exception e) {
			response.setMssg("something worng happend");
		}

		return response;

		// studentRepository.findAll();
	}

	@Override
	public ApiResponse getStudentById(Integer id) {

		ApiResponse response = new ApiResponse();

		Optional<Student> dbData = studentRepository.findById(id);
		if (dbData.isEmpty()) {
			response.setMssg("Data not found for id : " + id);
		} else {
			Student data = dbData.get();
			response.setStudent(data);
			response.setMssg("success");
		}
		return response;
	}

	@Override
	public boolean updateStudent(Integer id, Student student) {
		boolean status = false;
		Optional<Student> dbData = studentRepository.findById(id);
		if (dbData.isEmpty()) {
			status = false;
		} else {
			Student studentDbData = dbData.get();

			studentDbData.setName(student.getName());
			studentDbData.setDesignation(student.getDesignation());
			studentDbData.setAge(student.getAge());
			studentDbData.setSalary(student.getSalary());

			studentRepository.save(studentDbData);// updating
			status = true;
		}
		return status;

	}

	@Override
	public boolean deleteStudent(Integer id) {

		boolean status = false;
		Optional<Student> dbData = studentRepository.findById(id);
		if (dbData.isEmpty()) {
			status = false;
		} else {
			studentRepository.deleteById(id);
			status = true;
		}
		return status;

	}

	@Override
	public ApiResponse getStudentByName(String name) {
		ApiResponse response = new ApiResponse();

		List<Student> dbData = studentRepository.findAllByName(name);
		if (dbData.isEmpty()) {
			response.setMssg("Data not found for name : " + name);
		} else {
			response.setStudentList(dbData);
			response.setMssg("success");
		}
		return response;
	}
}
