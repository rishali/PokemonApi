package com.pokemon.pokemon_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.json.JSONObject;

@Data
public class PokemonSpritesOtherDreamWorldFrontDefault {

    @JsonProperty(value="front_default")
    private String frontDefault;
}
