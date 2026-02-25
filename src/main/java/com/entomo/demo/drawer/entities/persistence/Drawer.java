package com.entomo.demo.drawer.entities.persistence;

import com.entomo.demo.cabinet.entities.persistence.Cabinet;
import com.entomo.demo.generic.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="drawer", uniqueConstraints = @UniqueConstraint(
        columnNames = {"name", "cabinet_id"}
))
public class Drawer implements GenericEntity<Drawer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cabinet_id", nullable = false)
    private Cabinet cabinet;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, length = 50)
    private String family;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false)
    private Integer totalItems;
}
