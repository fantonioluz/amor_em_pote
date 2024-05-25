package com.amor_em_pote.model;

public class ProdutoPedido {
    private int id_produto_pedido_pk;
    private int cod_pedido_fk;
    private int cod_produto_fk;
    private int quantidade_produto_pedido;
    private String nome_produto;
    private float valor_produto;

    // Getters and setters

    public int getId_produto_pedido_pk() {
        return id_produto_pedido_pk;
    }

    public void setId_produto_pedido_pk(int id_produto_pedido_pk) {
        this.id_produto_pedido_pk = id_produto_pedido_pk;
    }

    public int getCod_pedido_fk() {
        return cod_pedido_fk;
    }

    public void setCod_pedido_fk(int cod_pedido_fk) {
        this.cod_pedido_fk = cod_pedido_fk;
    }

    public int getCod_produto_fk() {
        return cod_produto_fk;
    }

    public void setCod_produto_fk(int cod_produto_fk) {
        this.cod_produto_fk = cod_produto_fk;
    }

    public int getQuantidade_produto_pedido() {
        return quantidade_produto_pedido;
    }

    public void setQuantidade_produto_pedido(int quantidade_produto_pedido) {
        this.quantidade_produto_pedido = quantidade_produto_pedido;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public float getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(float valor_produto) {
        this.valor_produto = valor_produto;
    }
}
