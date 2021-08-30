package com.cardoso.helpdesk.domain.DTO;


import com.cardoso.helpdesk.domain.Chamado;
import com.cardoso.helpdesk.domain.Cliente;
import com.cardoso.helpdesk.domain.Tecnico;
import com.fasterxml.jackson.annotation.JsonFormat;


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
    private String titulo;
    private String observaçoes;
    private String NomeTecnico;
    private String NomeCliente;

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
        NomeTecnico = obj.getTecnico().getNome();
        NomeCliente = obj.getCliente().getNome();
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



    public String getNomeTecnico() {
        return NomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        NomeTecnico = nomeTecnico;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        NomeCliente = nomeCliente;
    }
}
