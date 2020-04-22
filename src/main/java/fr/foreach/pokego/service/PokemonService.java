package fr.foreach.pokego.service;

import fr.foreach.pokego.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    List<PokemonDto> getAllPokemons();

    PokemonDto getPokemonById(Integer id);

    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonDto editPokemon(PokemonDto pokemonDto);

    void deletePokemon(Integer id);
}
