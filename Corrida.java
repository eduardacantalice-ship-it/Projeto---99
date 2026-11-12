package com.app99.model;

import java.time.LocalDateTime;

public class Corrida extends Servico {
    private String origem;
    private String destino;
    private double distanciaKm;
    private double valorPorKm;
    private Cliente cliente;
    private Motorista motorista;

    public Corrida(String id, LocalDateTime dataHora, String status, String origem, String destino, double distanciaKm, double valorPorKm, Cliente cliente, Motorista motorista) {
        super(id, dataHora, status, 0.0);
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.valorPorKm = valorPorKm;
        this.cliente = cliente;
        this.motorista = motorista;
        setValorTotal(calcularValor());
    }

    @Override
    public double calcularValor() {
        return distanciaKm * valorPorKm;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
        setValorTotal(calcularValor());
    }

    public double getValorPorKm() {
        return valorPorKm;
    }

    public void setValorPorKm(double valorPorKm) {
        this.valorPorKm = valorPorKm;
        setValorTotal(calcularValor());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}