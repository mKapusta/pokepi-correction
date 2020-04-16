package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Espece;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EspeceJpaRepository extends CrudRepository<Espece, Integer> {

    List<Espece> findByNom(String nom);

    List<Espece> findByTypePrincipal_Id(Integer typeId);
}
