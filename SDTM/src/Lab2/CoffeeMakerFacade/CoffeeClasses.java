package Lab2.CoffeeMakerFacade;

import Lab2.CoffeeMakerFacade.ICoffeeMaker;

class Latte implements ICoffeeMaker {
    @Override
    public void prepareCoffee() {
        System.out.println("Latte has being prepared!");
    }
}

class Cappuccino implements ICoffeeMaker {
    @Override
    public void prepareCoffee() {
        System.out.println("Cappuccino has being prepared!");
    }
}

class Americano implements ICoffeeMaker {
    @Override
    public void prepareCoffee() {
        System.out.println("Americano has being prepared!");
    }
}
