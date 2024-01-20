package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public int insert(Student student) {
		String insertQuery = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbctemplate.update(insertQuery, student.getId(), student.getName(), student.getCity());

		return r;
	}

	public int change(Student student) {
		String updateQuery = "update student set name=?,city=? where id=?";
		int r = this.jdbctemplate.update(updateQuery, student.getName(), student.getCity(), student.getId());

		return r;
	}

	public int delete(Student student) {
		String deleteQuery = "delete from student where id=?";
		int r = this.jdbctemplate.update(deleteQuery, student.getId());

		return r;
	}

	public Student getStudent(int StudentId) {
//		Select single student data
		String selectQuery = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student  = this.jdbctemplate.queryForObject(selectQuery, rowMapper,StudentId);
		return student;
	}
	public List<Student> getAllStudent(){
//		Select multiple student data
		String selectQuery = "select * from student";
		List<Student> student = this.jdbctemplate.query(selectQuery, new RowMapperImpl());
		
		return student;
	}
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

}
