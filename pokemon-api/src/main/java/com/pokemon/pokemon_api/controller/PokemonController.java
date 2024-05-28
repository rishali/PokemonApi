package com.pokemon.pokemon_api.controller;

import com.pokemon.pokemon_api.model.PokemonModel;
import com.pokemon.pokemon_api.model.PokemonQuestionModel;
import com.pokemon.pokemon_api.model.PokemonVerificationModel;
import com.pokemon.pokemon_api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon")
    public PokemonModel getPokemon() {
        return pokemonService.getPokemon();
    }

    @GetMapping("/randomPokemon")
    public PokemonQuestionModel getQuestions(){
        return pokemonService.getQuestion();
    }

    @GetMapping("/verifyPokemon")
    public PokemonVerificationModel verifyPokemon(@RequestParam("actual_id") Integer actualId,
                                                  @RequestParam("selected_name") String selectedName){
        return pokemonService.verifyPokemon(actualId, selectedName);
    }
}
