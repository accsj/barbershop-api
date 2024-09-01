package org.barbershop.api.service;

import org.barbershop.api.core.DTO.CadastroConsultaDTO;
import org.barbershop.api.core.DTO.CancelarConsultaDTO;
import org.barbershop.api.core.DTO.ConsultaDTO;
import org.barbershop.api.core.DTO.RemarcarConsultaDTO;
import org.barbershop.api.core.entity.Cliente;
import org.barbershop.api.core.entity.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

public interface ConsultaService {
    Consulta save(Consulta consulta);
    Optional<Consulta> findById(Long id);
    ConsultaDTO detalhar(Long id);
    URI criarUriConsulta(Long id, UriComponentsBuilder uriBuilder);
    CadastroConsultaDTO cadastrarConsulta(CadastroConsultaDTO dados, UriComponentsBuilder uriBuilder, String authorizationHeader);
    Page<ConsultaDTO> listarTodasConsultas(Pageable page);
    ConsultaDTO remarcarConsulta(RemarcarConsultaDTO dados, String authorizationHeader);
    ConsultaDTO cancelarConsulta(CancelarConsultaDTO dados, String authorizationHeader);
}
