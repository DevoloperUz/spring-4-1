package devoloperuz.spring41.controller;

import devoloperuz.spring41.rest.dto.RoleDto;
import devoloperuz.spring41.rest.response.Response;
import devoloperuz.spring41.service.RoleService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public Response findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}/by_id")
    public Response findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}/update")
    public Response edit(@PathVariable Long id,@RequestBody RoleDto dto) {
        return service.edit(id, dto);
    }

    @DeleteMapping("/{id}/delete")
    public Response delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
