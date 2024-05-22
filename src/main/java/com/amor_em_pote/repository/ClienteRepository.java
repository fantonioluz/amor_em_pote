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
        String sql = "INSERT INTO Cliente (cpf, nome_cliente, numero, rua, bairro) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getCpf(), cliente.getNomeCliente(), cliente.getNumero(), cliente.getRua(), cliente.getBairro());
        saveTelefones(cliente.getCpf(), cliente.getTelefones());
    }

    public Cliente findById(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        Cliente cliente = jdbcTemplate.queryForObject(sql, new Object[]{cpf}, new ClienteRowMapper());
        cliente.setTelefones(findTelefonesByCpf(cpf)); // Adicione esta linha
        return cliente;
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = jdbcTemplate.query(sql, new ClienteRowMapper());
        for (Cliente cliente : clientes) {
            cliente.setTelefones(findTelefonesByCpf(cliente.getCpf())); // Adicione esta linha
        }
        return clientes;
    }

    public void delete(String cpf) {
        deleteTelefonesByCpf(cpf); // Adicione esta linha
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        jdbcTemplate.update(sql, cpf);
    }

    private List<String> findTelefonesByCpf(String cpf) {
        String sql = "SELECT telefone FROM telefone WHERE fk_cliente_cpf = ?";
        return jdbcTemplate.query(sql, new Object[]{cpf}, (rs, rowNum) -> rs.getString("telefone"));
    }

    private void saveTelefones(String cpf, List<String> telefones) {
        String sql = "INSERT INTO telefone (telefone, fk_cliente_cpf) VALUES (?, ?)";
        for (String telefone : telefones) {
            jdbcTemplate.update(sql, telefone, cpf);
        }
    }

    private void deleteTelefonesByCpf(String cpf) {
        String sql = "DELETE FROM telefone WHERE fk_cliente_cpf = ?";
        jdbcTemplate.update(sql, cpf);
    }

    private static final class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setCpf(rs.getString("cpf"));
            cliente.setNomeCliente(rs.getString("nome_cliente"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setRua(rs.getString("rua"));
            cliente.setBairro(rs.getString("bairro"));
            return cliente;
        }
    }
}
