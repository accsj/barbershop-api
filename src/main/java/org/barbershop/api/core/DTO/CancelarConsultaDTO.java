package org.barbershop.api.core.DTO;

public class CancelarConsultaDTO {

    private Long idConsulta;

    public CancelarConsultaDTO() {
    }

    public CancelarConsultaDTO(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }
}
