package controller;

import model.*;
import view.CardapioView;

public class CafeController {

    private Caixa caixa;

    public CafeController(Caixa caixa) {
        this.caixa = caixa;
    }
    //fim do caixa
    public Bebida criarBebida(int opcao) {
        return switch (opcao) {
            case 1 -> new Espresso();
            case 2 -> new Latte();
            case 3 -> new Mocha();
            case 4 -> new Cafe();
            default -> null;
        };
    }

    public void processarPedido(CardapioView view) {
        view.mostrarCardapio();
        int opcao = view.pedirOpcao();
        Bebida bebida = criarBebida(opcao);

        if (bebida == null) {
            System.out.println("Opção inválida! Tente novamente.");
            return;
        }

        bebida.preparar();
        System.out.println("Pedido confirmado para a bebida: " + bebida.getNome());

        // CORREÇÃO AQUI!
        caixa.registrarVenda(bebida.getNome(), bebida.getPreco());

        System.out.println("Venda registrada no caixa!\n Total atual: R$" + caixa.getTotalArrecadado());
    }
}
