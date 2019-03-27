package com.srikanth.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.srikanth.model.StudentDetails;

@Controller
public class StudentController {
	
	@Autowired
     SessionFactory sessionFactory;

	@RequestMapping("/RegisterStudent")
	public void registerStudents()
	{
		
		System.out.println("Hello");
		System.out.println("Hello this is StudentController");
		System.out.println("sessionFactory = "+sessionFactory);
		StudentDetails student = new StudentDetails();
		
		student.setsName("Vinayak");
		//student.setId(95);
		System.out.println("session obj = "+sessionFactory.openSession());
		Session session = null;
		session = sessionFactory.openSession();
		
		Transaction trnx = session.beginTransaction();
		
		session.save(student);
		
		trnx.commit();
		//m.addAttribute("student", new Student());
		//System.out.println("JdbcTemplate = "+template);
		//System.out.println("service in Student Controller = "+service);
		//System.out.println("dao = "+dao);
		//return "registerStudent.jsp";
		
	}

}
