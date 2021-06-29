package com.albertsalud.bgmanagement.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.bgmanagement.model.entities.Owner;

public interface OwnerDAO extends JpaRepository<Owner, Long> {
	
	public List<Owner> findAllByOrderBySurname1AscSurname2AscNameAsc();

}
