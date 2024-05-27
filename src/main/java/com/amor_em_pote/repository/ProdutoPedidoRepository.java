package com.amor_em_pote.repository;

import com.amor_em_pote.model.ProdutoPedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProdutoPedidoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoPedidoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ProdutoPedido produtoPedido) {
        String sql = "INSERT INTO produto_pedido (cod_pedido_fk, cod_produto_fk, quantidade_produto_pedido) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, produtoPedido.getCod_pedido_fk(), produtoPedido.getCod_produto_fk(), produtoPedido.getQuantidade_produto_pedido());
    }

    public List<ProdutoPedido> findByPedidoId(int cod_pedido_fk) {
        String sql = "SELECT * FROM produto_pedido WHERE cod_pedido_fk = ?";
        return jdbcTemplate.query(sql, new Object[]{cod_pedido_fk}, new ProdutoPedidoRowMapper());
    }

    public List<ProdutoPedido> findProdutosByPedidoId(int cod_pedido) {
        String sql = "SELECT ppp.*, p.nome_produto, p.valor AS valor_produto " +
                "FROM produto_pedido ppp " +
                "LEFT JOIN produto p ON ppp.cod_produto_fk = p.cod_produto " +
                "WHERE ppp.cod_pedido_fk = ?";
        return jdbcTemplate.query(sql, new Object[]{cod_pedido}, new ProdutoPedidoRowMapper());
    }

    public List<ProdutoPedido> findProdutosMaisBaratos() {
        String sql = "SELECT ppp.*, p.nome_produto, p.valor AS valor_produto " +
                "FROM produto_pedido ppp " +
                "LEFT JOIN produto p ON ppp.cod_produto_fk = p.cod_produto " +
                "ORDER BY p.valor ASC";
        return jdbcTemplate.query(sql, new ProdutoPedidoRowMapper());
    }

    public List<ProdutoPedido> findProdutosMaisCaros() {
        String sql = "SELECT ppp.*, p.nome_produto, p.valor AS valor_produto " +
                "FROM produto_pedido ppp " +
                "LEFT JOIN produto p ON ppp.cod_produto_fk = p.cod_produto " +
                "ORDER BY p.valor DESC";
        return jdbcTemplate.query(sql, new ProdutoPedidoRowMapper());
    }

    public List<ProdutoPedido> findProdutosMaiorQuantidade() {
        String sql = "SELECT ppp.*, p.nome_produto, p.valor AS valor_produto " +
                "FROM produto_pedido ppp " +
                "LEFT JOIN produto p ON ppp.cod_produto_fk = p.cod_produto " +
                "ORDER BY ppp.quantidade_produto_pedido DESC";
        return jdbcTemplate.query(sql, new ProdutoPedidoRowMapper());
    }

    public List<ProdutoPedido> findProdutosMenorQuantidade() {
        String sql = "SELECT ppp.*, p.nome_produto, p.valor AS valor_produto " +
                "FROM produto_pedido ppp " +
                "LEFT JOIN produto p ON ppp.cod_produto_fk = p.cod_produto " +
                "ORDER BY ppp.quantidade_produto_pedido ASC";
        return jdbcTemplate.query(sql, new ProdutoPedidoRowMapper());
    }

    public List<ProdutoPedido> findProdutosOrdemAlfabetica() {
        String sql = "SELECT ppp.*, p.nome_produto, p.valor AS valor_produto " +
                "FROM produto_pedido ppp " +
                "LEFT JOIN produto p ON ppp.cod_produto_fk = p.cod_produto " +
                "ORDER BY p.nome_produto ASC";
        return jdbcTemplate.query(sql, new ProdutoPedidoRowMapper());
    }

    public List<ProdutoPedido> findProdutosMaisPedidosCrescente() {
        String sql = "SELECT ppp.*, p.nome_produto, p.valor AS valor_produto, COUNT(ppp.cod_produto_fk) AS num_pedidos " +
                "FROM produto_pedido ppp " +
                "LEFT JOIN produto p ON ppp.cod_produto_fk = p.cod_produto " +
                "GROUP BY ppp.cod_produto_fk, ppp.cod_pedido_fk, ppp.quantidade_produto_pedido, p.nome_produto, p.valor " +
                "ORDER BY num_pedidos ASC";
        return jdbcTemplate.query(sql, new ProdutoPedidoRowMapper());
    }

    private static final class ProdutoPedidoRowMapper implements RowMapper<ProdutoPedido> {
        @Override
        public ProdutoPedido mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProdutoPedido produtoPedido = new ProdutoPedido();
            produtoPedido.setId_produto_pedido_pk(rs.getInt("id_produto_pedido_pk"));
            produtoPedido.setCod_pedido_fk(rs.getInt("cod_pedido_fk"));
            produtoPedido.setCod_produto_fk(rs.getInt("cod_produto_fk"));
            produtoPedido.setQuantidade_produto_pedido(rs.getInt("quantidade_produto_pedido"));
            produtoPedido.setNome_produto(rs.getString("nome_produto"));
            produtoPedido.setValor_produto(rs.getFloat("valor_produto"));
            return produtoPedido;
        }
    }
}
