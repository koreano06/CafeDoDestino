package model;

public class Cafe extends Bebida {

    public Cafe() {
        super("Espresso", 6.00);
    }
    @Override
    public void preparar() {
        System.out.println("Extraindo um espresso forte e aromático!");
    }
}