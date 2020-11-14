package Lab2.CoffeeMakerFacade;

public class CoffeeMakerFacade {
    private ICoffeeMaker americano;
    private ICoffeeMaker cappuccino;
    private ICoffeeMaker latte;
    
    public void CoffeeMaker() {
        americano = new Americano();
        cappuccino = new Cappuccino();
        latte = new Latte();
    }
    
    public void prepareLatte() {
        latte.prepareCoffee();
    }
    
    public void prepareCappuccino() {
        cappuccino.prepareCoffee();
    }
    
    public void prepareAmericano() {
        americano.prepareCoffee();
    }
}