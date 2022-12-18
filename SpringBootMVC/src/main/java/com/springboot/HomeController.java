package com.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.Alien;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String execute() {
		System.out.println("Spring Boot is executing the required method");
		return "index";
	}
	/*// Here I am using the standard HTTpServletRequest objects to send and receive data.
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		int a = Integer.parseInt(request.getParameter("N1"));
		int b = Integer.parseInt(request.getParameter("N2"));
		int k =a+b;
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("Result", k);
		return "Add.jsp";
	}
	*/
	//Better way to do it . Using the @RequestParam annotation I do not need to use the request object
	/*
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("N1")int i ,@RequestParam("N2") int j) {
		int k = i+j;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Add");
		mv.addObject("Result", k);
		return mv;
	}
	*/
	/*
	@RequestMapping("/add")
	public String add(@RequestParam("N1")int i ,@RequestParam("N2") int j, Model m) {   // We can also use ModelMap here
		int k = i+j;
		m.addAttribute("Result", k);
		return "Add";
	}
	*/
	
	@RequestMapping("/add")
	//public String add(@RequestParam("aid")int i ,@RequestParam("aName") String name, Model m) {   // We can also use ModelMap here
	// A better way to do this using the @ModelAttribute annotation
	public String add(@ModelAttribute Alien alien, Model m) {
//		Alien alien = new Alien();
//		alien.setId(i);
//		alien.setName(name);
		m.addAttribute("Result", alien);
		System.out.println(alien);
		return "Add";
	}
	
}
