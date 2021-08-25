package com.cardoso.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardoso.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	

}
