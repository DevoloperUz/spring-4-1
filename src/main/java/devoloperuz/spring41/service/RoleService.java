package devoloperuz.spring41.service;

import devoloperuz.spring41.rest.dto.RoleDto;
import devoloperuz.spring41.rest.response.Response;

/**
 * Author: Intelligent
 * Date: 04.11.2022
 * Time: 14:21
 */
public interface RoleService {
    Response save(RoleDto dto);
}
