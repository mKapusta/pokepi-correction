package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Attaque;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttaqueJpaRepository extends CrudRepository<Attaque, Integer> {

    Integer countByNom(String nom);

    List<Attaque> findByType_Nom(String nom);

    @Modifying
    @Query("UPDATE Attaque a SET a.puissance =:puissance WHERE a.id=:id")
    Integer updateAttaquePuissance(@Param(value = "puissance") Integer puissance,
                          @Param(value = "id") Integer id);
}
