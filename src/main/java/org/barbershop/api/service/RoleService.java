package org.barbershop.api.service;

import org.barbershop.api.core.entity.Role;

public interface RoleService {
    Role findByNome(String nome);
}
