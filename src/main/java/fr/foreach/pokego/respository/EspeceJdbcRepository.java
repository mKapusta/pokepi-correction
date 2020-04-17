package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Espece;

public interface EspeceJdbcRepository {

    Espece getByIdWithTypes(Integer Id);
}
