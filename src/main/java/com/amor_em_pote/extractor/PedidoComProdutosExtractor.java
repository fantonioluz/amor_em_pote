package com.amor_em_pote.extractor;

import com.amor_em_pote.model.PedidoPagamento;
import com.amor_em_pote.model.ProdutoPedido;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoComProdutosExtractor implements ResultSetExtractor<List<PedidoPagamento>> {

    @Override
    public List<PedidoPagamento> extractData(ResultSet rs) throws SQLException, DataAccessException {
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
                pedido.setData_pedido(Timestamp.valueOf(rs.getTimestamp("data_pedido").toLocalDateTime()));
                pedido.setFk_cliente_cpf(rs.getString("fk_cliente_cpf"));
                pedido.setCod_pagamento(rs.getInt("cod_pagamento"));
                pedido.setProdutos(new ArrayList<>());
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
