package com.hotel.demo.controler;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping	

public class ControladorLogin {
	
	
	
	@GetMapping("/Login")
	public String login (){
		
		return "Login";
		
	}
}

