package com.albertsalud.bgmanagement.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.bgmanagement.model.dao.BoardgameDAO;
import com.albertsalud.bgmanagement.model.entities.Boardgame;

@Service
public class BoardgameServices {

	@Autowired
	private BoardgameDAO boardgameDAO;
	
	public List<Boardgame> listBoardgames() {
		return boardgameDAO.findAll();
	}

	
	public void saveBoardgame(Boardgame boardgame) {
		boardgameDAO.save(boardgame);
	}


	public Boardgame getBoardgame(Long boardgameId) {
		return boardgameDAO.findById(boardgameId).orElse(null);
	}

}
