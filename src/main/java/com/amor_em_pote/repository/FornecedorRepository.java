package com.amor_em_pote.repository;

import com.amor_em_pote.model.Fornecedor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FornecedorRepository {

    private final JdbcTemplate jdbcTemplate;

    public FornecedorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (cod_fornecedor, nome_fornecedor) VALUES (?, ?)";
        jdbcTemplate.update(sql, fornecedor.getCod_fornecedor(), fornecedor.getNome_fornecedor());
    }

    public Fornecedor findById(int cod_fornecedor) {
        String sql = "SELECT * FROM fornecedor WHERE cod_fornecedor = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cod_fornecedor}, new FornecedorRowMapper());
        } catch (Exception e) {
            System.err.println("Erro ao buscar fornecedor com código: " + cod_fornecedor);
            e.printStackTrace();
            return null;
        }
    }

    public List<Fornecedor> findAll() {
        String sql = "SELECT * FROM fornecedor";
        return jdbcTemplate.query(sql, new FornecedorRowMapper());
    }

    public void delete(int cod_fornecedor) {
        String sql = "DELETE FROM fornecedor WHERE cod_fornecedor = ?";
        jdbcTemplate.update(sql, cod_fornecedor);
    }

    private static final class FornecedorRowMapper implements RowMapper<Fornecedor> {
        @Override
        public Fornecedor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCod_fornecedor(rs.getInt("cod_fornecedor"));
            fornecedor.setNome_fornecedor(rs.getString("nome_fornecedor"));
            return fornecedor;
        }
    }
}

