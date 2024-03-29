package com.albertsalud.bgmanagement.model.entities;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.albertsalud.bgmanagement.model.enums.BoardgameType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Boardgame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@NotBlank
	@Size(min = 0, max = 4000)
	@Column(nullable = false, length = 4000)
	private String description;
	
	@Column(nullable = false)
	private String imageName;
	
	@ElementCollection(targetClass = BoardgameType.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "boardgame_type",
			joinColumns = @JoinColumn(name = "boardgame_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Set<BoardgameType> types;
	
	@Column(nullable = true)
	private Integer minAge;
	
	@Column(nullable = true)
	private Integer maxAge;
	
	@Column(nullable = true)
	private Integer minPlayers;
	
	@Column(nullable = true)
	private Integer maxPlayers;
	
	@Column(nullable = true)
	private Integer timeToPlay;
	
	private Integer maxTimeToPlay;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Owner owner;

}
