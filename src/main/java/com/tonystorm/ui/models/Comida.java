package com.tonystorm.ui.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comida {
    private UUID id;
    private String nome;
    private Double preco;
    private Restaurante restaurante;
}
