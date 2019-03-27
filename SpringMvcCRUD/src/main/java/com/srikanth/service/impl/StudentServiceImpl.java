package com.srikanth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srikanth.dao.Impl.StudentDaoImpl;
import com.srikanth.model.StudentDetails;
import com.srikanth.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoImpl dao;
	
	public int addStudent(StudentDetails student) {
		// TODO Auto-generated method stub
		
		System.out.println("dao obj = "+dao);
		
		dao.addStudent(student);
		
		
		return 0;
	}

	public List<StudentDetails> listAllStudents() {
		// TODO Auto-generated method stub
		
		List<StudentDetails> list = new ArrayList();
		
		list = dao.listAllStudents();
		
		return list;
	}

}
