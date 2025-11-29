package view;

import java.util.Scanner;

public class CardapioView {
    public void mostrarCardapio() {
        System.out.println("*=== CARDÁPIO DO CAFÉ DO DESTINO ===*");
        System.out.println("1 - Espresso ........ R$ 6.00");
        System.out.println("2 - Latte ........... R$ 8.50");
        System.out.println("3 - Mocha ........... R$ 9.50");
        System.out.println("4 - Cafe ........... R$ 4.50");
    }

    public int pedirOpcao() {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Escolha uma bebida (1-3): ");
        return scanner.nextInt();
    }


}
