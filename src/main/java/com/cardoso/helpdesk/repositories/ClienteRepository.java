package com.cardoso.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardoso.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	

}
