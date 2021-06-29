package com.albertsalud.bgmanagement.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@NotBlank
	@Column(nullable = false)
	private String surname1;
	
	private String surname2;
	
	@Email
	private String email;
	
	private String phone;
	
	public String getFullName() {
		return this.surname1 + (this.surname2 == null ? "" : " " + this.surname2) + ", " + this.name;
	}

}
