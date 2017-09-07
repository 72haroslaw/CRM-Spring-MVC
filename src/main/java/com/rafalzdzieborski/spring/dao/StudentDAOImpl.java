package com.rafalzdzieborski.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.rafalzdzieborski.spring.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public StudentDAOImpl(DataSource ds) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Student student) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(student);
		String sqlQuery = "INSERT INTO Students (name, address, email, telephone, comment)" 
							+ " VALUES (:name, :address, :email, :telephone, :comment)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public Student getStudent(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		String sqlQuery = "SELECT id, name, address, email, telephone, comment" 
						+ " FROM Students WHERE id = :id";
		Student student = namedParameterJdbcTemplate.queryForObject(sqlQuery, param, new StudentRowMapper());
		return student;
	}

	public List<Student> getAllStudents() {
		String sqlQuery = "SELECT * FROM Students";
		List <Student> orgList = namedParameterJdbcTemplate.query(sqlQuery, new StudentRowMapper());
		return orgList;
	}

	public boolean delete(Student student) {
		SqlParameterSource beanParam = new BeanPropertySqlParameterSource(student);
		String sqlQuery = "DELETE FROM Students WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParam) == 1;
	}

	public boolean update(Student student) {
		SqlParameterSource beanParam = new BeanPropertySqlParameterSource(student);
		String sqlQuery = "UPDATE Students SET name = :name, address = :address, email = :email, "
				+ "telephone = :telephone, comment = :comment WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParam) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE Students";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}
}