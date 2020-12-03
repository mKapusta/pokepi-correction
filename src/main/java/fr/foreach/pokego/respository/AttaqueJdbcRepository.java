package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Attaque;

import java.util.List;

public interface AttaqueJdbcRepository {

    List<Attaque> getAllAttaquesByPokemonId(Integer pokemonId);
}
