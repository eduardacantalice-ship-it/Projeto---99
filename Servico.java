package com.app99.model;

import java.time.LocalDateTime;

public abstract class Servico {
    private String id;
    private LocalDateTime dataHora;
    private String status;
    private double valorTotal;

    public Servico(String id, LocalDateTime dataHora, String status, double valorTotal) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.valorTotal = valorTotal;
    }

    public boolean cancelar() {
        this.status = "CANCELADO";
        return true;
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    public abstract double calcularValor();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}