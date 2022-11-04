package devoloperuz.spring41.service.impl;

import devoloperuz.spring41.entity.Role;
import devoloperuz.spring41.repository.RoleRepository;
import devoloperuz.spring41.rest.dto.RoleDto;
import devoloperuz.spring41.rest.response.Response;
import devoloperuz.spring41.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * Author: Intelligent
 * Date: 04.11.2022
 * Time: 14:22
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Response save(RoleDto dto) {
        Role role = new Role();
        role.setRoleName(dto.getRoleName());
        role.setDescription(dto.getDescription());
        Role savedRole = roleRepository.save(role);
        return new Response(true, "Role successfully created!");
    }
}
