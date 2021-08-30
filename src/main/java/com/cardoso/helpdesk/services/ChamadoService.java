package com.cardoso.helpdesk.services;

import com.cardoso.helpdesk.domain.Chamado;
import com.cardoso.helpdesk.repositories.ChamadoRepository;
import com.cardoso.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto nao enconrtrado! ID" + id));
    }
}
