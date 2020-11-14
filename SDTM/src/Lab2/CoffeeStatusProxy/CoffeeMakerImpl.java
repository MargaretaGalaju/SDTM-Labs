package Lab2.CoffeeStatusProxy;

import Lab2.CoffeeMakerFacade.ICoffeeMaker;

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