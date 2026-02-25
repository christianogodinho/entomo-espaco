package com.entomo.demo.cabinet.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabinetResponse {

    private Integer id;
    private String name;
    private String description;
    private Integer totalDrawers;
}
