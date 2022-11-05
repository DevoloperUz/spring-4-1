package devoloperuz.spring41.service.impl;

import devoloperuz.spring41.entity.Region;
import devoloperuz.spring41.entity.Role;
import devoloperuz.spring41.repository.RoleRepository;
import devoloperuz.spring41.repository.RegionRepository;
import devoloperuz.spring41.rest.dto.RoleDto;
import devoloperuz.spring41.rest.response.Response;
import devoloperuz.spring41.rest.response.RoleResponse;
import devoloperuz.spring41.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Intelligent
 * Date: 04.11.2022
 * Time: 14:22
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RegionRepository regionRepository;

    public RoleServiceImpl(RoleRepository roleRepository, RegionRepository regionRepository) {
        this.roleRepository = roleRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public Response save(RoleDto dto) {
        Role role = new Role();
        role.setRoleName(dto.getRoleName());
        role.setDescription(dto.getDescription());
        roleRepository.save(role);
        return new Response(true, "Role successfully created!");
    }

    @Override
    public Response findAll() {
        List<Role> roleList = roleRepository.findAll();
        List<RoleResponse> resultList = new ArrayList<>();
        for (Role role : roleList) {
            RoleResponse roleResponse =
                    new RoleResponse(
                            role.getId(),
                            role.getRoleName(),
                            role.getDescription());
            resultList.add(roleResponse);
        }
        return new Response(true, "Role list", resultList);
    }

    @Override
    public Response findById(Long id) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            Role role = optional.get();
            RoleResponse response = new RoleResponse(
                    role.getId(),
                    role.getRoleName(),
                    role.getDescription()
            );
            return new Response(true, "Role with id {"+ id +"}");
        }
        return new Response(false, "Role not found with id {"+ id +"}!", HttpStatus.NOT_FOUND);
    }

    @Override
    public Response edit(Long id, RoleDto dto) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            Role entity = optional.get();
            if (dto.getRoleName() != null && !dto.getRoleName().equals(entity.getRoleName()))
                entity.setRoleName(dto.getRoleName());
            if (dto.getDescription() != null && !dto.getDescription().equals(entity.getDescription()))
                entity.setDescription(dto.getDescription());
            roleRepository.save(entity);
            return new Response(true, "Role successfully changed!");
        }
        return new Response(false, "Role not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public Response delete(Long id) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            Role entity = optional.get();

            List<Region> regionList = regionRepository.findAllBy(entity);
            for (Region region : regionList) {
                regionRepository.delete(region);
            }
        }
        return new Response(true, "Region successfully deleted!");
    }
}
