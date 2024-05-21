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

    public void save(Cliente cliente) {
        String sql = "INSERT INTO cliente (cpf, nomeCliente, telefone, numero, rua, bairro) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getcpf(), cliente.getNomeCliente(), cliente.getTelefone(), cliente.getNumero(), cliente.getRua(), cliente.getBairro());
    }

    public Cliente findById(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf like ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cpf}, new ClienteRowMapper());
        } catch (Exception e) {
            System.err.println("Erro ao buscar cliente com CPF: " + cpf);
            e.printStackTrace();
            return null;
        }
    }


    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.query(sql, new ClienteRowMapper());
    }

    public void delete(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        jdbcTemplate.update(sql, cpf);
    }

    private static final class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setcpf(rs.getString("cpf"));
            cliente.setNomeCliente(rs.getString("nomeCliente"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setRua(rs.getString("rua"));
            cliente.setBairro(rs.getString("bairro"));
            return cliente;
        }
    }
}
