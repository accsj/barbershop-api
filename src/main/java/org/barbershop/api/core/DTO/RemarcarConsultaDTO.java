package org.barbershop.api.core.DTO;

import java.time.OffsetDateTime;
import java.util.Date;

public class RemarcarConsultaDTO {

    private Long idConsulta;

    private OffsetDateTime dataRemarcada;

    public RemarcarConsultaDTO() {
    }

    public RemarcarConsultaDTO(Long idConsulta, OffsetDateTime dataRemarcada) {
        this.idConsulta = idConsulta;
        this.dataRemarcada = dataRemarcada;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public OffsetDateTime getDataRemarcada() {
        return dataRemarcada;
    }

    public void setDataRemarcada(OffsetDateTime dataRemarcada) {
        this.dataRemarcada = dataRemarcada;
    }
}
