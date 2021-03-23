package com.POkevat.AlbumList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.POkevat.AlbumList.domain.AlbumRepository;
import com.POkevat.AlbumList.domain.GenreRepository;

@Controller
public class AlbumController {

	@Autowired
	private AlbumRepository arepo;
	
	@Autowired
	private GenreRepository grepo;
	
	@GetMapping("/home")
		public String frontpage(Model model) {
		
		model.addAttribute("albums", arepo.findAll());
		model.addAttribute("genres", grepo.findAll());
				
		return "home";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "home";
	}
}
