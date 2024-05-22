package com.amor_em_pote.model;

public class EntregaEntregadorPedidoCliente {

    private int fk_Entregador_cod_entregador;
    private int fk_Pedido_Pagamento_cod_pedido;
    private int fk_Cliente_cod_cliente;

    public EntregaEntregadorPedidoCliente() {}

    public EntregaEntregadorPedidoCliente(int fk_Entregador_cod_entregador, int fk_Pedido_Pagamento_cod_pedido, int fk_Cliente_cod_cliente) {
        this.fk_Entregador_cod_entregador = fk_Entregador_cod_entregador;
        this.fk_Pedido_Pagamento_cod_pedido = fk_Pedido_Pagamento_cod_pedido;
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
    }

    public int getFk_Entregador_cod_entregador() {
        return fk_Entregador_cod_entregador;
    }

    public void setFk_Entregador_cod_entregador(int fk_Entregador_cod_entregador) {
        this.fk_Entregador_cod_entregador = fk_Entregador_cod_entregador;
    }

    public int getFk_Pedido_Pagamento_cod_pedido() {
        return fk_Pedido_Pagamento_cod_pedido;
    }

    public void setFk_Pedido_Pagamento_cod_pedido(int fk_Pedido_Pagamento_cod_pedido) {
        this.fk_Pedido_Pagamento_cod_pedido = fk_Pedido_Pagamento_cod_pedido;
    }

    public int getFk_Cliente_cod_cliente() {
        return fk_Cliente_cod_cliente;
    }

    public void setFk_Cliente_cod_cliente(int fk_Cliente_cod_cliente) {
        this.fk_Cliente_cod_cliente = fk_Cliente_cod_cliente;
    }
}

