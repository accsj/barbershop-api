package org.barbershop.api.service.impl;

import org.barbershop.api.core.entity.Role;
import org.barbershop.api.core.repository.RoleRepository;
import org.barbershop.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role findByNome(String nome) {
        return repository.findByNome(nome);
    }
}
