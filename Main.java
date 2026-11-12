package com.app99;

import com.app99.enums.StatusServico;
import com.app99.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Endereco endPadrao = new Endereco("Av. Brasil", "500", "Centro", "Campina Grande", "58400-000");
        Cliente cliente = new Cliente("U1", "Maria Eduarda", "maria@email.com", "1234", "(83) 99999-0000", endPadrao);
        Motorista motorista = new Motorista("U2", "Carlos Silva", "carlos@email.com", "4321", "987654321", "ABC-1234",
                "Onix Branco");
        Entregador entregador = new Entregador("U3", "Pedro Santos", "pedro@email.com", "5678", "123.456.789-00",
                "Moto");

        Estabelecimento restaurante = new Estabelecimento("E1", "Conecta Burguer", "12.345.678/0001-90");
        Produto p1 = new Produto("PR1", "X-Burguer Artesanal", 25.00, "Pão brioche e carne 180g");
        Produto p2 = new Produto("PR2", "Refrigerante Lata", 6.00, "350ml");
        restaurante.adicionarProduto(p1);
        restaurante.adicionarProduto(p2);

        Servico ultimoServico = null;
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========= SISTEMA CONECTA+ =========");
            System.out.println("Cliente Logado: " + cliente.getNome() + " (" + cliente.getPerfil() + ")");
            System.out.println("1. Solicitar Corrida");
            System.out.println("2. Realizar Pedido de Delivery");
            System.out.println("3. Consultar Status do Último Serviço");
            System.out.println("4. Concluir Último Serviço (Simulação Prestador)");
            System.out.println("5. Avaliar Último Serviço");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- NOVA CORRIDA ---");
                    System.out.print("Rua de origem: ");
                    String ruaOrig = scanner.nextLine();
                    System.out.print("Número: ");
                    String numOrig = scanner.nextLine();
                    Endereco origem = new Endereco(ruaOrig, numOrig, "Bairro Origem", "Campina Grande", "58400-001");

                    System.out.print("Rua de destino: ");
                    String ruaDest = scanner.nextLine();
                    System.out.print("Número: ");
                    String numDest = scanner.nextLine();
                    Endereco destino = new Endereco(ruaDest, numDest, "Bairro Destino", "Campina Grande", "58400-002");

                    Corrida corrida = cliente.solicitarCorrida(origem, destino);
                    motorista.aceitarCorrida(corrida);
                    corrida.calcularValor();
                    motorista.atualizarStatus(corrida, StatusServico.EM_ANDAMENTO);
                    ultimoServico = corrida;

                    System.out.println("Corrida solicitada e aceita pelo motorista: " + motorista.getNome());
                    System.out.println("De: " + corrida.getOrigem());
                    System.out.println("Para: " + corrida.getDestino());
                    System.out.println("Valor estimado: R$ " + corrida.getValorTotal());
                    System.out.println("Status atual: " + corrida.getStatus());
                    break;

                case 2:
                    System.out.println("\n--- NOVO PEDIDO DELIVERY (" + restaurante.getNomeFantasia() + ") ---");
                    List<Produto> cardapio = restaurante.listarProdutos();
                    for (int i = 0; i < cardapio.size(); i++) {
                        System.out.println(
                                (i + 1) + ". " + cardapio.get(i).getNome() + " - R$ " + cardapio.get(i).getPreco());
                    }

                    System.out.print("Escolha o número do produto: ");
                    int prodIndex = scanner.nextInt() - 1;
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();

                    if (prodIndex >= 0 && prodIndex < cardapio.size()) {
                        List<ItemPedido> itens = new ArrayList<>();
                        itens.add(new ItemPedido(qtd, cardapio.get(prodIndex)));

                        PedidoDelivery pedido = cliente.realizarPedido(restaurante, itens, cliente.getEnderecoPadrao());
                        entregador.aceitarEntrega(pedido);
                        entregador.atualizarStatus(pedido, StatusServico.EM_ANDAMENTO);
                        ultimoServico = pedido;

                        System.out.println("Pedido realizado com sucesso!");
                        System.out.println("Entregador: " + entregador.getNome());
                        System.out.println("Endereço de entrega: " + pedido.getEnderecoEntrega());
                        System.out.println("Total: R$ " + pedido.getValorTotal());
                        System.out.println("Status atual: " + pedido.getStatus());
                    } else {
                        System.out.println("Produto inválido.");
                    }
                    break;

                case 3:
                    if (ultimoServico != null) {
                        System.out.println("\nID do Serviço: " + ultimoServico.getId());
                        System.out.println("Status Atual: " + ultimoServico.getStatus());
                        System.out.println("Valor Total: R$ " + ultimoServico.getValorTotal());
                    } else {
                        System.out.println("\nNenhum serviço solicitado ainda.");
                    }
                    break;

                case 4:
                    if (ultimoServico != null) {
                        ultimoServico.atualizarStatus(StatusServico.CONCLUIDO);
                        System.out.println("\nServiço atualizado para: " + ultimoServico.getStatus());
                    } else {
                        System.out.println("\nNenhum serviço ativo para concluir.");
                    }
                    break;

                case 5:
                    if (ultimoServico != null && ultimoServico.getStatus() == StatusServico.CONCLUIDO) {
                        System.out.print("\nDigite uma nota (1 a 5): ");
                        int nota = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Comentário: ");
                        String comentario = scanner.nextLine();

                        Avaliacao av = cliente.avaliarServico(ultimoServico, nota, comentario);
                        if (av.validarNota()) {
                            System.out.println("Avaliação registrada: " + av.getNota() + " estrelas - \""
                                    + av.getComentario() + "\"");
                        } else {
                            System.out.println("Nota inválida! Deve ser entre 1 e 5.");
                        }
                    } else {
                        System.out.println("\nVocê só pode avaliar um serviço após ele ser CONCLUÍDO (Opção 4).");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema Conecta+...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}