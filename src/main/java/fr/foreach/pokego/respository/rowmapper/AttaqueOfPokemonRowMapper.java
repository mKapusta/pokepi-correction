package fr.foreach.pokego.respository.rowmapper;

import fr.foreach.pokego.entity.Attaque;
import fr.foreach.pokego.entity.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttaqueOfPokemonRowMapper implements RowMapper<Attaque> {

    @Override
    public Attaque mapRow(ResultSet resultSet, int i) throws SQLException {
        Attaque attaque = new Attaque();
        attaque.setId(resultSet.getInt("ATTAQUE_ID"));
        attaque.setNom(resultSet.getString("ATTAQUE_NAME"));
        attaque.setPuissance(resultSet.getInt("ATTAQUE_POWER"));
        attaque.setType(new Type());
        attaque.getType().setId(resultSet.getInt("TYPE_ID"));
        attaque.getType().setNom(resultSet.getString("TYPE_NAME"));

        return attaque;
    }
}
