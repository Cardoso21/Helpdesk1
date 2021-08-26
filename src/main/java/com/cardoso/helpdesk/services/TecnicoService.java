package com.cardoso.helpdesk.services;

import com.cardoso.helpdesk.domain.Tecnico;
import com.cardoso.helpdesk.repositories.TecnicoRepository;
import com.cardoso.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não Encontrado!!" + id));
    }

}
