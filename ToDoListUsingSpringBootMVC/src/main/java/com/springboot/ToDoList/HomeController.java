package com.springboot.ToDoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.ToDoList.Model.ToDo;
import com.springboot.ToDoList.Model.User;
import com.springboot.ToDoList.service.ToDoRepoServiceImplementer;
import com.springboot.ToDoList.service.UserRepoServiceImplementer;

@Controller
public class HomeController {
	ToDoRepoServiceImplementer doRepoServiceImplementer;
	UserRepoServiceImplementer userRepoServiceImplementer;
	@Autowired
	public HomeController(ToDoRepoServiceImplementer doRepoServiceImplementer, UserRepoServiceImplementer userRepoServiceImplementer) {
		this.doRepoServiceImplementer=doRepoServiceImplementer;
		this.userRepoServiceImplementer=userRepoServiceImplementer;
	}
	
	@GetMapping("/")
	public String getAllToDo(Model model) {
		System.out.println("Inside / getMapping GET request");
		List<ToDo> toDos = doRepoServiceImplementer.returnAllToDo();
		model.addAttribute("toDoList",toDos);
		String demo= "forDemo";
		model.addAttribute("key", demo);
		return "indexUsingThymeleaf";
	}
	
	@PostMapping("/addToDo")
	public String addToDo(@ModelAttribute ToDo toDo, Model model) {
		System.out.println("Inside /addToDo Post request");
		List<ToDo> dos= doRepoServiceImplementer.addToDo(toDo);
		// Okay so when I call the /addToDo url the POst request is executed which is common sense but the value that is being entered is also updated
		// Automatically as essentially I am redirecting on the same page
		model.addAttribute("toDoList",dos); // I am sending the same key from both the methods 
		// So when the HTML is being rendered it is getting the value from both the methods
		// So actually the get method is not being recalled
		// I can test it by not sending a model object
		System.out.println(dos);
		return "indexUsingThymeleaf";
	}
	@PostMapping("/updateToDo")
	public String updateToDo(@ModelAttribute ToDo toDo, Model model) {
		List<ToDo> dos = doRepoServiceImplementer.updateToDo(toDo);
		model.addAttribute("toDoList",dos);
		return "indexUsingThymeleaf";
	}
	
	@PostMapping("deleteToDo")
	public String deleteToDo(@RequestParam("topicId") long toDoId, Model model) {
		List<ToDo> dos = doRepoServiceImplementer.removeToDo(toDoId);
		model.addAttribute("toDoList",dos);
		return "indexUsingThymeleaf";
	}
	
	
	/*@PostMapping("login")
	public String returnLoginPage(@RequestParam("username") String username, @RequestParam("password") String password ) {
		
		return null;
	}
	// I am passing all values in the form and they are basically equal to the number of instance variables in the class
	// So the @ModelAttribute it basically automates the process of adding it to a object
	// I could have used @RequestAttribute here which would have given me the values per reference
	// But then I would have had to map it inside the method using the @Requestparameter
	// After this what I can do is 
	@GetMapping("/registration")
	public String registration() {
		//model.addAttribute("Model",model);// Sending an empty object to the view
		return "Registration";
	}
	
	@PostMapping
	public String addUser(@ModelAttribute User user) {
		userRepoServiceImplementer.addAUser(user);  // Once a User is added I will redirect it to a Login page
		return "Login";
	}*/
	
	
	
}
