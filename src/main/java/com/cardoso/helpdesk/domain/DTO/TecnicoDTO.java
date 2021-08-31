package com.cardoso.helpdesk.domain.DTO;

import com.cardoso.helpdesk.domain.Tecnico;
import com.cardoso.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecnicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "Nome obrigatorio!")
    protected String nome;
    @NotNull(message = "CPF obrigatorio!")
    protected String cpf;
    @NotNull(message = "E-mail obrigatorio!")
    protected String email;
    @NotNull(message = "Senha obrigatoria!")
    protected String senha;
    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriaçao = LocalDate.now();

    public TecnicoDTO() {
        super();
        addPerfis(Perfil.CLIENTE);
    }

    public TecnicoDTO(Tecnico obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriaçao = obj.getDataCriaçao() ;
        addPerfis(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfis(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDataCriaçao() {
        return dataCriaçao;
    }

    public void setDataCriaçao(LocalDate dataCriaçao) {
        this.dataCriaçao = dataCriaçao;
    }
}
