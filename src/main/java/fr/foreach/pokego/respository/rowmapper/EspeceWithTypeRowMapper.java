package fr.foreach.pokego.respository.rowmapper;

import fr.foreach.pokego.entity.Espece;
import fr.foreach.pokego.entity.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EspeceWithTypeRowMapper implements RowMapper<Espece> {

    @Override
    public Espece mapRow(ResultSet resultSet, int i) throws SQLException {
        Espece espece = new Espece();
        espece.setId(resultSet.getInt("ESPECE_ID"));
        espece.setPokedex(resultSet.getInt("POKEDEX"));
        espece.setNom(resultSet.getString("ESPECE_NOM"));
        espece.setTypePrincipal(new Type());
        espece.getTypePrincipal().setId(resultSet.getInt("TYPE_PRINCIPAL_ID"));
        espece.getTypePrincipal().setNom(resultSet.getString("TYPE_PRINCIPAL_NOM"));
        espece.setTypeSecondaire(new Type());
        espece.getTypeSecondaire().setId(resultSet.getInt("TYPE_SECONDAIRE_ID"));
        espece.getTypeSecondaire().setNom(resultSet.getString("TYPE_SECONDAIRE_NOM"));
        return espece;
    }
}
