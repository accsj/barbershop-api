package org.barbershop.api.core.DTO.converter;

import org.barbershop.api.core.DTO.ClienteDTO;
import org.barbershop.api.core.DTO.FuncionarioDTO;
import org.barbershop.api.core.DTO.ListagemUsuarioDTO;
import org.barbershop.api.core.DTO.UsuarioDTO;
import org.barbershop.api.core.entity.Usuario;

public class UsuarioConverter {

    private static final ClienteConverter clienteConverter = new ClienteConverter();
    private static final EnderecoConverter enderecoConverter = new EnderecoConverter();
    private static final FuncionarioConverter funcionarioConverter = new FuncionarioConverter();


    public ListagemUsuarioDTO toListagemUsuarioDTO(Usuario usuario) {

        ClienteDTO clienteDTO = usuario.getCliente() != null
                ? clienteConverter.toClienteDTO(usuario.getCliente())
                : null;

        FuncionarioDTO funcionarioDTO = usuario.getFuncionario() != null
                ? funcionarioConverter.toFuncionarioDTO(usuario.getFuncionario())
                : null;

        return new ListagemUsuarioDTO(
                usuario.getId(),
                usuario.getNomeCompleto(),
                usuario.getEmail(),
                usuario.getCelular(),
                usuario.getDataNascimento(),
                usuario.getEmailVerificado(),
                usuario.getAtivo(),
                usuario.getRole(),
                clienteDTO,
                funcionarioDTO,
                enderecoConverter.toListagemEnderecoDTO(usuario.getEnderecos())
        );
    }

    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNomeCompleto(),
                usuario.getEmail(),
                usuario.getCelular(),
                usuario.getDataNascimento(),
                usuario.getEmailVerificado(),
                usuario.getAtivo(),
                usuario.getRole()
        );
    }
}