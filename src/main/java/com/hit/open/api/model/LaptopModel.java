package com.hit.open.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopModel {
    @NonNull
    @Size(max = 1 , min = 20)
    private Integer id;
    @NotBlank
    private String name;

    private String company;
    private Integer price;
    private Integer ram;
}
