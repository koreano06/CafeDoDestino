package view;

import service.UsuarioService;
import java.util.Scanner;

public class LoginView {
    private UsuarioService usuarioService = new UsuarioService();
    private Scanner sc = new Scanner(System.in);

    public boolean mostrarMenuLogin() {
        while (true) {
            System.out.println("\n=== SISTEMA DE LOGIN ===");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Criar Usuário");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");

            int opc;

            // Evita crash se o usuário digitar letras
            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Opção inválida!\n");
                continue;
            }

            if (opc == 1) {
                return fazerLogin();

            } else if (opc == 2) {
                criarUsuario();

            } else if (opc == 3) {
                return false;

            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private boolean fazerLogin() {
        System.out.print("Usuário: ");
        String user = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (usuarioService.validarLogin(user, senha)) {
            System.out.println("Login realizado com sucesso!\n");
            return true;
        } else {
            System.out.println("Usuário ou senha incorretos.\n");
            return false;
        }
    }

    private void criarUsuario() {
        System.out.print("Novo usuário: ");
        String newUser = sc.nextLine();

        System.out.print("Nova senha: ");
        String newSenha = sc.nextLine();

        usuarioService.salvarUsuario(newUser, newSenha);

        System.out.println("Usuário criado com sucesso!\n");
    }
}
