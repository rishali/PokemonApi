package com.pokemon.pokemon_api.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonQuestionModel {
    private Integer id;
    private String imgSrc;
    private List<String> options;
}
