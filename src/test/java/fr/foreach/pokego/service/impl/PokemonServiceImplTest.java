package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.PokemonDto;
import fr.foreach.pokego.entity.Pokemon;
import fr.foreach.pokego.exception.PokemonNotFoundException;
import fr.foreach.pokego.respository.PokemonJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceImplTest {

    @Mock
    private PokemonJpaRepository pokemonJpaRepository;

    @InjectMocks
    private PokemonServiceImpl pokemonServiceImpl;

    @Test
    void getAllPokemons_returnsListPokemonDto() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        when(pokemonJpaRepository.findAll()).thenReturn(List.of(pokemon));
        List<PokemonDto> pokemons = pokemonServiceImpl.getAllPokemons();
        assertThat(pokemons).hasSize(1);
        assertThat(pokemons.get(0).getId()).isEqualTo(1);

        verify(pokemonJpaRepository).findAll();
    }

    @Test
    void getPokemonById_returnsPokemonDto() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        when(pokemonJpaRepository.findById(1)).thenReturn(Optional.of(pokemon));
        assertThat(pokemonServiceImpl.getPokemonById(1).getId()).isEqualTo(1);
        verify(pokemonJpaRepository).findById(1);
    }

    @Test
    void getPokemonById_throwsException_WhenPokemonDoesNotExist() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        when(pokemonJpaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(PokemonNotFoundException.class, () -> pokemonServiceImpl.getPokemonById(1));
        verify(pokemonJpaRepository).findById(1);
    }

    @Test
    void createPokemon_returnsPokemonDto() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        when(pokemonJpaRepository.save(any(Pokemon.class))).thenReturn(pokemon);
        assertThat(pokemonServiceImpl.createPokemon(new PokemonDto()).getId()).isEqualTo(1);
        verify(pokemonJpaRepository).save(any(Pokemon.class));
    }

    @Test
    void editPokemon_returnsPokemonDto() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        when(pokemonJpaRepository.save(any(Pokemon.class))).thenReturn(pokemon);
        assertThat(pokemonServiceImpl.editPokemon(new PokemonDto()).getId()).isEqualTo(1);
        verify(pokemonJpaRepository).save(any(Pokemon.class));
    }

    @Test
    void deletePokemon_returnsNothing() {
        pokemonServiceImpl.deletePokemon(1);
        verify(pokemonJpaRepository).deleteById(1);
    }
}
