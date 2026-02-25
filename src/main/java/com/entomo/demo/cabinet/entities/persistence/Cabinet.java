package com.entomo.demo.cabinet.entities.persistence;

import com.entomo.demo.generic.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cabinet")
public class Cabinet implements GenericEntity<Cabinet> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(name = "total_drawers", nullable = false)
    private Integer totalDrawers;

}
