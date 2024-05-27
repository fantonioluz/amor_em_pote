package com.amor_em_pote.repository;

import com.amor_em_pote.model.Cozinheiro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CozinheiroRepository {

    private final JdbcTemplate jdbcTemplate;

    public CozinheiroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cozinheiro> findAll() {
        String sql = "SELECT f.cpf_funcionario AS cod_funcionario, f.nome FROM cozinheiro c JOIN funcionario f ON c.fk_cozinheiro_cod_funcionario = f.cpf_funcionario";
        return jdbcTemplate.query(sql, new CozinheiroRowMapper());
    }

    private static final class CozinheiroRowMapper implements RowMapper<Cozinheiro> {
        @Override
        public Cozinheiro mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cozinheiro cozinheiro = new Cozinheiro();
            cozinheiro.setCod_funcionario(rs.getString("cod_funcionario"));
            cozinheiro.setNome(rs.getString("nome"));
            return cozinheiro;
        }
    }
}
