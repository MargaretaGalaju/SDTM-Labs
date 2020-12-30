package Lab3.CoffeeStatusProxy;

import Lab3.CoffeeMakerFacade.ICoffeeMaker;

public class CoffeeMakerImpl implements ICoffeeMaker {
    private String coffeeType;

    public CoffeeMakerImpl(String coffeeType){
        this.coffeeType = coffeeType;
        startPreparingCoffee(coffeeType);
    }

    public CoffeeMakerImpl() {

    }

    @Override
    public void prepareCoffee() {
        System.out.println("Coffee is ready!");
    }

    private void startPreparingCoffee(String coffeeType){
        System.out.println(coffeeType + " is preparing...... ");
    }
}