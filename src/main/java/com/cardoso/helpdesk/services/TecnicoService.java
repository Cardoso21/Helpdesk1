package com.cardoso.helpdesk.services;

import com.cardoso.helpdesk.domain.DTO.TecnicoDTO;
import com.cardoso.helpdesk.domain.Pessoa;
import com.cardoso.helpdesk.domain.Tecnico;
import com.cardoso.helpdesk.repositories.PessoaRepository;
import com.cardoso.helpdesk.repositories.TecnicoRepository;
import com.cardoso.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.cardoso.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não Encontrado!!" + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        validaPorCpfEEmail(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return repository.save(newObj);
    }

    public Tecnico update(Integer id, TecnicoDTO objDTO) {
        objDTO.setId(id);
        Tecnico oldObj = findById(id);
        validaPorCpfEEmail(objDTO);
        oldObj = new Tecnico(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Tecnico obj = findById(id);

        if (obj.getChamados().size() > 0 ){
            throw  new DataIntegrityViolationException("O tecnico possui ordem de serviço e nao pode ser DELETADO!!");
        }
            repository.deleteById(id);
    }

    private void validaPorCpfEEmail(TecnicoDTO objDTO) {

        Optional <Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("CPF ja cadastrado no sintema!");
        }
        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("E-mail ja cadastrado no sintema!");
        }

    }



}
