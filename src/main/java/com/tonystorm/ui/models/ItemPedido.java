package com.tonystorm.ui.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
    private Long id;
    private Comida comida;
    private int quantidade;
    private Double subTotal;
}
