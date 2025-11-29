package model;

public class Cafe extends Bebida {

    public Cafe() {
        super("Cafe", 4.50);
    }
    @Override
    public void preparar() {
        System.out.println("Extraindo um espresso forte e aromático!");
    }
}