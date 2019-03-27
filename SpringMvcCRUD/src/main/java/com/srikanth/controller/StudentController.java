package com.srikanth.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srikanth.model.StudentDetails;
import com.srikanth.service.impl.StudentServiceImpl;

@Controller
public class StudentController {
	
	
	
	@Autowired
	StudentServiceImpl service;

	@RequestMapping("/RegisterStudent")
	public String registerStudents(Model model)
	{
		model.addAttribute("student", new StudentDetails());
		return "addStudent.jsp";
		
		/*
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
		
		*/
		//m.addAttribute("student", new Student());
		//System.out.println("JdbcTemplate = "+template);
		//System.out.println("service in Student Controller = "+service);
		//System.out.println("dao = "+dao);
		//return "registerStudent.jsp";
		
	}
	
	@RequestMapping(value="/registerSuccess", method=RequestMethod.POST)
	public String registerSuccess(@ModelAttribute("student") StudentDetails student) {
		
		
		System.out.println(student.getsName());
		System.out.println(student.getDept());
		System.out.println("StudentService obj = "+service);

		service.addStudent(student);
		
		//userService.createUser(student);
		return "redirect:/listStudents";
	}
	
	@RequestMapping(value="/listStudents", method=RequestMethod.GET)
	public String listStudents(Model model)
	{
		//ModelAndView model = new ModelAndView();
		List<StudentDetails> student = new ArrayList();
		
		student = service.listAllStudents();
		
	//System.out.println("student in Controller = "+student);
		
		/*
		for (StudentDetails stu : student) {
			
			System.out.println(stu.getId());
			System.out.println(stu.getsName());
			System.out.println(stu.getAge());
			System.out.println(stu.getDept());
			//System.out.println(stu.getCity());
			
			
		}
		*/
		

		/*
		model.addObject("list", student);
	
		model.setViewName("listStudents.jsp");
		*/
		
		model.addAttribute("list", student);
		
		
		return "listStudents.jsp";
		
	}

}
