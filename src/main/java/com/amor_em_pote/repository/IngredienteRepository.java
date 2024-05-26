package com.amor_em_pote.repository;

import com.amor_em_pote.model.Ingrediente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IngredienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public IngredienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Ingrediente ingrediente) {
        String sql = "INSERT INTO ingrediente (cod_ingrediente, nome_ingrediente, descricao, valor) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, ingrediente.getCod_ingrediente(), ingrediente.getNome_ingrediente(), ingrediente.getDescricao(), ingrediente.getValor());
    }

    public Ingrediente findById(int cod_ingrediente) {
        String sql = "SELECT * FROM ingrediente WHERE cod_ingrediente = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cod_ingrediente}, new IngredienteRowMapper());
        } catch (Exception e) {
            System.err.println("Erro ao buscar ingrediente com código: " + cod_ingrediente);
            e.printStackTrace();
            return null;
        }
    }

    public List<Ingrediente> findAll() {
        String sql = "SELECT * FROM ingrediente";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }

    public void delete(int cod_ingrediente) {
        String sql = "DELETE FROM ingrediente WHERE cod_ingrediente = ?";
        jdbcTemplate.update(sql, cod_ingrediente);
    }

    public void updateQuantidade(int cod_ingrediente, int quantidade) {
        String sql = "UPDATE ingrediente SET quantidade = quantidade + ? WHERE cod_ingrediente = ?";
        jdbcTemplate.update(sql, quantidade, cod_ingrediente);
    }

    public List<Ingrediente> findAllWithQuantidadeGreaterThanZero() {
        String sql = "SELECT * FROM ingrediente WHERE quantidade > 0";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }


    private static final class IngredienteRowMapper implements RowMapper<Ingrediente> {
        @Override
        public Ingrediente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setCod_ingrediente(rs.getInt("cod_ingrediente"));
            ingrediente.setNome_ingrediente(rs.getString("nome_ingrediente"));
            ingrediente.setDescricao(rs.getString("descricao"));
            ingrediente.setValor(rs.getFloat("valor"));
            ingrediente.setQuantidade(rs.getInt("quantidade"));
            return ingrediente;
        }
    }
}
