package model;

import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

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
    public void salvarRelatorio(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write("=== RELATÓRIO DE VENDAS ===\n");
            writer.write("Total arrecadado: R$ " + totalArrecadado + "\n");
            writer.write("Total de pedidos: " + totalPedidos + "\n");
            writer.write("Bebidas vendidas:\n");

            for (Map.Entry<String, Integer> entry : quantidadePorBebida.entrySet()) {
                writer.write(" - " + entry.getKey() + ": " + entry.getValue() + "\n");
            }

            System.out.println("Relatório salvo em: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }


}
