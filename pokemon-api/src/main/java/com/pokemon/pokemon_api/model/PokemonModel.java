package com.pokemon.pokemon_api.model;

import lombok.Data;

@Data
public class PokemonModel {

    private Integer id;

    private String name;

    private PokemonSprites sprites;

}
