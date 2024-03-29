package com.albertsalud.bgmanagement.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.albertsalud.bgmanagement.model.entities.Boardgame;
import com.albertsalud.bgmanagement.model.services.BoardgameServices;
import com.albertsalud.bgmanagement.model.services.OwnerServices;
import com.albertsalud.bgmanagement.utils.FileUploadService;
import com.albertsalud.bgmanagement.utils.FileUploadService.FileUploadServiceResult;

@Controller
public class BoardgameController {
	
	private static final String UPLOADED_IMAGES_FOLDER = "/uploaded/images"; 
	
	@Autowired
	private OwnerServices ownerServices;
	
	@Autowired
	private BoardgameServices boardgameServices;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping(value = {"", "/"})
	public String listBoardgames(Model model) {
		model.addAttribute("boardgames", boardgameServices.listBoardgames());
		
		return "boardgameList";
	}
	
	@GetMapping("/new")
	public String newBoardgame(Model model) {
		model.addAttribute("boardgame", new Boardgame());
		setOwnersListToModel(model);
		return "boardgameForm";
	}
	
	private void setOwnersListToModel(Model model) {
		model.addAttribute("ownersList", ownerServices.listOwners());
	}

	@PostMapping("/save")
	public String saveBoardgame(Model model,
			@Valid @ModelAttribute Boardgame boardgame,
			BindingResult bindingResults,
			@RequestParam("image") MultipartFile image) {
		
		if(bindingResults.hasErrors()) {
			model.addAttribute("boardgame", boardgame);
			setOwnersListToModel(model);
			return "boardgameForm";
		}
		
		if(!Strings.isEmpty(image.getOriginalFilename())) {
			FileUploadServiceResult uploadImageResult = uploadImage(image);
			if(uploadImageResult.isOk()) boardgame.setImageName(uploadImageResult.getDestinationName());
		}
		boardgameServices.saveBoardgame(boardgame);
		
		return this.listBoardgames(model);
	}

	private FileUploadServiceResult uploadImage(MultipartFile image) {
		return fileUploadService.saveFile(UPLOADED_IMAGES_FOLDER, image.getOriginalFilename(), image);
		
	}

	@GetMapping("/{boardgameId}")
	public String getBoardgame(Model model,
			@PathVariable Long boardgameId) {
		
		Boardgame boardgame = boardgameServices.getBoardgame(boardgameId);
		
		if (boardgame == null) {
			model.addAttribute("message", "Requested boardgame id not exist in DB");
			return this.newBoardgame(model);
		}
		
		setOwnersListToModel(model);
		
		model.addAttribute("boardgame", boardgame);
		return "boardgameForm";
	}
	
	@GetMapping("/delete")
	public String deleteBoardgame(
			@RequestParam(required = false) Long boardgameId,
			Model model
			) {
		boardgameServices.deleteBoardgame(boardgameId);
		
		return this.listBoardgames(model);
	}
}
