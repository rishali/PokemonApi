package com.pokemon.pokemon_api.config;

import com.pokemon.pokemon_api.client.PokeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class ApiClientConfig {

    @Bean
    public PokeApiClient pokemonClient(@Autowired RestTemplate restTemplate) {
        RestTemplateAdapter adapter = RestTemplateAdapter.create(restTemplate);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(PokeApiClient.class);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://pokeapi.co/api/v2"));
        return restTemplate;
    }
}
