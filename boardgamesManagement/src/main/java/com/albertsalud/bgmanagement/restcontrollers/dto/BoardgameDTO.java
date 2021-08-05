package com.albertsalud.bgmanagement.restcontrollers.dto;

import org.apache.logging.log4j.util.Strings;

import com.albertsalud.bgmanagement.model.entities.Boardgame;

import lombok.Data;

@Data
public class BoardgameDTO {
	
	public BoardgameDTO(Boardgame bg) {
		
		this.description = Strings.isEmpty(bg.getDescription()) ? "" : bg.getDescription();
		this.id = bg.getId();
		this.imagePath = Strings.isEmpty(bg.getImageName()) ? "" : bg.getImageName();
		this.maxPlayers = bg.getMaxPlayers() == null ? 0 : bg.getMaxPlayers();
		this.minAge = bg.getMinAge() == null ? 0 : bg.getMinAge();
		this.minPlayers = bg.getMinPlayers() == null ? 0 : bg.getMinPlayers();
		this.name = Strings.isEmpty(bg.getName()) ? "" : bg.getName();
		this.tags = "";
		this.time = bg.getTimeToPlay() == null ? 0 : bg.getTimeToPlay();
		this.type = "";

	}
	
	private String tags;
	private int minAge;
	private Long id;
	private String name;
	private String description;
	private int maxPlayers;
	private int minPlayers;
	private int time;
	private String type;
	private String imagePath;
}
