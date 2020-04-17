package fr.foreach.pokego.respository.impl;

import fr.foreach.pokego.entity.Type;
import fr.foreach.pokego.respository.TypeJdbcRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class TypeJdbcRepositoryImpl implements TypeJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public TypeJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Type getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT ID,NOM FROM TYPE WHERE ID = ?",
                new BeanPropertyRowMapper<>(Type.class), id);
    }

    @Override
    public List<Type> searchByNom(Integer id) {
        return jdbcTemplate.query("SELECT ID,NOM FROM TYPE WHERE NOM = ?",
                new BeanPropertyRowMapper<>(Type.class), id);
    }

    @Override
    public List<Type> getAll() {
        return jdbcTemplate.query("SELECT ID,NOM FROM TYPE",
                new BeanPropertyRowMapper<>(Type.class));
    }

    @Override
    public Integer createType(Type type) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatement ps = null;
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement
            createPreparedStatement(Connection connection) throws
                    SQLException {
                PreparedStatement ps =
                        connection.prepareStatement(
                               "INSERT INTO TYPE(NOM) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, type.getNom());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void editType(Type type) {
        jdbcTemplate.update("UPDATE TYPE SET NOM = ? WHERE ID = ?", type.getNom(), type.getId());
    }

    @Override
    public void deleteType(Integer id) {
        jdbcTemplate.update("DELETE FROM TYPE WHERE ID = ?", id);
    }
}
