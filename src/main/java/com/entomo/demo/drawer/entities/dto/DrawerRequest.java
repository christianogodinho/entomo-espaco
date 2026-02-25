package com.entomo.demo.drawer.entities.dto;

import com.entomo.demo.cabinet.entities.persistence.Cabinet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawerRequest {

    @NotBlank(message = "O campo 'name' é obrigatório.")
    @Size(min = 8, max=50)
    private String name;

    @NotBlank(message = "O campo 'description' é obrigatório.")
    @Size(min = 8, max=150)
    private String description;

    @NotBlank(message = "O campo 'cabinetId' é obrigatório.")
    private Integer cabinetId;

    @NotBlank(message = "O campo 'family' é obrigatório.")
    @Size(min = 8, max=30)
    private String family;

    @NotBlank(message = "O campo 'gender' é obrigatório.")
    @Size(min = 8, max=30)
    private String gender;
}
