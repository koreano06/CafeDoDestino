import view.CardapioView;
import controller.CafeController;
import model.Caixa;
import view.LoginView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LoginView loginView = new LoginView();

        if (!loginView.mostrarMenuLogin()) {
            System.out.println("Acesso negado. Encerrando o sistema.");
            return;
        }

        Caixa caixa = new Caixa();
        CardapioView view = new CardapioView();
        CafeController controller = new CafeController(caixa);

        controller.processarPedido(view);

        Scanner sc = new Scanner(System.in);

        while (true) {
            controller.processarPedido(view);

            System.out.print("\nDeseja fazer outro pedido? (s / n): ");
            String opcao = sc.nextLine().trim().toLowerCase();

            if (opcao.equals("n")) {
                System.out.println("\n\nEncerrando sistema...");
                break;
            }
        }

        System.out.println("\n╔══╣ RESUMO DO CAIXA ╠══════╗");
        System.out.println("║  Total arrecadado: R$ " + caixa.getTotalArrecadado());
        System.out.println("║  Total de pedidos: " + caixa.getTotalPedidos());
        System.out.println("║  Bebidas vendidas: " + caixa.getQuantidadePorBebida());
        System.out.println("╚═══════════════════════════╝");

        caixa.salvarRelatorioAutomatico();

    }
}
