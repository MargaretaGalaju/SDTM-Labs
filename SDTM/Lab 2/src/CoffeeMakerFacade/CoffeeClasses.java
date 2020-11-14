public class Latte implements ICoffeeMaker {
    @Override
    public void prepareCoffee() {
        System.out.println("Latte has being prepared!");
    }
}

public class Cappuccino implements ICoffeeMaker {
    @Override
    public void prepareCoffee() {
        System.out.println("Cappuccino has being prepared!");
    }
}

public class Americano implements ICoffeeMaker {
    @Override
    public void prepareCoffee() {
        System.out.println("Americano has being prepared!");
    }
}
