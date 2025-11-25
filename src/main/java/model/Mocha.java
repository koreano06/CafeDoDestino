package model;

public class Mocha extends Bebida {
    public Mocha() {
        super("Mocha", 9.50);
    }
    @Override
    public void preparar() {
        System.out.println("Misturando café, leite vaporizado e chocolate - preparando um Mocha!");
    }
}
