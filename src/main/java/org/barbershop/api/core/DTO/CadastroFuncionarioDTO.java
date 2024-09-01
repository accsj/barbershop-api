package org.barbershop.api.core.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.barbershop.api.core.entity.Especialidade;

import java.time.LocalDate;
import java.util.List;

public class CadastroFuncionarioDTO extends CadastroUsuarioDTO {

    private Long idFuncionario;

    @NotBlank
    private String rgcpf;

    private List<String> especialidade;

    public CadastroFuncionarioDTO() {
    }

    public CadastroFuncionarioDTO(Long id, String nomeCompleto, String email, String celular, LocalDate dataNascimento, String senha, CadastroEnderecoDTO endereco, Long idFuncionario, String rgcpf, List<String> especialidade) {
        super(id, nomeCompleto, email, celular, dataNascimento, senha, endereco);
        this.idFuncionario = idFuncionario;
        this.rgcpf = rgcpf;
        this.especialidade = especialidade;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public @NotBlank String getRgcpf() {
        return rgcpf;
    }

    public void setRgcpf(@NotBlank String rgcpf) {
        this.rgcpf = rgcpf;
    }

    public List<String> getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List<String> especialidade) {
        this.especialidade = especialidade;
    }
}
