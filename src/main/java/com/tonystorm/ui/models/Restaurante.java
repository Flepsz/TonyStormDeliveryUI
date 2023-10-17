package com.tonystorm.ui.models;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurante {
    private UUID id;
    private String nome;
    private String senha;
    private String CNPJ;
    private Localizacao localizacao;
    private List<Comida> comidas;
}
