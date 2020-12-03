package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TypeJpaRepository extends CrudRepository<Type, Integer> {

    Optional<Type> findByNom(String nom);
}
