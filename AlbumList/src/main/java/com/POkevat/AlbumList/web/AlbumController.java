package com.POkevat.AlbumList.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.POkevat.AlbumList.domain.Album;
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
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
		public String remove(@PathVariable("id") Long id, Model model) {
		arepo.deleteById(id);
		
		return "redirect:/home";
	}
	
	@GetMapping("/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
		public String modify(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("album", arepo.findById(id));
		model.addAttribute("genres", grepo.findAll());
		
		System.out.println(model.getAttribute("album"));
		
		return "edit";
	}
	
	@PostMapping("/update/")
		public String update(@Valid Album album, BindingResult bindingresult, Model model) {
		if(bindingresult.hasErrors()) {
			model.addAttribute("genres", grepo.findAll());
			return "edit";
		}
		
		System.out.println(album);
		arepo.save(album);
		
		return "redirect:/home";
	}
	
	@GetMapping("/add")
	@PreAuthorize("hasAuthority('ADMIN')")
		public String add(Model model) {
		
		model.addAttribute("album", new Album());
		model.addAttribute("genres", grepo.findAll());
		
		return "add";
	}
	
	@PostMapping("/save")
	@PreAuthorize("hasAuthority('ADMIN')")
		public String save(@Valid Album album, BindingResult bindingresult, Model model) {
		
		if(bindingresult.hasErrors()) {
			
			model.addAttribute("genres", grepo.findAll());
			return "add";
		}
		
		
		model.addAttribute("album", album);
		arepo.save(album);
		
		return "redirect:/home";
	}
}
