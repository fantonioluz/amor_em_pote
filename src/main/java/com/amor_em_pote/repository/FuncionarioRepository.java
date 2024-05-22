package com.amor_em_pote.repository;

import com.amor_em_pote.model.Funcionario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FuncionarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public FuncionarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (cod_funcionario, salario, expediente, nome) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, funcionario.getCod_funcionario(), funcionario.getSalario(), funcionario.getExpediente(), funcionario.getNome());
    }

    public Funcionario findById(String codFuncionario) {
        String sql = "SELECT * FROM funcionario WHERE cod_funcionario = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{codFuncionario}, new FuncionarioRowMapper());
    }

    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM funcionario";
        return jdbcTemplate.query(sql, new FuncionarioRowMapper());
    }

    public void update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET salario = ?, expediente = ?, nome = ? WHERE cod_funcionario = ?";
        jdbcTemplate.update(sql, funcionario.getSalario(), funcionario.getExpediente(), funcionario.getNome(), funcionario.getCod_funcionario());
    }

    public void delete(String codFuncionario) {
        String sql = "DELETE FROM funcionario WHERE cod_funcionario = ?";
        jdbcTemplate.update(sql, codFuncionario);
    }

    private static final class FuncionarioRowMapper implements RowMapper<Funcionario> {
        @Override
        public Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Funcionario funcionario = new Funcionario();
            funcionario.setCod_funcionario(rs.getString("cod_funcionario"));
            funcionario.setSalario(rs.getInt("salario"));
            funcionario.setExpediente(rs.getString("expediente"));
            funcionario.setNome(rs.getString("nome"));
            return funcionario;
        }
    }
}
