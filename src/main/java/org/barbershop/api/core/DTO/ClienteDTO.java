package org.barbershop.api.core.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClienteDTO {

    private Long id;

    private Integer tipoContrato;

    private List<ConsultaSimplesDTO> consultas;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, Integer tipoContrato, List<ConsultaSimplesDTO> consultas) {
        this.id = id;
        this.tipoContrato = tipoContrato;
        this.consultas = consultas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(Integer tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public List<ConsultaSimplesDTO> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaSimplesDTO> consultas) {
        this.consultas = consultas;
    }
}
