package com.entomo.demo.insect.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsectRequest {

    @NotBlank(message = "O campo 'collectionItemId' é obrigatório.")
    private Integer collectionItemId;

    @NotBlank(message = "O campo 'binomial' é obrigatório.")
    @Size(min=8, max=50)
    private String binomial;

    @NotBlank(message = "O campo 'family' é obrigatório.")
    @Size(min=8, max=50)
    private String family;

    @NotBlank(message = "O campo 'gender' é obrigatório.")
    @Size(min=8, max=50)
    private String gender;

    @NotBlank(message = "O campo 'specie' é obrigatório.")
    @Size(min=8, max=50)
    private String specie;

    @NotBlank(message = "O campo 'subSpecie' é obrigatório.")
    @Size(min=8, max=50)
    private String subSpecie;

    @NotBlank(message = "O campo 'sex' é obrigatório.")
    @Size(min=1, max=1)
    private String sex;

    @NotBlank(message = "O campo 'collectDate' é obrigatório.")
    private OffsetDateTime collectDate;

    @NotBlank(message = "O campo 'placeOfOrigin' é obrigatório.")
    @Size(min=8, max=50)
    private String placeOfOrigin;

}
