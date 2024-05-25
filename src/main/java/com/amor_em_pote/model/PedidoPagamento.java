package com.amor_em_pote.model;

import java.sql.Timestamp;
import java.util.List;

public class PedidoPagamento {

    private int cod_pedido;
    private String descricao;
    private float valor;
    private String meio_pagamento;
    private String status;
    private Timestamp data_pedido;
    private String fk_cliente_cpf;
    private int cod_pagamento;
    private String nomeCliente;
    private List<ProdutoPedido> produtos;

    // Getters e Setters para todos os campos
    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
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
        this.valor = valor;
    }

    public String getMeio_pagamento() {
        return meio_pagamento;
    }

    public void setMeio_pagamento(String meio_pagamento) {
        this.meio_pagamento = meio_pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Timestamp data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getFk_cliente_cpf() {
        return fk_cliente_cpf;
    }

    public void setFk_cliente_cpf(String fk_cliente_cpf) {
        this.fk_cliente_cpf = fk_cliente_cpf;
    }

    public int getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ProdutoPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedido> produtos) {
        this.produtos = produtos;
    }

}
