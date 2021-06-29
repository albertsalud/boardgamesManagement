package com.albertsalud.bgmanagement.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.bgmanagement.model.dao.OwnerDAO;
import com.albertsalud.bgmanagement.model.entities.Owner;

@Service
public class OwnerServices {
	@Autowired
	private OwnerDAO ownerDAO;
	public List<Owner> listOwners(){
		return ownerDAO.findAllByOrderBySurname1AscSurname2AscNameAsc();
	}

}
