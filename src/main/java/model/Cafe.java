package model;

public class Cafe extends Bebida {

    public Cafe() {
        super("Cafe", 4.50);
    }
    @Override
    public void preparar() {
        System.out.println("\nExtraindo um espresso forte e aromático!");
    }
}