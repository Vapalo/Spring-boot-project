package com.POkevat.AlbumList.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

	
	@GetMapping("/home")
		public String frontpage() {
		return "home";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "home";
	}
}
