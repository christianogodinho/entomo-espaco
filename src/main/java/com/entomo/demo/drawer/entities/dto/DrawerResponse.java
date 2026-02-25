package com.entomo.demo.drawer.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawerResponse {

    private Integer id;
    private Integer cabinetId;
    private String name;
    private String description;
    private String family;
    private String gender;
    private Integer totalItems;
}
