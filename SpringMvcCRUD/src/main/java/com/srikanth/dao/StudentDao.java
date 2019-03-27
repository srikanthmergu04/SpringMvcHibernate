package com.srikanth.dao;

import java.util.List;

import com.srikanth.model.StudentDetails;

public interface StudentDao {
	
	public int addStudent(StudentDetails student);

	public List<StudentDetails> listAllStudents();
	
	public int updateStudent(StudentDetails student);
	
	public int deleteStudent(int primary);
	
	public StudentDetails getStudentObject(int primary);
}
