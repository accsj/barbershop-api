package org.barbershop.api.core.DTO;

public class ClienteSimplesDTO {

    private Long id;

    private Integer tipoContrato;

    public ClienteSimplesDTO() {
    }

    public ClienteSimplesDTO(Long id, Integer tipoContrato) {
        this.id = id;
        this.tipoContrato = tipoContrato;
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
}
