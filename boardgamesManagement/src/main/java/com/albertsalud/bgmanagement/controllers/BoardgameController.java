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

import com.albertsalud.bgmanagement.model.entities.Boardgame;
import com.albertsalud.bgmanagement.model.services.BoardgameServices;

@Controller
@RequestMapping("/boardgames")
public class BoardgameController {
	
	@Autowired
	private BoardgameServices boardgameServices;
	
	@GetMapping(value = {"", "/"})
	public String listBoardgames(Model model) {
		model.addAttribute("boardgames", boardgameServices.listBoardgames());
		
		return "boardgameList";
	}
	
	@GetMapping("/new")
	public String newBoardgame(Model model) {
		model.addAttribute("boardgame", new Boardgame());
		
		return "boardgameForm";
	}
	
	@PostMapping("/new")
	public String saveBoardgame(Model model,
			@Valid @ModelAttribute Boardgame boardgame,
			BindingResult bindingResults) {
		
		if(bindingResults.hasErrors()) {
			model.addAttribute("boardgame", boardgame);
			return "boardgame";
		}
		
		boardgameServices.saveBoardgame(boardgame);
		return this.listBoardgames(model);
	}

	@GetMapping("/{boardgameId}")
	public String getBoardgame(Model model,
			@PathVariable Long boardgameId) {
		
		Boardgame boardgame = boardgameServices.getBoardgame(boardgameId);
		
		if (boardgame == null) {
			model.addAttribute("message", "Requested boardgame id not exist in DB");
			return this.newBoardgame(model);
		}
		
		model.addAttribute("boardgame", boardgame);
		return "boardgameForm";
	}
}
