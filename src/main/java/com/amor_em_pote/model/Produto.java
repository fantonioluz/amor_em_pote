package com.amor_em_pote.model;


public class Produto {

    private int cod_produto;
    private String nome_produto;
    private String descricao;
    private float valor;
    private int quantidade;
    private String fk_cozinheiro_cod_funcionario;
    private String nome_cozinheiro;

    public Produto() {}

    public Produto(int cod_produto, String nome_produto, String descricao, float valor) {
        this.cod_produto = cod_produto;
        this.nome_produto = nome_produto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor > 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("Valor must be greater than 0");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFk_cozinheiro_cod_funcionario() {
        return fk_cozinheiro_cod_funcionario;
    }

    public void setFk_cozinheiro_cod_funcionario(String fk_cozinheiro_cod_funcionario) {
        this.fk_cozinheiro_cod_funcionario = fk_cozinheiro_cod_funcionario;
    }

    public String getNome_cozinheiro() {
        return nome_cozinheiro;
    }

    public void setNome_cozinheiro(String nome_cozinheiro) {
        this.nome_cozinheiro = nome_cozinheiro;
    }
}

