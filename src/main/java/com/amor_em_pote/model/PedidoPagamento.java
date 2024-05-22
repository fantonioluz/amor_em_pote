package com.amor_em_pote.model;

import java.time.LocalDateTime;

public class PedidoPagamento {

    private int cod_pedido;
    private String descricao;
    private int valor;
    private String nome_pedido;
    private String meio_pagamento;
    private String status;
    private LocalDateTime data_pedido;
    private int fk_Funcionario_cod_funcionario;
    private int fk_Cliente_cod_cliente;
    private int cod_pagamento;

    public PedidoPagamento() {
        this.status = "Aguardando confirmação";
        this.data_pedido = LocalDateTime.now();
    }

    public PedidoPagamento(int cod_pedido, String descricao, int valor, String nome_pedido, String meio_pagamento,
                           String status, LocalDateTime data_pedido, int fk_Funcionario_cod_funcionario,
                           int fk_Cliente_cod_cliente, int cod_pagamento) {
        this.cod_pedido = cod_pedido;
        this.descricao = descricao;
        this.valor = valor;
        this.nome_pedido = nome_pedido;
        this.meio_pagamento = meio_pagamento;
        this.status = status != null ? status : "Aguardando confirmação";
        this.data_pedido = data_pedido != null ? data_pedido : LocalDateTime.now();
        this.fk_Funcionario_cod_funcionario = fk_Funcionario_cod_funcionario;
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
        this.cod_pagamento = cod_pagamento;
    }

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (valor > 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("Valor must be greater than 0");
        }
    }

    public String getNome_pedido() {
        return nome_pedido;
    }

    public void setNome_pedido(String nome_pedido) {
        this.nome_pedido = nome_pedido;
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

    public LocalDateTime getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }

    public int getFk_Funcionario_cod_funcionario() {
        return fk_Funcionario_cod_funcionario;
    }

    public void setFk_Funcionario_cod_funcionario(int fk_Funcionario_cod_funcionario) {
        this.fk_Funcionario_cod_funcionario = fk_Funcionario_cod_funcionario;
    }

    public int getFk_Cliente_cod_cliente() {
        return fk_Cliente_cod_cliente;
    }

    public void setFk_Cliente_cod_cliente(int fk_Cliente_cod_cliente) {
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
    }

    public int getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }
}

