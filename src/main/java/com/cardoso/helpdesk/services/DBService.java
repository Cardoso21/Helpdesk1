package com.cardoso.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardoso.helpdesk.domain.Cliente;
import com.cardoso.helpdesk.domain.Chamado;
import com.cardoso.helpdesk.domain.enums.Perfil;
import com.cardoso.helpdesk.domain.enums.Prioridade;
import com.cardoso.helpdesk.domain.enums.Status;
import com.cardoso.helpdesk.domain.Tecnico;
import com.cardoso.helpdesk.repositories.ChamadoRepository;
import com.cardoso.helpdesk.repositories.ClienteRepository;
import com.cardoso.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Wagner Cardoso", "723.886.830-09", "wagner@email.com", "1234");
		tec1.addPerfis(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linuis Torvalds", "287.319.690-46", "linuis@email.com", "4321");

		Chamado cha1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1,
				cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cha1));
	}

}
