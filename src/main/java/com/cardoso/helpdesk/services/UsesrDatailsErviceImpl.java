package com.cardoso.helpdesk.services;

import com.cardoso.helpdesk.domain.Pessoa;
import com.cardoso.helpdesk.repositories.PessoaRepository;
import com.cardoso.helpdesk.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsesrDatailsErviceImpl implements UserDetailsService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Pessoa> user = repository.findByEmail(email);
        if(user.isPresent()){
            return new UserSS(user.get().getId(),user.get().getEmail(),user.get().getSenha(),user.get().getPerfis());

        }
        throw new UsernameNotFoundException(email);
    }
}
