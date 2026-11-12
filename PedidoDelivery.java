package com.app99.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDelivery extends Servico {
    private Cliente cliente;
    private Estabelecimento estabelecimento;
    private Entregador entregador;
    private List<ItemPedido> itens;
    private double taxaEntrega;

    public PedidoDelivery(String id, LocalDateTime dataHora, String status, Cliente cliente, Estabelecimento estabelecimento, Entregador entregador, double taxaEntrega) {
        super(id, dataHora, status, 0.0);
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.entregador = entregador;
        this.itens = new ArrayList<>();
        this.taxaEntrega = taxaEntrega;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
        setValorTotal(calcularValor());
    }

    @Override
    public double calcularValor() {
        double subtotal = 0.0;
        for (ItemPedido item : itens) {
            subtotal += item.getSubtotal();
        }
        return subtotal + taxaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
        setValorTotal(calcularValor());
    }
}