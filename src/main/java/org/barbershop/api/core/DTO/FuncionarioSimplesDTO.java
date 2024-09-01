package org.barbershop.api.core.DTO;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioSimplesDTO {

    private Long id;

    private String rgcpf;

    private LocalDate dataContratado;

    private List<EspecialidadeDTO> especialidades;

    public FuncionarioSimplesDTO() {
    }

    public FuncionarioSimplesDTO(Long id, String rgcpf, LocalDate dataContratado, List<EspecialidadeDTO> especialidades) {
        this.id = id;
        this.rgcpf = rgcpf;
        this.dataContratado = dataContratado;
        this.especialidades = especialidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRgcpf() {
        return rgcpf;
    }

    public void setRgcpf(String rgcpf) {
        this.rgcpf = rgcpf;
    }

    public LocalDate getDataContratado() {
        return dataContratado;
    }

    public void setDataContratado(LocalDate dataContratado) {
        this.dataContratado = dataContratado;
    }

    public List<EspecialidadeDTO> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<EspecialidadeDTO> especialidades) {
        this.especialidades = especialidades;
    }
}
