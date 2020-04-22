package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.PokemonDto;
import fr.foreach.pokego.exception.PokemonNotFoundException;
import fr.foreach.pokego.respository.PokemonJpaRepository;
import fr.foreach.pokego.service.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonJpaRepository pokemonJpaRepository;

    public PokemonServiceImpl(PokemonJpaRepository pokemonJpaRepository) {
        this.pokemonJpaRepository = pokemonJpaRepository;
    }

    @Override
    public List<PokemonDto> getAllPokemons() {
        return StreamSupport.stream(pokemonJpaRepository.findAll().spliterator(), false)
                .map(PokemonDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDto getPokemonById(Integer id) {
        return new PokemonDto(pokemonJpaRepository.findById(id).orElseThrow(PokemonNotFoundException::new));
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        return new PokemonDto(pokemonJpaRepository.save(pokemonDto.toPokemon()));
    }

    @Override
    public PokemonDto editPokemon(PokemonDto pokemonDto) {
        return new PokemonDto(pokemonJpaRepository.save(pokemonDto.toPokemon()));
    }

    @Override
    public void deletePokemon(Integer id) {
        pokemonJpaRepository.deleteById(id);
    }

}
