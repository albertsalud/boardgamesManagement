package com.albertsalud.bgmanagement.restcontrollers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albertsalud.bgmanagement.model.services.BoardgameServices;
import com.albertsalud.bgmanagement.restcontrollers.dto.BoardgameDTO;


@RestController
@RequestMapping("/api")
public class BoardgameRestController {
	
	@Autowired
	private BoardgameServices boardgameServices;
	
	@CrossOrigin
	@GetMapping("/boardgames")
	public List<BoardgameDTO> getBoardgames() {
		return boardgameServices.listBoardgames().stream()
			.map(bg -> {
				return new BoardgameDTO(bg);
			})
			.collect(Collectors.toList());
	}

}
