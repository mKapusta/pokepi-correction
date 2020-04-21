package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Attaque;
import org.springframework.data.repository.CrudRepository;

public interface AttaqueJpaRepository extends CrudRepository<Attaque, Integer> {

}
