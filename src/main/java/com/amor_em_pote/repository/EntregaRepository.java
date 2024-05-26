package com.amor_em_pote.repository;

import com.amor_em_pote.model.Entrega;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EntregaRepository {

    private final JdbcTemplate jdbcTemplate;

    public EntregaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Entrega entrega) {
        String sql = "INSERT INTO entrega_entregador_pedido_cliente (fk_entregador_cod_entregador, fk_pedido_pagamento_cod_pedido, fk_cliente_cpf) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, entrega.getFk_entregador_cod_entregador(), entrega.getFk_pedido_pagamento_cod_pedido(), entrega.getFk_cliente_cpf());
    }

    public List<Entrega> findAll() {
        String sql = "SELECT * FROM entrega_entregador_pedido_cliente";
        return jdbcTemplate.query(sql, new EntregaRowMapper());
    }

    public List<Entrega> findByPedidoId(int pedidoId) {
        String sql = "SELECT * FROM entrega_entregador_pedido_cliente WHERE fk_pedido_pagamento_cod_pedido = ?";
        return jdbcTemplate.query(sql, new Object[]{pedidoId}, new EntregaRowMapper());
    }


    private static final class EntregaRowMapper implements RowMapper<Entrega> {
        @Override
        public Entrega mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entrega entrega = new Entrega();
            entrega.setFk_entregador_cod_entregador(rs.getString("fk_entregador_cod_entregador"));
            entrega.setFk_pedido_pagamento_cod_pedido(rs.getInt("fk_pedido_pagamento_cod_pedido"));
            entrega.setFk_cliente_cpf(rs.getString("fk_cliente_cpf"));
            return entrega;
        }
    }
}
