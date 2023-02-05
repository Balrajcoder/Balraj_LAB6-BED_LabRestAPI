package com.basepack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basepack.entity.Student;
import com.basepack.service.StudentService;


@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("")
	public String welcome(Model theModel) {
	
		
		return "students/Welcome";
	}
	
	
	@GetMapping("/students/list")
	public String listStudents(Model theModel) {
		
		// get students from database
		List<Student> theStudents = studentservice.findAll();
		
		// add to the spring model
		theModel.addAttribute("students", theStudents);
		
		return "students/list-students";
	}
	
	@GetMapping("/students/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student thestudent = new Student();
		
		theModel.addAttribute("student", thestudent);
		
		return "students/student-form";
	}

	@PostMapping("/students/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
									Model theModel) {
		
		// get the student from the service
		Student thestudent = studentservice.findById(theId);
		
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", thestudent);
		
		// send over to our form
		return "students/student-form";			
	}
	
	
	@PostMapping("/students/save")
	public String savestudent(@ModelAttribute("student") Student thestudent) {
		
		// save the student
		studentservice.save(thestudent);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}
	
	
	@PostMapping("/students/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		// delete the student
		studentservice.deleteById(theId);
		
		// redirect to /students/list
		return "redirect:/students/list";
		
	}
	

}
