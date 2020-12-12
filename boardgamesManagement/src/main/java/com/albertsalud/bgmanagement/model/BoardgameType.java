package com.albertsalud.bgmanagement.model;

import lombok.Getter;

@Getter
public enum BoardgameType {
	CARDS("CARDS", "CARDS"),
	DICES("DICES", "DICES"),
	BOARD("BOARD", "BOARD"),
	TILES("TILES", "TILES");
	
	private String code;
	private String value;
	
	
	private BoardgameType(String code, String value) {
		this.code = code;
		this.value = value;
	}
	
}
