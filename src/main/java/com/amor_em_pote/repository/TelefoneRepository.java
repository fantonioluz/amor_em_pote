package com.amor_em_pote.repository;

import com.amor_em_pote.model.Telefone;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TelefoneRepository {

    private final JdbcTemplate jdbcTemplate;

    public TelefoneRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Telefone telefone) {
        String sql = "INSERT INTO telefone (telefone, fk_cliente_cpf) VALUES (?, ?)";
        jdbcTemplate.update(sql, telefone.getTelefone(), telefone.getFkClienteCpf());
    }

    public List<Telefone> findByClienteCpf(String cpf) {
        String sql = "SELECT * FROM telefone WHERE fk_cliente_cpf = ?";
        return jdbcTemplate.query(sql, new Object[]{cpf}, new TelefoneRowMapper());
    }

    public void deleteByClienteCpf(String cpf) {
        String sql = "DELETE FROM telefone WHERE fk_cliente_cpf = ?";
        jdbcTemplate.update(sql, cpf);
    }

    private static final class TelefoneRowMapper implements RowMapper<Telefone> {
        @Override
        public Telefone mapRow(ResultSet rs, int rowNum) throws SQLException {
            Telefone telefone = new Telefone();
            telefone.setTelefonePK(rs.getInt("telefone_PK"));
            telefone.setTelefone(rs.getString("telefone"));
            telefone.setFkClienteCpf(rs.getString("fk_cliente_cpf"));
            return telefone;
        }
    }
}
