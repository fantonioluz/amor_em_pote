package com.amor_em_pote.model;

public class Entrega {
    private String fk_entregador_cod_entregador;
    private int fk_pedido_pagamento_cod_pedido;
    private String fk_cliente_cpf;

    // Getters and setters
    public String getFk_entregador_cod_entregador() {
        return fk_entregador_cod_entregador;
    }

    public void setFk_entregador_cod_entregador(String fk_entregador_cod_entregador) {
        this.fk_entregador_cod_entregador = fk_entregador_cod_entregador;
    }

    public int getFk_pedido_pagamento_cod_pedido() {
        return fk_pedido_pagamento_cod_pedido;
    }

    public void setFk_pedido_pagamento_cod_pedido(int fk_pedido_pagamento_cod_pedido) {
        this.fk_pedido_pagamento_cod_pedido = fk_pedido_pagamento_cod_pedido;
    }

    public String getFk_cliente_cpf() {
        return fk_cliente_cpf;
    }

    public void setFk_cliente_cpf(String fk_cliente_cpf) {
        this.fk_cliente_cpf = fk_cliente_cpf;
    }
}
