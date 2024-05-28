package com.pokemon.pokemon_api.service;

import com.pokemon.pokemon_api.client.PokeApiClient;
import com.pokemon.pokemon_api.model.PokemonModel;
import com.pokemon.pokemon_api.model.PokemonQuestionModel;
import com.pokemon.pokemon_api.model.PokemonVerificationModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PokemonService {

    @Autowired
    private PokeApiClient pokeApiClient;

    public PokemonModel getPokemon() {
        Integer randomID = generateRandomIDWithinBounds();
        log.info("Generated ID: {}", randomID);
        return pokeApiClient.getPokemonForID(randomID);
    }

    private static Integer generateRandomIDWithinBounds() {
        Random random = new Random();
        return random.ints(1, 51).findFirst().orElseThrow();
    }

    public Set<Integer> getOptions() {
        Set<Integer> optionIDs= new HashSet<Integer>();
        while(optionIDs.size()<4) {
            Integer randomID = generateRandomIDWithinBounds();
            optionIDs.add(randomID);
        }
        return optionIDs;
    }
    public PokemonQuestionModel getQuestion() {
        Set<Integer> optionIDs = getOptions();
        ArrayList<Integer> optionIDlist = new ArrayList<>(optionIDs);
        List<String> optionNames = optionIDlist.stream().map(id -> pokeApiClient.getPokemonForID(id).getName()).collect(Collectors.toList());

        int selectedIdFromOptions = optionIDlist.get(ThreadLocalRandom.current().nextInt(optionIDs.size()));

        PokemonModel selectedPokemon = pokeApiClient.getPokemonForID(selectedIdFromOptions);

        PokemonQuestionModel ques = new PokemonQuestionModel();

        ques.setId(selectedIdFromOptions);
        ques.setImgSrc(String.valueOf(selectedPokemon.getImgSrc()));
        ques.setOptions(optionNames);
        return ques;
    }

    public PokemonVerificationModel verifyPokemon(Integer actualId, String selectedName) {
        String actualName=pokeApiClient.getPokemonForID(actualId).getName();
        PokemonVerificationModel pokemonVerification = new PokemonVerificationModel();
        pokemonVerification.setId(actualId);
        pokemonVerification.setName(actualName);
        pokemonVerification.setIsPokemonAMatch(selectedName.equals(actualName));
        return  pokemonVerification;
    }
}
