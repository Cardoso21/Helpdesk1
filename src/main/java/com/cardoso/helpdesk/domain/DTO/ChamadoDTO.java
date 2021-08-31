package com.cardoso.helpdesk.domain.DTO;


import com.cardoso.helpdesk.domain.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


public class ChamadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtFechamento;
    private Integer prioridade;
    private Integer status;
    @NotNull(message = "Campo obrigatorio!!")
    private String titulo;
    @NotNull(message = "Campo obrigatorio!!")
    private String observaçoes;
    private Integer tecnico;
    private Integer cliente;
    private String nomeTecnico;
    private String nomeCliente;

    public ChamadoDTO() {
        super();
    }

    public ChamadoDTO(Chamado obj) {
                this.id = obj.getId();
        this.dtAbertura = obj.getDtAbertura();
        this.dtFechamento = obj.getDtFechamento();
        this.prioridade = obj.getPrioridade().getCodigo();
        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observaçoes = obj.getObservaçoes();
        this.tecnico = obj.getTecnico().getId();
        this.cliente = obj.getCliente().getId();
        this.nomeTecnico = obj.getTecnico().getNome();
        this.nomeCliente = obj.getCliente().getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public LocalDate getDtFechamento() {
        return dtFechamento;
    }

    public void setDtFechamento(LocalDate dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservaçoes() {
        return observaçoes;
    }

    public void setObservaçoes(String observaçoes) {
        this.observaçoes = observaçoes;
    }

    public Integer getTecnico() {
        return tecnico;
    }

    public void setTecnico(Integer tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}