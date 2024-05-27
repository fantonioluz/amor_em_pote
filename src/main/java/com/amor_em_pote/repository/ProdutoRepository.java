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
        String sql = "INSERT INTO produto (nome_produto, descricao, valor, quantidade, fk_cozinheiro_cod_funcionario) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, produto.getNome_produto(), produto.getDescricao(), produto.getValor(), produto.getQuantidade(), produto.getFk_cozinheiro_cod_funcionario());
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
        String sql = "SELECT p.*, f.nome AS nome_cozinheiro " +
                "FROM produto p " +
                "LEFT JOIN cozinheiro c ON p.fk_cozinheiro_cod_funcionario = c.fk_cozinheiro_cod_funcionario " +
                "LEFT JOIN funcionario f ON c.fk_cozinheiro_cod_funcionario = f.cpf_funcionario";
        return jdbcTemplate.query(sql, new ProdutoRowMapper());
    }


    public void update(Produto produto) {
        String sql = "UPDATE produto SET nome_produto = ?, descricao = ?, valor = ?, quantidade = ?, fk_cozinheiro_cod_funcionario = ? WHERE cod_produto = ?";
        jdbcTemplate.update(sql, produto.getNome_produto(), produto.getDescricao(), produto.getValor(), produto.getQuantidade(), produto.getFk_cozinheiro_cod_funcionario(), produto.getCod_produto());
    }

    public void delete(int cod_produto) {
        String sql = "DELETE FROM produto WHERE cod_produto = ?";
        jdbcTemplate.update(sql, cod_produto);
    }

    public List<Produto> findAvailableProducts() {
        String sql = "SELECT * FROM produto WHERE quantidade > 0";
        return jdbcTemplate.query(sql, new ProdutoRowMapper());
    }

    public int getLastInsertedId() {
        String sql = "SELECT LAST_INSERT_ID()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }



    private static final class ProdutoRowMapper implements RowMapper<Produto> {
        @Override
        public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Produto produto = new Produto();
            produto.setCod_produto(rs.getInt("cod_produto"));
            produto.setNome_produto(rs.getString("nome_produto"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValor(rs.getFloat("valor"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setFk_cozinheiro_cod_funcionario(rs.getString("fk_cozinheiro_cod_funcionario"));
            produto.setNome_cozinheiro(rs.getString("nome_cozinheiro")); // Adicionado para exibição
            return produto;
        }
    }
}
