package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Dresseur;
import org.springframework.data.repository.CrudRepository;

public interface DresseurJpaRepository extends CrudRepository<Dresseur, Integer> {

}
