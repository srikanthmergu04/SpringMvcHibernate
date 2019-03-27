package com.srikanth.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		Session session = null;
		session = sessionFactory.openSession();
		
		
		Transaction trnx = session.beginTransaction();
		
		session.save(student);
		
		trnx.commit();
		
		return 0;
	}
	public List<StudentDetails> listAllStudents() {
		// TODO Auto-generated method stub
		
		Session session = null;
		session = sessionFactory.openSession();
		
		
		List<StudentDetails> list = new ArrayList();
		
		Query query = session.createQuery("from StudentDetails");
		
		list = query.list();
		
		
		
		
		return list;
	}

}
