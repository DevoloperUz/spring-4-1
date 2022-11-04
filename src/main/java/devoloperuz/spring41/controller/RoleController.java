package devoloperuz.spring41.controller;

import devoloperuz.spring41.rest.dto.RoleDto;
import devoloperuz.spring41.rest.response.Response;
import devoloperuz.spring41.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Intelligent
 * Date: 04.11.2022
 * Time: 14:13
 */
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Response save(@RequestBody RoleDto dto) {
        return service.save(dto);
    }
}
