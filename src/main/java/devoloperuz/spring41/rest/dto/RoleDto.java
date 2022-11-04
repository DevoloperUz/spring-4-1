package devoloperuz.spring41.rest.dto;

import devoloperuz.spring41.entity.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Intelligent
 * Date: 04.11.2022
 * Time: 14:40
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoleDto {
    private RoleName roleName;
    private String description;
}
