package org.barbershop.api.core.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.barbershop.api.core.entity.Especialidade;
import org.barbershop.api.core.entity.Role;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FuncionarioDTO {

    private Long id;

    private String rgcpf;

    private LocalDate dataContratado;

    private List<EspecialidadeDTO> especialidades;

    private List<ConsultaSimplesDTO> consultas;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Long id, String rgcpf, LocalDate dataContratado, List<EspecialidadeDTO> especialidades, List<ConsultaSimplesDTO> consultas) {
        this.id = id;
        this.rgcpf = rgcpf;
        this.dataContratado = dataContratado;
        this.especialidades = especialidades;
        this.consultas = consultas;
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

    public List<ConsultaSimplesDTO> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaSimplesDTO> consultas) {
        this.consultas = consultas;
    }
}
