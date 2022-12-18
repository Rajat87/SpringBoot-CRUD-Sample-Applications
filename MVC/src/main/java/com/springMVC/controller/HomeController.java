package com.springMVC.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class HomeController {
	
	@RequestMapping("/add")
	public ModelAndView homeUrl(HttpServletRequest request , HttpServletResponse response ) {
		int a = Integer.parseInt(request.getParameter("firstNumber"));
		int b = Integer.parseInt(request.getParameter("secondNumber"));
		int k = a+b;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("View");   // The extension of the view should not be passed. This is where view resolver comes into play
		modelAndView.addObject("result", k);
		return modelAndView;
	}
	
	// Steps for creating a Simple MVC project without XML :
	/* 1)First create index.html file.
	 * 2) Next step is to create a configuration java file for Spring.
	 * 3) Then create a configuration file for Dispatcher Servlet and implement the three abstract methods for it.
	 * 4) Now in that configuration file we need to modify 2 methods getServletMappings and getServletConfigClasses.
	 * 5) In the getServletConfigClasses we need to return the array of type Class and in that array we need to pass the name of the class which we are using.
	 * 6) Then in the getServletMappings we need to return an array of type String and in that we need to pass the URL's which the dispatcher Servlet will handle.
	 * 7) After that we need to create the Controller. For creating a controller we simply create a class and annotate it with the @Controller annotation.
	 * 8) Next we need to create a method which can have any name and annotate it with the @RequestMapping annotation which will categorize each method into a different request.
	 * 9) Now in this method implement whatever business logic you have and put the object or model as a data in the ModelAndView Object along with the View in which you want to display the data to the client.
	 * The return this ModelAndView Object.
	 * 10) Then create a view which is usually a .jsp file and modify it as you want.
	 * 11) Now there is an additional step if you want your view file type to be flexible then you need to add the View resolver Object to the spring context.
	 * 12) For that in your spring configuration file just add the @Bean over a method which returns InternalResourceViewResolver and set it's prefix and Suffix.
	 * 13) This view resolver will resolve the file type and you do not need to add it to the setViewName method string.
	 */

}
