package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurJpaRepository extends CrudRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByLogin(String username);
}
