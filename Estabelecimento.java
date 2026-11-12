package com.app99.model;

import java.util.ArrayList;
import java.util.List;

public class Estabelecimento {
    private String id;
    private String nome;
    private String endereco;
    private List<Produto> cardapio;

    public Estabelecimento(String id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cardapio = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        cardapio.add(produto);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getCardapio() {
        return cardapio;
    }
}