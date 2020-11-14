public class CoffeeMakerFacade {
    private ICoffeeMaker americano;
    private ICoffeeMaker cappuccino;
    private ICoffeeMaker latte;
    
    public CoffeeMaker() {
        americano = new Americano();
        cappuccino = new Cappuccino();
        latte = new Latte();
    }
    
    public void prepareLatte() {
        latte.feed();
    }
    
    public void prepareCappuccino() {
        cappuccino.feed();
    }
    
    public void prepareAmericano() {
        americano.feed();
    }
}