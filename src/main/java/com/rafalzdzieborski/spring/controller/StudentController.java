package com.rafalzdzieborski.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rafalzdzieborski.spring.dao.StudentDAOImpl;
import com.rafalzdzieborski.spring.model.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDAOImpl studentDAOImpl;
	
	@RequestMapping(value= "/service", method = RequestMethod.GET)
    public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("service");
		List<Student> studentList = studentDAOImpl.getAllStudents();
		modelAndView.addObject("studentList", studentList);
		return modelAndView;
	}
	
	@RequestMapping(value= "/newStudent", method = RequestMethod.GET)
    public ModelAndView newStudent() {
		ModelAndView modelAndView = new ModelAndView();
		Student student = new Student();
		modelAndView.addObject("student", student);
		modelAndView.setViewName("formStudent");
		return modelAndView;
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
	
	@RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", studentDAOImpl.getStudent(id));
		modelAndView.setViewName("formStudent");
        return modelAndView;
    }
	
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable("id") int id) {
        studentDAOImpl.delete(studentDAOImpl.getStudent(id));
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