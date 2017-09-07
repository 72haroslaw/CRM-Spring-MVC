package com.rafalzdzieborski.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rafalzdzieborski.spring.dao.StudentDAOImpl;
import com.rafalzdzieborski.spring.model.Student;
import com.rafalzdzieborski.spring.model.StudentService;

@Controller
public class ServiceController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentDAOImpl studentDAOImpl;
	
	@RequestMapping(value= {"/service"}, method = RequestMethod.GET)
    public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("service");
		List<Student> studentList = studentService.getStudentList();
		model.addObject("studentList", studentList);
		return model;
	}
	
	@RequestMapping(value= {"/newStudent"}, method = RequestMethod.GET)
    public ModelAndView newStudent() {
		ModelAndView model = new ModelAndView();
		Student student = new Student();
		model.addObject("student", student);
		model.setViewName("formStudent");
		return model;
	}
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute Student student) {
        if (student.getId() == 0) { 
        	studentDAOImpl.create(student);
        } else {
        	studentDAOImpl.update(student);
        }
        return new ModelAndView("redirect:/service");
    }
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
    public ModelAndView editStudent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		Student student = studentDAOImpl.getStudent(Integer.parseInt(request.getParameter("id")));
		model.addObject("student", student);
		model.setViewName("formStudent");
        return model;
    }
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        Student student = studentDAOImpl.getStudent(Integer.parseInt(request.getParameter("id")));
        studentDAOImpl.delete(student);
        return new ModelAndView("redirect:/service");
    }
	
	@RequestMapping(value = "/truncateDatabase", method = RequestMethod.GET)
    public ModelAndView deleteDatabase() {
        studentDAOImpl.cleanup();
        return new ModelAndView("redirect:/homePage");
    }
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
		return new ModelAndView("about");
	}
}