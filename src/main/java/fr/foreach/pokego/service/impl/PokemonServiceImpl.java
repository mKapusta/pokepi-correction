package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.AttaqueDto;
import fr.foreach.pokego.dto.PokemonDto;
import fr.foreach.pokego.dto.PokemonInTeamDto;
import fr.foreach.pokego.exception.FullAttaquesException;
import fr.foreach.pokego.exception.FullTeamException;
import fr.foreach.pokego.exception.PokemonNotFoundException;
import fr.foreach.pokego.respository.PokemonJpaRepository;
import fr.foreach.pokego.service.AttaqueService;
import fr.foreach.pokego.service.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonJpaRepository pokemonJpaRepository;
    private AttaqueService attaqueService;

    public PokemonServiceImpl(PokemonJpaRepository pokemonJpaRepository, AttaqueService attaqueService) {
        this.pokemonJpaRepository = pokemonJpaRepository;
        this.attaqueService = attaqueService;
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
    public List<PokemonInTeamDto> getPokemonByDresseurId(Integer dresseurId) {
        return StreamSupport.stream(pokemonJpaRepository.findAllByDresseur_Id(dresseurId).spliterator(), false)
                .map(PokemonInTeamDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        return new PokemonDto(pokemonJpaRepository.save(pokemonDto.toPokemon()));
    }

    @Override
    public PokemonDto editPokemon(PokemonDto pokemonDto) {
        List<PokemonInTeamDto> pokemonOfADresseur = StreamSupport.stream(
                pokemonJpaRepository.findAllByDresseur_Id(pokemonDto.getDresseur().getId()).spliterator(), false)
                .map(PokemonInTeamDto::new)
                .collect(Collectors.toList());
        List<AttaqueDto> attaques = attaqueService.getAllAttaquesByPokemonId(pokemonDto.getId());
        if (pokemonOfADresseur.size() >= 6) {
            throw new FullTeamException();
        }
        if (attaques.size() >= 4) {
            throw new FullAttaquesException();
        }
        return new PokemonDto(pokemonJpaRepository.save(pokemonDto.toPokemon()));
    }

    @Override
    public void deletePokemon(Integer id) {
        pokemonJpaRepository.deleteById(id);
    }

}
