package org.barbershop.api.core.DTO.converter;

import org.barbershop.api.core.DTO.*;
import org.barbershop.api.core.entity.Cliente;
import org.barbershop.api.core.entity.Usuario;

public class ClienteConverter {

    private static final UsuarioConverter usuarioConverter = new UsuarioConverter();
    private static final ConsultaConverter consultaConverter = new ConsultaConverter();

    public ListagemClienteDTO toListagemClienteDTO(Cliente cliente) {
        Usuario usuario = cliente.getUsuario();
        if (usuario == null) {
            throw new IllegalArgumentException("Cliente não tem um usuário associado: " + cliente.getId());
        }

        return new ListagemClienteDTO (
            usuarioConverter.toListagemUsuarioDTO(usuario)
        );
    }

    public ClienteDTO toClienteDTO(Cliente cliente) {
        Usuario usuario = cliente.getUsuario();
        if (usuario == null) {
            throw new IllegalArgumentException("Cliente não tem um usuário associado: " + cliente.getId());
        }

        return new ClienteDTO (
                cliente.getId(),
                cliente.getTipoContrato(),
                consultaConverter.toListConsultaSimplesDTO(cliente.getConsultas())
        );
    }

    public ClienteSimplesDTO toClienteSimplesDTO(Cliente cliente) {
        Usuario usuario = cliente.getUsuario();
        if (usuario == null) {
            throw new IllegalArgumentException("Cliente não tem um usuário associado: " + cliente.getId());
        }

        return new ClienteSimplesDTO (
                cliente.getId(),
                cliente.getTipoContrato()
        );
    }
}
