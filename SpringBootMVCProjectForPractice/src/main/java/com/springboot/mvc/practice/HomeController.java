package com.springboot.mvc.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.mvc.practice.model.Student;
import com.springboot.mvc.practice.service.DAOService;

@Controller
public class HomeController {
	DAOService daoService;
	@Autowired
	public HomeController(DAOService daoService) {
		this.daoService = daoService;
	}
	
	
	@PostMapping("/Student")
	public String addStudents(@ModelAttribute Student student, Model model) {
		// I will save the student here and then I will use Model object to send it;
		model.addAttribute("StudentList",daoService.addAStudent(student));
		
		return "index";
	}
	
	@GetMapping("/Student")
	public String getAllStudents(Model model) {
		model.addAttribute("StudentList",daoService.getAllStudents());
		return "index";
	}
	
	//@PutMapping("/Student")
	@PostMapping("/Student/update")
	public String updateStudent(@RequestParam("studentid") int studentId, @ModelAttribute Student student, Model model) {  // Can use both request Mapping and ModelAttributeObject
		model.addAttribute("StudentList",daoService.updateAStudent(studentId, student));
		return "index";
	}
	@PostMapping("/Student/delete")
	public String deleteStudent(@RequestParam("studentid") int studentid, Model model) {
		
		model.addAttribute("StudentList",daoService.deleteAStudent(studentid));
		return "index";
	}
	
	/*@PostMapping("/Student/delete/{studentid}")
	public String deleteStudent(@PathVariable("studentid") int studentid, Model model) {
		
		model.addAttribute("StudentList",daoService.deleteAStudent(studentid));
		return "index";
	}*/
}
