package com.tonystorm.ui.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private UUID id;
    private Usuario usuario;
    private List<Comida> comidas;
    private Double precoTotal;
    private Double distancia;
    private String status;
}