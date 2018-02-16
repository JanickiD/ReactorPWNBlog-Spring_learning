package pl.pwn.reaktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

	@GetMapping("/")
	public String index(Model model) {

		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
}
