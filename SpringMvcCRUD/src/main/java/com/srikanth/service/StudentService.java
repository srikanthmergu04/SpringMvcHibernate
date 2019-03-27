package com.srikanth.service;

import java.util.List;

import com.srikanth.model.StudentDetails;

public interface StudentService {
	
	public int addStudent(StudentDetails student);
	
	public List<StudentDetails> listAllStudents();
	
	public int updateStudent(StudentDetails student);
	
	public int deleteStudent(int primary);
	
	public StudentDetails getStudentObject(int primary);

}
