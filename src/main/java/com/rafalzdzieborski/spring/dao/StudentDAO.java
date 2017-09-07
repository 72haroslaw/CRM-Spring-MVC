package com.rafalzdzieborski.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.rafalzdzieborski.spring.model.Student;

public interface StudentDAO {
	
	public void setDataSource(DataSource ds);
	
	public boolean create(Student student);
	
	public Student getStudent(Integer id);
	
	public List<Student> getAllStudents();

	public boolean delete(Student student);
	
	public boolean update(Student student);
	
	public void cleanup();
}