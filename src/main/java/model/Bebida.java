package model;

public abstract class Bebida {

    protected String nome;
    protected double preco;

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void mostrarInfo() {
        System.out.println("Bebida: " + nome);
        System.out.println("Preço: R$ " + preco);
    }

    // Comportamento que cada bebida vai implementar do seu jeito
    public abstract void preparar();
}
