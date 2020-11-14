package Lab2.CoffeeStatusProxy;

import Lab2.CoffeeStatusProxy.CoffeeMakerImpl;

public class CoffeeMakerProxy extends CoffeeMakerImpl {
    private CoffeeMakerImpl coffeeMakerImpl;
    private String coffeeType;

    public CoffeeMakerProxy(String coffeeType){
        super();
        this.coffeeType = coffeeType;
    }

    @Override
    public void prepareCoffee() {
        if(coffeeMakerImpl == null){
            coffeeMakerImpl = new CoffeeMakerImpl(coffeeType);
        }
        coffeeMakerImpl.prepareCoffee();
    }
}
