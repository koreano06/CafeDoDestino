import view.CardapioView;
import controller.CafeController;
import model.Caixa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Caixa caixa = new Caixa();
        CardapioView view = new CardapioView();
        CafeController controller = new CafeController(caixa);

        Scanner sc = new Scanner(System.in);

        while (true) {
            controller.processarPedido(view);

            System.out.print("\nDeseja fazer outro pedido? (s / n): ");
            String opcao = sc.nextLine().trim().toLowerCase();

            if (opcao.equals("n")) {
                System.out.println("\nEncerrando sistema...");
                break;
            }
        }

        System.out.println("\n=== RESUMO DO CAIXA ===");
        System.out.println("Total arrecadado: R$ " + caixa.getTotalArrecadado());
        System.out.println("Total de pedidos: " + caixa.getTotalPedidos());
        System.out.println("Bebidas vendidas: " + caixa.getQuantidadePorBebida());

        // Define o caminho da pasta Documentos
        String caminho = "C:/Users/korea/Documents/relatorio_vendas.txt";

        // Salva relatório final
        caixa.salvarRelatorio(caminho);


    }
}
