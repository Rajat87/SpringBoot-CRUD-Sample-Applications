package com.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.model.Products;
import com.springboot.service.ProductsService;

@Controller
public class ProductsController {
	ProductsService productsService;
	
	public ProductsController(ProductsService productsService) {
		System.out.println("Parameterized constructor called for Dependency Injection");
		this.productsService=productsService;
	}
	
	
	//In this method I will return the list of products added in a single session in a graceful manner 
	// I will need a separate view for this
	// Can I map the same URL for Both just vary it on the basis of whether the user makes a get request or post request
	@GetMapping("Product")
	public String returnListOfProducts(Model model) {
		System.out.println("Get is Executing");
		model.addAttribute("List", productsService.giveAllProducts());   // Let' say If I return the list here. If I return the list I need to print it only when the user makes a get request.
		return "Result";
	}
	
	// Let' say In this method I will keep adding to the array list all the books that the user will enter in a single session. This should execute only when the user makes a post request
	@PostMapping("Product")
	public String addProductToList(@ModelAttribute Products product,Model model) {
		System.out.println("Post is Executing");
		// When I refresh the URl it should add a fresh product to the ArrayList
		productsService.addProduct(product); // Product should be added in the array list
		//System.out.println(productsService.giveAllProducts()); It is getting added in the array List
		model.addAttribute("List", productsService.giveAllProducts());
		return "Result";
	}
	
	
}


// Let' say I create two different jsp's for client one for get and one for post. I will return a different page when I receive a get request and when I receive a post request.