package com.pokemon.pokemon_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Other {

    @JsonProperty(value="dream_world")
    private DreamWorld dreamWorld;
}
