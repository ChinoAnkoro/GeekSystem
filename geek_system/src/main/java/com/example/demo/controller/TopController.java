package main.java.com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {
	
	@GetMapping("/admin/top")
	public String menu() {
		return "admin/top";
	}
}
