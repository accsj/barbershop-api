package org.barbershop.api.core.DTO;

import java.time.OffsetDateTime;
import java.util.Date;

public class ConsultaSimplesDTO {

    private Long id;

    private OffsetDateTime dataConsulta;

    private Boolean remarcada;

    private Boolean ativa;

    public ConsultaSimplesDTO() {
    }

    public ConsultaSimplesDTO(Long id, OffsetDateTime dataConsulta, Boolean remarcada, Boolean ativa) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.remarcada = remarcada;
        this.ativa = ativa;
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
}
