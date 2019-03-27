package com.srikanth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value="/updateOrDelete", method=RequestMethod.POST)
	public String updateOrDelete(HttpServletRequest req , Model model)
	{
		int primary = Integer.parseInt(req.getParameter("key"));
		
		String action =  req.getParameter("action");
		
		System.out.println("primary id = "+primary);
		
		System.out.println("Action = "+action);
		
		if(action.equals("update"))
		{
			StudentDetails student = service.getStudentObject(primary);
			
			/*
			
			System.out.println(student.getId());
			System.out.println(student.getsName());
			System.out.println(student.getAge());
			System.out.println(student.getGender());
			System.out.println(student.getDept());
			*/
			model.addAttribute("student", student);
			
			return "updateStudentDetails.jsp";
		}
		else
		{
			service.deleteStudent(primary);
			return "redirect:/listStudents";
		}
		
		
		
		
	}
	
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.POST)
   public String updateStudent(HttpServletRequest req , @ModelAttribute("student") StudentDetails student)
   {
		int primary = Integer.parseInt(req.getParameter("id"));
		
		//System.out.println("primary id = "+primary);
		student.setId(primary);
		/*
		System.out.println("id = "+student.getId());
		System.out.println(student.getId());
		System.out.println(student.getsName());
		System.out.println(student.getAge());
		System.out.println(student.getGender());
		System.out.println(student.getDept());
		*/
		service.updateStudent(student);
		
		
		return "redirect:/listStudents";
	   
   }
	


}
