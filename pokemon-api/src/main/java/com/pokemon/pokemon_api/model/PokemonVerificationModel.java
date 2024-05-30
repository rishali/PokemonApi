package com.pokemon.pokemon_api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonVerificationModel {
    String name;
    String imgSrc;
    Boolean isPokemonAMatch;
}
