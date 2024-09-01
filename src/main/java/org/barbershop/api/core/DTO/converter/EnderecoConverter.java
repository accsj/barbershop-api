package org.barbershop.api.core.DTO.converter;

import org.barbershop.api.core.DTO.EnderecoDTO;
import org.barbershop.api.core.entity.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoConverter {

    public List<EnderecoDTO> toListagemEnderecoDTO(List<Endereco> enderecos) {
        if (enderecos == null) return null;
        return enderecos.stream()
                .map(endereco -> new EnderecoDTO (
                        endereco.getId(),
                        endereco.getEstado(),
                        endereco.getCidade(),
                        endereco.getBairro(),
                        endereco.getNumero(),
                        endereco.getComplemento(),
                        endereco.getCep()
                ))
                .collect(Collectors.toList());
    }
}
