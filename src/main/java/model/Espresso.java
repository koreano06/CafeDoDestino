package model;

public class Espresso extends Bebida{

    public Espresso() {
        super("Expresso", 6.00);
    }

    @Override
    public void preparar() {
        System.out.println("Extraindo um espresso forte e aromático!");
    }
}
