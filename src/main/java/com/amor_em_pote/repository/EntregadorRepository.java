package com.amor_em_pote.repository;

import com.amor_em_pote.model.Entregador;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EntregadorRepository {

    private final JdbcTemplate jdbcTemplate;

    public EntregadorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Entregador entregador) {
        String sql = "INSERT INTO entregador (cod_entregador) VALUES (?)";
        jdbcTemplate.update(sql, entregador.getCod_entregador());
    }

    public Entregador findById(String cod_entregador) {
        String sql = "SELECT * FROM entregador WHERE cod_entregador = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cod_entregador}, new EntregadorRowMapper());
        } catch (Exception e) {
            System.err.println("Erro ao buscar entregador com código: " + cod_entregador);
            e.printStackTrace();
            return null;
        }
    }

    public List<Entregador> findAll() {
        String sql = "SELECT * FROM entregador";
        return jdbcTemplate.query(sql, new EntregadorRowMapper());
    }

    public void delete(String cod_entregador) {
        String sql = "DELETE FROM entregador WHERE cod_entregador = ?";
        jdbcTemplate.update(sql, cod_entregador);
    }

    private static final class EntregadorRowMapper implements RowMapper<Entregador> {
        @Override
        public Entregador mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entregador entregador = new Entregador();
            entregador.setCod_entregador(rs.getString("cod_entregador"));
            return entregador;
        }
    }
}
