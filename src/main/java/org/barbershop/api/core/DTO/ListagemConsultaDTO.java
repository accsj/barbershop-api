package org.barbershop.api.core.DTO;

import java.util.Date;

public class ListagemConsultaDTO {

    private Long id;

    private Date dataConsulta;

    private Boolean remarcada;

    private Boolean ativo;

    public ListagemConsultaDTO() {
    }

    public ListagemConsultaDTO(Long id, Date dataConsulta, Boolean remarcada, Boolean ativo) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.remarcada = remarcada;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Boolean getRemarcada() {
        return remarcada;
    }

    public void setRemarcada(Boolean remarcada) {
        this.remarcada = remarcada;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
