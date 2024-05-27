package com.amor_em_pote.repository;

import com.amor_em_pote.model.Ingrediente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class IngredienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public IngredienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Ingrediente ingrediente, String gerenteCodFuncionario) {
        String sqlIngrediente = "INSERT INTO ingrediente (nome_ingrediente, descricao, valor, quantidade) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlIngrediente, ingrediente.getNome_ingrediente(), ingrediente.getDescricao(), ingrediente.getValor(), ingrediente.getQuantidade());

        // Pega o ID do ingrediente recém-adicionado
        int ingredienteId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        // Insere na tabela compra_ingrediente_gerente_fornecedor
        String sqlCompra = "INSERT INTO compra_ingrediente_gerente_fornecedor (fk_ingrediente_cod_ingrediente, fk_gerente_fk_funcionario_cod_funcionario) VALUES (?, ?)";
        jdbcTemplate.update(sqlCompra, ingredienteId, gerenteCodFuncionario);
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

    public List<Ingrediente> findIngredientesComQuantidadeBaixa() {
        String sql = "SELECT * FROM ingrediente WHERE quantidade <= 2";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }

    public List<Ingrediente> findAllOrderByQuantidadeAsc() {
        String sql = "SELECT * FROM ingrediente ORDER BY quantidade ASC";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }

    public List<Ingrediente> findAllOrderByQuantidadeDesc() {
        String sql = "SELECT * FROM ingrediente ORDER BY quantidade DESC";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }

    public List<Ingrediente> findAllOrderByNomeAsc() {
        String sql = "SELECT * FROM ingrediente ORDER BY nome_ingrediente ASC";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }

    public List<Ingrediente> findAllOrderByValorAsc() {
        String sql = "SELECT * FROM ingrediente ORDER BY valor ASC";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }

    public List<Ingrediente> findAllOrderByValorDesc() {
        String sql = "SELECT * FROM ingrediente ORDER BY valor DESC";
        return jdbcTemplate.query(sql, new IngredienteRowMapper());
    }


    public List<Map<String, Object>> getCompraHistorico() {
        String sql = "SELECT c.*, i.nome_ingrediente, f.nome AS nome_gerente " +
                "FROM compra_ingrediente_gerente_fornecedor c " +
                "JOIN ingrediente i ON c.fk_ingrediente_cod_ingrediente = i.cod_ingrediente " +
                "JOIN gerente g ON c.fk_gerente_fk_funcionario_cod_funcionario = g.fk_funcionario_cod_funcionario " +
                "JOIN funcionario f ON g.fk_funcionario_cod_funcionario = f.cpf_funcionario " +
                "ORDER BY c.hora_compra DESC";
        return jdbcTemplate.queryForList(sql);
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
