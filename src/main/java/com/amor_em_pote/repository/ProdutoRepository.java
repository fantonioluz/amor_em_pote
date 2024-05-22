package com.amor_em_pote.repository;

import com.amor_em_pote.model.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Produto produto) {
        String sql = "INSERT INTO produto (cod_produto, nome_produto, descricao, valor) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, produto.getCod_produto(), produto.getNome_produto(), produto.getDescricao(), produto.getValor());
    }

    public Produto findById(int cod_produto) {
        String sql = "SELECT * FROM produto WHERE cod_produto = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cod_produto}, new ProdutoRowMapper());
        } catch (Exception e) {
            System.err.println("Erro ao buscar produto com código: " + cod_produto);
            e.printStackTrace();
            return null;
        }
    }

    public List<Produto> findAll() {
        String sql = "SELECT * FROM produto";
        return jdbcTemplate.query(sql, new ProdutoRowMapper());
    }

    public void delete(int cod_produto) {
        String sql = "DELETE FROM produto WHERE cod_produto = ?";
        jdbcTemplate.update(sql, cod_produto);
    }

    private static final class ProdutoRowMapper implements RowMapper<Produto> {
        @Override
        public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Produto produto = new Produto();
            produto.setCod_produto(rs.getInt("cod_produto"));
            produto.setNome_produto(rs.getString("nome_produto"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValor(rs.getInt("valor"));
            return produto;
        }
    }
}
