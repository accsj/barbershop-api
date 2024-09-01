package org.barbershop.api.core.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.barbershop.api.core.DTO.CadastroFuncionarioDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "funcionario")
@Entity
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rgcpf;

    @Column(name = "data_contratado", nullable = false)
    private LocalDate dataContratado;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany
    @JoinTable(name = "funcionarios_especialidade", joinColumns = @JoinColumn(name = "id_funcionario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidade", referencedColumnName = "id"))
    private List<Especialidade> especialidades;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;

    public Funcionario() {
    }

    public Funcionario(CadastroFuncionarioDTO dados, Usuario usuario) {
        this.rgcpf = dados.getRgcpf();
        this.dataContratado = LocalDate.now();
        this.usuario = usuario;
        this.especialidades = especialidades != null ? especialidades : new ArrayList<>();
        this.consultas = consultas != null ? consultas : new ArrayList<>();
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidade) {
        this.especialidades = especialidade;
    }
}
