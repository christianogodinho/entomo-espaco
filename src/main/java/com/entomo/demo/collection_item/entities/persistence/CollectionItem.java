package com.entomo.demo.collection_item.entities.persistence;

import com.entomo.demo.drawer.entities.persistence.Drawer;
import com.entomo.demo.generic.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="collection_item")
public class CollectionItem implements GenericEntity<CollectionItem> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String collectionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="drawer_id", nullable = false)
    private Drawer drawer;
}
