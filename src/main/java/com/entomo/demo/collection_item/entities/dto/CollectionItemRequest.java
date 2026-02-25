package com.entomo.demo.collection_item.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionItemRequest {

    @NotBlank(message = "O campo 'drawerId' é obrigatório.")
    private Integer drawerId;

    @NotBlank(message = "O campo 'collection_type' é obrigatório.")
    @Size(min=8, max=50)
    private String collectionType;
}
