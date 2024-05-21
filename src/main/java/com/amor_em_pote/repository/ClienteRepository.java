package com.amor_em_pote.repository;

import com.amor_em_pote.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cliente(
                    rs.getInt("cod_cliente"),
                    rs.getString("telefone"),
                    rs.getString("nome_cliente"),
                    rs.getString("numero"),
                    rs.getString("rua"),
                    rs.getString("bairro")
            );
        }
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM Cliente";
        return jdbcTemplate.query(sql, new ClienteRowMapper());
    }

    public Cliente findById(int id) {
        String sql = "SELECT * FROM Cliente WHERE cod_cliente = ?";
        return jdbcTemplate.queryForObject(sql, new ClienteRowMapper(), id);
    }

    public int save(Cliente cliente) {
        String sql = "INSERT INTO Cliente (telefone, nome_cliente, numero, rua, bairro) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, cliente.getTelefone(), cliente.getNomeCliente(), cliente.getNumero(), cliente.getRua(), cliente.getBairro());
    }

    public int update(Cliente cliente) {
        String sql = "UPDATE Cliente SET telefone = ?, nome_cliente = ?, numero = ?, rua = ?, bairro = ? WHERE cod_cliente = ?";
        return jdbcTemplate.update(sql, cliente.getTelefone(), cliente.getNomeCliente(), cliente.getNumero(), cliente.getRua(), cliente.getBairro(), cliente.getCodCliente());
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM Cliente WHERE cod_cliente = ?";
        return jdbcTemplate.update(sql, id);
    }
}
