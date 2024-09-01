package org.barbershop.api.core.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.barbershop.api.core.DTO.CadastroClienteDTO;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cliente")
@Entity
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_contrato", nullable = false)
    private Integer tipoContrato;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;

    public Cliente() {
    }

    public Cliente(CadastroClienteDTO dados, Usuario usuario) {
        this.tipoContrato = dados.getTipoContrato();
        this.usuario = usuario;
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

    public Integer getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(Integer tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
