package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.PokemonDto;
import fr.foreach.pokego.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonControllerTest {

    @Mock
    private PokemonService pokemonService;
    @InjectMocks
    private PokemonController pokemonController;

    @Test
    void getAllpokemons_returnsListPokemonDto() {
        PokemonDto pokemonDto = new PokemonDto();
        when(pokemonService.getAllPokemons()).thenReturn(List.of(pokemonDto));
        assertThat(pokemonController.getAllPokemons()).isEqualTo(List.of(pokemonDto));
        verify(pokemonService).getAllPokemons();
    }

    @Test
    void getById_returnsPokemonDto() {
        PokemonDto pokemonDto = new PokemonDto();
        when(pokemonService.getPokemonById(1)).thenReturn(pokemonDto);
        assertThat(pokemonController.getById(1)).isEqualTo(pokemonDto);
        verify(pokemonService).getPokemonById(1);
    }

    @Test
    void createPokemon_returnsPokemonDto() {
        PokemonDto pokemonDto = new PokemonDto();
        when(pokemonService.createPokemon(pokemonDto)).thenReturn(pokemonDto);
        assertThat(pokemonController.createPokemon(pokemonDto)).isEqualTo(pokemonDto);
        verify(pokemonService).createPokemon(pokemonDto);
    }

    @Test
    void editPokemon_returnsPokemonDto() {
        PokemonDto pokemonDto = new PokemonDto();
        when(pokemonService.editPokemon(pokemonDto)).thenReturn(pokemonDto);
        assertThat(pokemonController.editPokemon(1 , pokemonDto)).isEqualTo(pokemonDto);
        verify(pokemonService).editPokemon(pokemonDto);
    }


    @Test
    void deletePokemon_returnsNothing() {
        pokemonController.deletePokemon(1);
        verify(pokemonService).deletePokemon(1);
    }
}
