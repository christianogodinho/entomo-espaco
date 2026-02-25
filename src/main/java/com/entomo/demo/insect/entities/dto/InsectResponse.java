package com.entomo.demo.insect.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsectResponse {

    private Integer id;
    private Integer collectionItemId;
    private String binomial;
    private String family;
    private String gender;
    private String specie;
    private String subSpecie;
    private String sex;
    private OffsetDateTime collectDate;
    private String placeOfOrigin;
}
