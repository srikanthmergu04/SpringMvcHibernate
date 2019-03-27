package com.srikanth.dao.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srikanth.dao.StudentDao;
import com.srikanth.model.StudentDetails;

@Repository
public class StudentDaoImpl implements StudentDao {

	
	@Autowired
    SessionFactory sessionFactory;
	public int addStudent(StudentDetails student) {
		// TODO Auto-generated method stub
		
		System.out.println("sessionFactory obj = "+sessionFactory);
		return 0;
	}

}
