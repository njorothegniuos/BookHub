package com.MBASE.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Home {
	
	
	@RequestMapping("/")
	public String getAll(){
		return "Docker applcation up and running";
	}

}
