package model;

public class Latte extends Bebida {
    public Latte() {
        super("Latte", 8.50);
    }

    @Override
    public void preparar() {
        System.out.println("Vaporizando leite e adicionando ao espresso - preparando um Latte!");
    }
}
