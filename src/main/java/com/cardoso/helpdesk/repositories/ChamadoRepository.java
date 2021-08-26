package com.cardoso.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardoso.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{
	

}
