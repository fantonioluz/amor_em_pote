package com.amor_em_pote.model;

public class Indica {

    private int fk_Cliente_cod_cliente;
    private int fk_Cliente_cod_cliente_;

    public Indica() {}

    public Indica(int fk_Cliente_cod_cliente, int fk_Cliente_cod_cliente_) {
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
        this.fk_Cliente_cod_cliente_ = fk_Cliente_cod_cliente_;
    }

    public int getFk_Cliente_cod_cliente() {
        return fk_Cliente_cod_cliente;
    }

    public void setFk_Cliente_cod_cliente(int fk_Cliente_cod_cliente) {
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
    }

    public int getFk_Cliente_cod_cliente_() {
        return fk_Cliente_cod_cliente_;
    }

    public void setFk_Cliente_cod_cliente_(int fk_Cliente_cod_cliente_) {
        this.fk_Cliente_cod_cliente_ = fk_Cliente_cod_cliente_;
    }
}

