package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Espece;
import org.springframework.data.repository.CrudRepository;

public interface EspeceJpaRepository extends CrudRepository<Espece, Integer> {

}
