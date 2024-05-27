package com.amor_em_pote.repository;

import com.amor_em_pote.model.Gerente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GerenteRepository {

    private final JdbcTemplate jdbcTemplate;

    public GerenteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Gerente> findAll() {
        String sql = "SELECT g.fk_funcionario_cod_funcionario, f.nome FROM gerente g JOIN funcionario f ON g.fk_funcionario_cod_funcionario = f.cpf_funcionario";
        return jdbcTemplate.query(sql, new GerenteRowMapper());
    }

    private static final class GerenteRowMapper implements RowMapper<Gerente> {
        @Override
        public Gerente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Gerente gerente = new Gerente();
            gerente.setCod_funcionario(rs.getString("fk_funcionario_cod_funcionario"));
            gerente.setNome(rs.getString("nome"));
            return gerente;
        }
    }
}
