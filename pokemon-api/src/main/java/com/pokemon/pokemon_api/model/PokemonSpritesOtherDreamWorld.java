package com.pokemon.pokemon_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonSpritesOtherDreamWorld {
    @JsonProperty(value="dream_world")
    private PokemonSpritesOtherDreamWorldFrontDefault otherDreamWorld;
}
