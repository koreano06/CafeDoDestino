package service;

import java.io.*;

public class UsuarioService {

    private final String ARQUIVO = "usuarios.txt";

    public void salvarUsuario(String user, String senha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(user + ";" + senha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuário!");
        }
    }

    public boolean validarLogin(String user, String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");

                if (dados.length == 2 &&
                        dados[0].equals(user) &&
                        dados[1].equals(senha)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao validar login!");
        }

        return false;
    }
}
