package fr.foreach.pokego.respository.impl;

import fr.foreach.pokego.entity.Attaque;
import fr.foreach.pokego.respository.AttaqueJdbcRepository;
import fr.foreach.pokego.respository.rowmapper.AttaqueOfPokemonRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttaqueJdbcRepositoryImpl implements AttaqueJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public AttaqueJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Attaque> getAllAttaquesByPokemonId(Integer pokemonId) {
        return jdbcTemplate.query("SELECT PEUT_LANCER.ID_ATTAQUE as ATTAQUE_ID, ATTAQUE.NOM as ATTAQUE_NAME, ATTAQUE.PUISSANCE as ATTAQUE_POWER, " +
                        "TYPE.ID as TYPE_ID, TYPE.NOM as TYPE_NAME FROM PEUT_LANCER " +
                        "INNER JOIN ATTAQUE ON ATTAQUE.ID = PEUT_LANCER.ID_ATTAQUE " +
                        "INNER JOIN TYPE ON TYPE.ID = ATTAQUE.ID_TYPE " +
                        "WHERE PEUT_LANCER.ID_POKEMON = ?"
                , new AttaqueOfPokemonRowMapper(), pokemonId);
    }
}
