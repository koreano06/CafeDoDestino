package model;

import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Caixa {
    private double totalArrecadado;
    private int totalPedidos;
    private Map<String, Integer> quantidadePorBebida = new HashMap<>();

    public void registrarVenda(String bebida, Double valor) {
        totalArrecadado += valor;

        totalPedidos++;

        quantidadePorBebida.put(bebida,quantidadePorBebida.getOrDefault(bebida, 0) + 1);
    }
    public double getTotalArrecadado() {
        return totalArrecadado;
    }
    public int getTotalPedidos() {
        return totalPedidos;
    }
    public Map<String, Integer> getQuantidadePorBebida() {
        return quantidadePorBebida;
    }

    public void salvarRelatorioAutomatico() {
        //Deu certo, ent vai ficar assim <3
        //essa parte aqui pode dar erro em mac ou linux ;-;
        String userHome = System.getProperty("user.home");
        Path pastaDocuments = Paths.get(userHome, "Documents", "Cafeteria");

        try {
            Files.createDirectories(pastaDocuments);


            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss");
            String timestamp = LocalDateTime.now().format(fmt);
            String nomeArquivo = "relatorio_" + timestamp + ".txt";

            Path arquivo = pastaDocuments.resolve(nomeArquivo);

            try (BufferedWriter writer = Files.newBufferedWriter(arquivo)) {
                writer.write("=== RELATÓRIO DE VENDAS ===");
                writer.newLine();
                writer.write("Gerado em: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                writer.newLine();
                writer.write("Total arrecadado: R$ " + totalArrecadado);
                writer.newLine();
                writer.write("Total de pedidos: " + totalPedidos);
                writer.newLine();
                writer.write("Bebidas vendidas:");
                writer.newLine();

                for (Map.Entry<String, Integer> entry : quantidadePorBebida.entrySet()) {
                    writer.write("- " + entry.getKey() + ": " + entry.getValue());
                    writer.newLine();
                }
            }

            System.out.println("Relatório salvo em: " + pastaDocuments.resolve(nomeArquivo).toString());

        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }



}
