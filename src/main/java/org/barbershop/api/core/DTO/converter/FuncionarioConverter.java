package org.barbershop.api.core.DTO.converter;

import org.barbershop.api.core.DTO.FuncionarioDTO;
import org.barbershop.api.core.DTO.FuncionarioSimplesDTO;
import org.barbershop.api.core.DTO.ListagemFuncionarioDTO;
import org.barbershop.api.core.entity.Funcionario;
import org.barbershop.api.core.entity.Usuario;

public class FuncionarioConverter {


    private static final EspecialidadeConverter especialidadeConverter = new EspecialidadeConverter();
    private static final UsuarioConverter usuarioConverter = new UsuarioConverter();
    private static final ConsultaConverter consultaConverter = new ConsultaConverter();

    public ListagemFuncionarioDTO toListagemFuncionarioDTO (Funcionario funcionario) {

        Usuario usuario = funcionario.getUsuario();
        if (usuario == null) {
            throw new IllegalArgumentException("Funcionario não tem um usuario associado: " + funcionario.getId());
        }

        return new ListagemFuncionarioDTO (
                usuarioConverter.toListagemUsuarioDTO(funcionario.getUsuario())
        );
    }

    public FuncionarioDTO toFuncionarioDTO (Funcionario funcionario) {
        Usuario usuario = funcionario.getUsuario();
        if (usuario == null) {
            throw new IllegalArgumentException("Funcionario não tem um usuario associado: " + funcionario.getId());
        }

        return new FuncionarioDTO(
                funcionario.getId(),
                funcionario.getRgcpf(),
                funcionario.getDataContratado(),
                especialidadeConverter.toEspecialidadeDTO(funcionario.getEspecialidades()),
                consultaConverter.toListConsultaSimplesDTO(funcionario.getConsultas())
        );
    }

    public FuncionarioSimplesDTO toFuncionarioSimplesDTO (Funcionario funcionario) {
        Usuario usuario = funcionario.getUsuario();
        if (usuario == null) {
            throw new IllegalArgumentException("Funcionario não tem um usuario associado: " + funcionario.getId());
        }

        return new FuncionarioSimplesDTO(
                funcionario.getId(),
                funcionario.getRgcpf(),
                funcionario.getDataContratado(),
                especialidadeConverter.toEspecialidadeDTO(funcionario.getEspecialidades())
        );
    }
}


