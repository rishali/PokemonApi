package com.pokemon.pokemon_api.model;

import lombok.Data;
import lombok.val;

import java.lang.reflect.Constructor;

@Data
public class PokemonModel {

    private Integer id;

    private String name;

    private String imgSrc="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/132.svg";

}
