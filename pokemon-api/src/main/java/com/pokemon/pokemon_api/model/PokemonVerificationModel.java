package com.pokemon.pokemon_api.model;

import lombok.Data;

@Data
public class PokemonVerificationModel {
    Integer id;
    String name;
    Boolean isPokemonAMatch;
}
