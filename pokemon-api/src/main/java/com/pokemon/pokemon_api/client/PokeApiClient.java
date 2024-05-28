package com.pokemon.pokemon_api.client;

import com.pokemon.pokemon_api.model.PokemonModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface PokeApiClient {

    @GetExchange("/pokemon/{id}")
    PokemonModel getPokemonForID(@PathVariable(name = "id") Integer pokemonID);

}
