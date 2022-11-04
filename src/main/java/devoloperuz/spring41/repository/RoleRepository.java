package devoloperuz.spring41.repository;

import devoloperuz.spring41.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Intelligent
 * Date: 04.11.2022
 * Time: 14:46
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
