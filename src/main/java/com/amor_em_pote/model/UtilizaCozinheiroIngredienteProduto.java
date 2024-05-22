package com.amor_em_pote.model;

public class UtilizaCozinheiroIngredienteProduto {

    private int fk_Cozinheiro_fk_Funcionario_cod_funcionario;
    private int fk_Ingrediente_cod_ingrediente;
    private int fk_Produto_cod_produto;

    public UtilizaCozinheiroIngredienteProduto() {}

    public UtilizaCozinheiroIngredienteProduto(int fk_Cozinheiro_fk_Funcionario_cod_funcionario, int fk_Ingrediente_cod_ingrediente, int fk_Produto_cod_produto) {
        this.fk_Cozinheiro_fk_Funcionario_cod_funcionario = fk_Cozinheiro_fk_Funcionario_cod_funcionario;
        this.fk_Ingrediente_cod_ingrediente = fk_Ingrediente_cod_ingrediente;
        this.fk_Produto_cod_produto = fk_Produto_cod_produto;
    }

    public int getFk_Cozinheiro_fk_Funcionario_cod_funcionario() {
        return fk_Cozinheiro_fk_Funcionario_cod_funcionario;
    }

    public void setFk_Cozinheiro_fk_Funcionario_cod_funcionario(int fk_Cozinheiro_fk_Funcionario_cod_funcionario) {
        this.fk_Cozinheiro_fk_Funcionario_cod_funcionario = fk_Cozinheiro_fk_Funcionario_cod_funcionario;
    }

    public int getFk_Ingrediente_cod_ingrediente() {
        return fk_Ingrediente_cod_ingrediente;
    }

    public void setFk_Ingrediente_cod_ingrediente(int fk_Ingrediente_cod_ingrediente) {
        this.fk_Ingrediente_cod_ingrediente = fk_Ingrediente_cod_ingrediente;
    }

    public int getFk_Produto_cod_produto() {
        return fk_Produto_cod_produto;
    }

    public void setFk_Produto_cod_produto(int fk_Produto_cod_produto) {
        this.fk_Produto_cod_produto = fk_Produto_cod_produto;
    }
}

