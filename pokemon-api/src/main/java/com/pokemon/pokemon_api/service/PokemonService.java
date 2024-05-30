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

import static com.pokemon.pokemon_api.util.Utils.generateRandomIDWithinBounds;

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
        ArrayList<Integer> optionIDList = new ArrayList<>(optionIDs);
        List<String> optionNames = optionIDList.stream().map(id -> pokeApiClient.getPokemonForID(id).getName()).collect(Collectors.toList());

        int selectedIdFromOptions = optionIDList.get(ThreadLocalRandom.current().nextInt(optionIDs.size()));

        PokemonModel selectedPokemon = pokeApiClient.getPokemonForID(selectedIdFromOptions);

        PokemonQuestionModel ques = new PokemonQuestionModel();

        ques.setId(selectedIdFromOptions);
        ques.setImgSrc(selectedPokemon.getSprites().getOther().getDreamWorld().getFrontDefault());
        ques.setOptions(optionNames);
        return ques;
    }

    public PokemonVerificationModel verifyPokemon(Integer actualId, String selectedName) {
        String actualName = pokeApiClient.getPokemonForID(actualId).getName();
        PokemonModel actualPokemon = pokeApiClient.getPokemonForID(actualId);
        String actualImg = actualPokemon.getSprites().getOther().getDreamWorld().getFrontDefault();
        return PokemonVerificationModel.builder()
                .name(actualName)
                .imgSrc(actualImg)
                .isPokemonAMatch(selectedName.equalsIgnoreCase(actualName))
                .build();
    }
}
