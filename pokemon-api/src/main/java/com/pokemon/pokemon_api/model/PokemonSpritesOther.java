package com.pokemon.pokemon_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonSpritesOther {

    @JsonProperty(value = "other")
    private PokemonSpritesOtherDreamWorld SpritesOther;
}
