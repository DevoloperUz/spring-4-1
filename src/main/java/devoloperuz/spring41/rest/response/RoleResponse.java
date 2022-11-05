package devoloperuz.spring41.rest.response;

import devoloperuz.spring41.entity.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Intelligent
 * Date: 05.11.2022
 * Time: 13:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {
    private Long id;
    private RoleName roleName;
    private String description;
}
