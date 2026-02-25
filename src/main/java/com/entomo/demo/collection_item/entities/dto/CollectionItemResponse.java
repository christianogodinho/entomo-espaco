package com.entomo.demo.collection_item.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionItemResponse {

    private Integer id;
    private Integer drawerId;
    private String collectionType;
}
