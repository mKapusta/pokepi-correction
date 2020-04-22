package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.PokemonDto;
import fr.foreach.pokego.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<PokemonDto> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/{id}")
    public PokemonDto getById(@PathVariable Integer id) {
        return pokemonService.getPokemonById(id);
    }

    @PostMapping
    public PokemonDto createPokemon(@RequestBody PokemonDto pokemonDto) {
        return pokemonService.createPokemon(pokemonDto);
    }

    @PutMapping("/{id}")
    public PokemonDto editPokemon(@PathVariable Integer id, @RequestBody PokemonDto pokemonDto) {
        pokemonDto.setId(id);
        return pokemonService.editPokemon(pokemonDto);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Integer id) {
        pokemonService.deletePokemon(id);
    }
}
