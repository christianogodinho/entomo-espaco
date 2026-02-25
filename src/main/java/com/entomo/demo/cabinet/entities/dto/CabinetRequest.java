package com.entomo.demo.cabinet.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabinetRequest {

    @NotBlank(message = "O campo 'name' é obrigatório.")
    @Size(min = 8, max=50)
    private String name;

    @NotBlank(message = "O campo 'description' é obrigatório.")
    @Size(min = 8, max=150)
    private String description;

    @NotBlank(message = "O campo 'totalDrawers' é obrigatório.")
    @Size(min = 1, max=40)
    private Integer totalDrawers;
}
