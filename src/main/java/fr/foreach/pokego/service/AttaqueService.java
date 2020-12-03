package fr.foreach.pokego.service;

import fr.foreach.pokego.dto.AttaqueDto;

import java.util.List;

public interface AttaqueService {
    List<AttaqueDto> getAllAttaques(String type);

    AttaqueDto getAttaqueById(Integer id);

    AttaqueDto createAttaque(AttaqueDto attaqueDto);

    AttaqueDto editAttaque(AttaqueDto attaqueDto);

    List<AttaqueDto> getAllAttaquesByPokemonId(Integer pokemonId);

    AttaqueDto updateAttaquePuissance(Integer id, AttaqueDto attaque);

    void deleteAttaque(Integer id);
}
