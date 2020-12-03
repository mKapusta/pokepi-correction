package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Pokemon jpa repository.
 */
public interface PokemonJpaRepository extends CrudRepository<Pokemon, Integer> {

    /**
     * Find all by dresseur id list.
     *
     * @param id the id
     * @return the list
     */
    List<Pokemon> findAllByDresseur_Id(Integer id);

}
