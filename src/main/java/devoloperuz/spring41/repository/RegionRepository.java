package devoloperuz.spring41.repository;

import devoloperuz.spring41.entity.Region;
import devoloperuz.spring41.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Intelligent
 * Date: 05.11.2022
 * Time: 20:15
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findAllBy(Role role);
}
