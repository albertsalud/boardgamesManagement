package com.albertsalud.bgmanagement.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.bgmanagement.model.entities.Boardgame;

public interface BoardgameDAO extends JpaRepository<Boardgame, Long> {

}
