package fr.foreach.pokego.respository.impl;

import fr.foreach.pokego.entity.Espece;
import fr.foreach.pokego.respository.EspeceJdbcRepository;
import fr.foreach.pokego.respository.rowmapper.EspeceWithTypeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EspeceJdbcRepositoryImpl implements EspeceJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public EspeceJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Espece getByIdWithTypes(Integer id) {
        return jdbcTemplate.queryForObject("SELECT E.ID as ESPECE_ID, E.POKEDEX as ESPECE_POKEDEX, E.NOM as ESPECE_NOM," +
                        " TP.ID as TYPE_PRINCIPAL_ID, TP.NOM as TYPE_PRINCIPAL_NOM, " +
                        " TS.ID as TYPE_SECONDAIRE_ID, TS.NOM as TYPE_SECONDAIRE_NOM, " +
                        " BASE.ID as BASE_ID, BASE.NOM as BASE_NOM, BASE.POKEDEX as BASE_POKEDEX " +
                        " FROM ESPECE E " +
                        " INNER JOIN TYPE TP ON E.ID_TYPE_PRINCIPAL = TP.ID" +
                        " INNER JOIN TYPE TS ON E.ID_TYPE_SECONDAIRE = TS.ID" +
                        " INNER JOIN ESPECE BASE ON E.ID_EVOLUTION_DE = BASE.ID" +
                        " WHERE E.ID = ?",
                new EspeceWithTypeRowMapper(),
                id);

    }
}
