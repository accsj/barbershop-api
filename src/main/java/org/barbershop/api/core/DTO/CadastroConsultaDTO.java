package org.barbershop.api.core.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.Date;

public class CadastroConsultaDTO {

    private Long id;

    private Long idCliente;

    @NotNull
    private Long idFuncionario;

    @NotNull
    private OffsetDateTime dataConsulta;

    public CadastroConsultaDTO() {
    }

    public CadastroConsultaDTO(Long id, Long idCliente, Long idFuncionario, OffsetDateTime dataConsulta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.dataConsulta = dataConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public OffsetDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(OffsetDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
