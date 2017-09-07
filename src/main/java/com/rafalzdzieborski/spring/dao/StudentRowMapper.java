package com.rafalzdzieborski.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rafalzdzieborski.spring.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAddress(rs.getString("address"));
		student.setEmail(rs.getString("email"));
		student.setTelephone(rs.getString("telephone"));
		student.setComment(rs.getString("comment"));
		return student;
	}
}