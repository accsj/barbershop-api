package org.barbershop.api.core.DTO;

public class EspecialidadeDTO {

    private Long id;

    private String nome;

    public EspecialidadeDTO() {
    }

    public EspecialidadeDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
