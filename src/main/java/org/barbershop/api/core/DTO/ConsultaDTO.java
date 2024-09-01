package org.barbershop.api.core.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ConsultaDTO {

    private Long id;

    private OffsetDateTime dataConsulta;

    private Boolean remarcada;

    private Boolean ativa;

    private ClienteSimplesDTO cliente;

    private FuncionarioSimplesDTO funcionario;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Long id, OffsetDateTime dataConsulta, Boolean remarcada, Boolean ativa, ClienteSimplesDTO cliente, FuncionarioSimplesDTO funcionario) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.remarcada = remarcada;
        this.ativa = ativa;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(OffsetDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Boolean getRemarcada() {
        return remarcada;
    }

    public void setRemarcada(Boolean remarcada) {
        this.remarcada = remarcada;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public ClienteSimplesDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteSimplesDTO cliente) {
        this.cliente = cliente;
    }

    public FuncionarioSimplesDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioSimplesDTO funcionario) {
        this.funcionario = funcionario;
    }
}
