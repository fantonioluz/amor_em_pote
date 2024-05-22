package com.amor_em_pote.model;

public class CompraIngredienteGerenteFornecedor {

    private int fk_Ingrediente_cod_ingrediente;
    private int fk_Gerente_fk_Funcionario_cod_funcionario;
    private int fk_Fornecedor_cod_fornecedor;

    public CompraIngredienteGerenteFornecedor() {}

    public CompraIngredienteGerenteFornecedor(int fk_Ingrediente_cod_ingrediente, int fk_Gerente_fk_Funcionario_cod_funcionario, int fk_Fornecedor_cod_fornecedor) {
        this.fk_Ingrediente_cod_ingrediente = fk_Ingrediente_cod_ingrediente;
        this.fk_Gerente_fk_Funcionario_cod_funcionario = fk_Gerente_fk_Funcionario_cod_funcionario;
        this.fk_Fornecedor_cod_fornecedor = fk_Fornecedor_cod_fornecedor;
    }

    public int getFk_Ingrediente_cod_ingrediente() {
        return fk_Ingrediente_cod_ingrediente;
    }

    public void setFk_Ingrediente_cod_ingrediente(int fk_Ingrediente_cod_ingrediente) {
        this.fk_Ingrediente_cod_ingrediente = fk_Ingrediente_cod_ingrediente;
    }

    public int getFk_Gerente_fk_Funcionario_cod_funcionario() {
        return fk_Gerente_fk_Funcionario_cod_funcionario;
    }

    public void setFk_Gerente_fk_Funcionario_cod_funcionario(int fk_Gerente_fk_Funcionario_cod_funcionario) {
        this.fk_Gerente_fk_Funcionario_cod_funcionario = fk_Gerente_fk_Funcionario_cod_funcionario;
    }

    public int getFk_Fornecedor_cod_fornecedor() {
        return fk_Fornecedor_cod_fornecedor;
    }

    public void setFk_Fornecedor_cod_fornecedor(int fk_Fornecedor_cod_fornecedor) {
        this.fk_Fornecedor_cod_fornecedor = fk_Fornecedor_cod_fornecedor;
    }
}

