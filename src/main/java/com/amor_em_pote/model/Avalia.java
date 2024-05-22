package com.amor_em_pote.model;

public class Avalia {

    private int fk_Cliente_cod_cliente;
    private int fk_Produto_cod_produto;

    public Avalia() {}

    public Avalia(int fk_Cliente_cod_cliente, int fk_Produto_cod_produto) {
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
        this.fk_Produto_cod_produto = fk_Produto_cod_produto;
    }

    public int getFk_Cliente_cod_cliente() {
        return fk_Cliente_cod_cliente;
    }

    public void setFk_Cliente_cod_cliente(int fk_Cliente_cod_cliente) {
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
    }

    public int getFk_Produto_cod_produto() {
        return fk_Produto_cod_produto;
    }

    public void setFk_Produto_cod_produto(int fk_Produto_cod_produto) {
        this.fk_Produto_cod_produto = fk_Produto_cod_produto;
    }
}

