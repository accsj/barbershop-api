package org.barbershop.api.core.DTO;

public class ListagemFuncionarioDTO {

    private ListagemUsuarioDTO usuario;


    public ListagemFuncionarioDTO() {
    }

    public ListagemFuncionarioDTO(ListagemUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public ListagemUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(ListagemUsuarioDTO usuario) {
        this.usuario = usuario;
    }

}
