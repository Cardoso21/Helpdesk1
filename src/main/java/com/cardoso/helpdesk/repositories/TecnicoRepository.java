package com.cardoso.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardoso.helpdesk.domain.enums.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
	

}
