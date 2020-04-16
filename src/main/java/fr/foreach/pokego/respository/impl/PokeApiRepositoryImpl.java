package fr.foreach.pokego.respository.impl;

import fr.foreach.pokego.dto.PokeApiResponse;
import fr.foreach.pokego.respository.PokeApiRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokeApiRepositoryImpl implements PokeApiRepository {

    @Value("${pokeapi.url}")
    private String apiUrl;

    @Override
    public String getEspeceSprite(Integer pokedexId) {
        RestTemplate restTemplate = new RestTemplate();
        PokeApiResponse response
                = restTemplate.getForObject(apiUrl + "/" + pokedexId, PokeApiResponse.class);
        return response.getSprites().getFront_default();
    }

}
