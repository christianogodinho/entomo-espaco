package com.entomo.demo.insect.entities.persistence;

import com.entomo.demo.collection_item.entities.persistence.CollectionItem;
import com.entomo.demo.generic.GenericEntity;
import com.entomo.demo.insect.InsectController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="insect")
public class Insect implements GenericEntity<Insect> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_item", nullable = false)
    private CollectionItem collectionItem;

    @Column(nullable = false, length = 50)
    private String binomial;

    @Column(nullable = false, length = 50)
    private String family;

    @Column(nullable = false, length = 50)
    private String gender;

    @Column(nullable = false, length = 50)
    private String specie;

    @Column(nullable = false, length = 50)
    private String subSpecie;

    @Column(nullable = false, length = 1)
    private String sex;

    @Column(nullable = false)
    private OffsetDateTime collectDate;

    @Column(nullable = false, length = 50)
    private String placeOfOrigin;

}
