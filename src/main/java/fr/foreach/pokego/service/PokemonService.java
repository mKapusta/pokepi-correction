package fr.foreach.pokego.service;

import fr.foreach.pokego.dto.PokemonDto;
import fr.foreach.pokego.dto.PokemonInTeamDto;

import java.util.List;

/**
 * The interface Pokemon service.
 */
public interface PokemonService {
    /**
     * Gets all pokemons.
     *
     * @return the all pokemons
     */
    List<PokemonDto> getAllPokemons();

    /**
     * Gets pokemon by id.
     *
     * @param id the id
     * @return the pokemon by id
     */
    PokemonDto getPokemonById(Integer id);

    /**
     * Gets pokemon by dresseur id.
     *
     * @param dresseurId the dresseur id
     * @return the pokemon by dresseur id
     */
    List<PokemonInTeamDto> getPokemonByDresseurId(Integer dresseurId);

    /**
     * Create pokemon pokemon dto.
     *
     * @param pokemonDto the pokemon dto
     * @return the pokemon dto
     */
    PokemonDto createPokemon(PokemonDto pokemonDto);

    /**
     * Edit pokemon pokemon dto.
     *
     * @param pokemonDto the pokemon dto
     * @return the pokemon dto
     */
    PokemonDto editPokemon(PokemonDto pokemonDto);

    /**
     * Delete pokemon.
     *
     * @param id the id
     */
    void deletePokemon(Integer id);
}
