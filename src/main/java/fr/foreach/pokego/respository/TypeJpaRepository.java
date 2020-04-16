package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeJpaRepository extends CrudRepository<Type, Integer> {

}
