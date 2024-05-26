package com.amor_em_pote.repository;

import com.amor_em_pote.extractor.PedidoComProdutosExtractor;
import com.amor_em_pote.model.PedidoPagamento;
import com.amor_em_pote.model.ProdutoPedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PedidoPagamentoRepository {

    private final JdbcTemplate jdbcTemplate;

    public PedidoPagamentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(PedidoPagamento pedidoPagamento) {
        String sql = "INSERT INTO pedido_pagamento (descricao, valor, meio_pagamento, status, fk_cliente_cpf, cod_pagamento) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, pedidoPagamento.getDescricao(), pedidoPagamento.getValor(), pedidoPagamento.getMeio_pagamento(), pedidoPagamento.getStatus(), pedidoPagamento.getFk_cliente_cpf(), pedidoPagamento.getCod_pagamento());
    }

    public int getLastInsertedId() {
        String sql = "SELECT LAST_INSERT_ID()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<PedidoPagamento> findAllWithProducts() {
        String sql = "SELECT pedido_pagamento.cod_pedido, pedido_pagamento.descricao, pedido_pagamento.valor, pedido_pagamento.meio_pagamento, pedido_pagamento.status, pedido_pagamento.data_pedido, pedido_pagamento.fk_cliente_cpf, pedido_pagamento.cod_pagamento, " +
                "produto_pedido.cod_produto_fk, produto_pedido.quantidade_produto_pedido, produto.nome_produto, produto.valor AS valor_produto, " +
                "cliente.nome_cliente, entrega_entregador_pedido_cliente.fk_entregador_cod_entregador, entregador.nome_entregador AS nome_entregador " +
                "FROM pedido_pagamento " +
                "LEFT JOIN produto_pedido ON pedido_pagamento.cod_pedido = produto_pedido.cod_pedido_fk " +
                "LEFT JOIN produto ON produto_pedido.cod_produto_fk = produto.cod_produto " +
                "LEFT JOIN cliente ON pedido_pagamento.fk_cliente_cpf = cliente.cpf " +
                "LEFT JOIN entrega_entregador_pedido_cliente ON pedido_pagamento.cod_pedido = entrega_entregador_pedido_cliente.fk_pedido_pagamento_cod_pedido " +
                "LEFT JOIN entregador ON entrega_entregador_pedido_cliente.fk_entregador_cod_entregador = entregador.cod_entregador " +
                "ORDER BY pedido_pagamento.data_pedido DESC";
        return jdbcTemplate.query(sql, new PedidoComProdutosExtractor());
    }


    private static final class PedidoComProdutosExtractor implements ResultSetExtractor<List<PedidoPagamento>> {
        @Override
        public List<PedidoPagamento> extractData(ResultSet rs) throws SQLException {
            Map<Integer, PedidoPagamento> pedidoMap = new HashMap<>();
            while (rs.next()) {
                int codPedido = rs.getInt("cod_pedido");
                PedidoPagamento pedido = pedidoMap.get(codPedido);
                if (pedido == null) {
                    pedido = new PedidoPagamento();
                    pedido.setCod_pedido(codPedido);
                    pedido.setDescricao(rs.getString("descricao"));
                    pedido.setValor(rs.getFloat("valor"));
                    pedido.setMeio_pagamento(rs.getString("meio_pagamento"));
                    pedido.setStatus(rs.getString("status"));
                    pedido.setData_pedido(rs.getTimestamp("data_pedido"));
                    pedido.setFk_cliente_cpf(rs.getString("fk_cliente_cpf"));
                    pedido.setCod_pagamento(rs.getInt("cod_pagamento"));
                    pedido.setNomeCliente(rs.getString("nome_cliente"));
                    pedido.setProdutos(new ArrayList<>());
                    pedido.setNomeEntregador(rs.getString("nome_entregador")); // Inclua o nome do entregador aqui
                    pedidoMap.put(codPedido, pedido);
                }

                int codProduto = rs.getInt("cod_produto_fk");
                if (codProduto > 0) {
                    ProdutoPedido produto = new ProdutoPedido();
                    produto.setCod_produto_fk(codProduto);
                    produto.setQuantidade_produto_pedido(rs.getInt("quantidade_produto_pedido"));
                    produto.setNome_produto(rs.getString("nome_produto"));
                    produto.setValor_produto(rs.getFloat("valor_produto"));
                    pedido.getProdutos().add(produto);
                }
            }
            return new ArrayList<>(pedidoMap.values());
        }
    }
}
