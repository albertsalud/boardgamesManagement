package com.albertsalud.bgmanagement.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albertsalud.bgmanagement.model.entities.Owner;
import com.albertsalud.bgmanagement.model.services.OwnerServices;

@Controller
@RequestMapping("/owners")
public class OwnerController {
	
	@Autowired
	private OwnerServices ownerServices;
	
	@GetMapping(value = {"", "/"})
	public String listOwners(Model model) {
		model.addAttribute("owners", ownerServices.listOwners());
		return "ownerList";
	}
	
	@GetMapping("/new")
	public String newOwner(Model model) {
		model.addAttribute("owner", new Owner());
		return "ownerForm";
	}
	
	@GetMapping("/{ownerId}")
	public String getBoardgame(Model model,
			@PathVariable Long ownerId) {
		
		Owner owner = ownerServices.getOwner(ownerId);
		
		if (owner == null) {
			model.addAttribute("message", "Requested owner id not exist in DB");
			return this.newOwner(model);
		}
				
		model.addAttribute("owner", owner);
		return "ownerForm";
	}
	
	@PostMapping("/save")
	public String saveOwner(Model model,
			@Valid @ModelAttribute Owner owner,
			BindingResult bindingResults) {
		
		if(bindingResults.hasErrors()) {
			model.addAttribute("owner", owner);
			return "ownerForm";
		}
		
		ownerServices.saveOwner(owner);
		
		return this.listOwners(model);
	}

}
