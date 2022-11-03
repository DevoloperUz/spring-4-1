package devoloperuz.spring41.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: Intelligent
 * Date: 03.11.2022
 * Time: 23:07
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "districts")

public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    private Address address;
}
