package fr.foreach.pokego.respository;

import fr.foreach.pokego.entity.Type;

import java.util.List;

public interface TypeJdbcRepository {

    Type getById(Integer id);

    List<Type> searchByNom(Integer id);

    List<Type> getAll();

    Integer createType(Type type);

    void editType(Type type);

    void deleteType(Integer id);
}
