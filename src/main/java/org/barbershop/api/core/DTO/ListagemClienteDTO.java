package org.barbershop.api.core.DTO;

public class ListagemClienteDTO {

    private ListagemUsuarioDTO usuario;

    public ListagemClienteDTO() {
    }

    public ListagemClienteDTO(ListagemUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public ListagemUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(ListagemUsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
