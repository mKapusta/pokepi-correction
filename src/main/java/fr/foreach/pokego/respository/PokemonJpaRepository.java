package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonJpaRepository extends CrudRepository<Pokemon, Integer> {

}
