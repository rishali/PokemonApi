package com.pokemon.pokemon_api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonVerificationModel {
    Integer id;
    String name;
    Boolean isPokemonAMatch;
}
