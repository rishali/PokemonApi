package com.pokemon.pokemon_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DreamWorld {

    @JsonProperty(value="front_default")
    private String frontDefault;
}
