package com.rafalzdzieborski.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafalzdzieborski.spring.dao.StudentDAO;

@Service
public class StudentService {

	@Autowired
	public StudentDAO studentDAO;
	
	public List<Student> getStudentList() {
		List<Student> studentList = studentDAO.getAllStudents();
		return studentList;
	}
}