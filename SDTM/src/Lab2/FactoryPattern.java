package Lab2;

import Lab2.CoffeeMakerFacade.CoffeeMakerFacade;
import Lab2.CoffeeMakerFacade.ICoffeeMaker;
import Lab2.CoffeeOrderHistory.CoffeeHistory;
import Lab2.CoffeeOrderHistory.CoffeeType;
import Lab2.CoffeeStatusProxy.CoffeeMakerProxy;

import java.io.*;

class GenerateBill{
    public static void main(String args[]) throws IOException{
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("What type of coffee do you want? (Expected values: latte, cappucino, americano)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String coffeeTypeInput = br.readLine();
        CoffeeType coffeeItem = (CoffeeType) CoffeeHistory.addCoffeeToHistory(coffeeTypeInput);

        CoffeeBuilderPattern.Coffee coffeeType = new CoffeeBuilderPattern.Coffee.Builder(coffeeTypeInput).milk(true).sugar(false).size("Large").build();

        System.out.print("Where do you want to drink it?");
        String place = br.readLine();

        System.out.print("How many coffees do you want?");
        int units = Integer.parseInt(br.readLine());
        CoffeePrice price = planFactory.getCoffeePrice(place);

        System.out.print("Bill amount for " + units +" coffees " + coffeeType + " served in/at "+ place +" is: ");
        price.getCoffeePrice();
        price.calculateBill(units);

        CoffeeMakerFacade coffeeMaker = new CoffeeMakerFacade();

        switch (coffeeTypeInput.toLowerCase()) {
            case "latte":
                ICoffeeMaker latte = new CoffeeMakerProxy("latte");
                latte.prepareCoffee();
                coffeeMaker.prepareLatte();
            case "cappuccino":
                ICoffeeMaker cappuccino = new CoffeeMakerProxy("cappuccino");
                cappuccino.prepareCoffee();
                coffeeMaker.prepareCappuccino();
            case "americano":
                ICoffeeMaker americano = new CoffeeMakerProxy("americano");
                americano.prepareCoffee();
                coffeeMaker.prepareAmericano();
            default:
                System.out.println("We don't have such type of coffee, we'll make you an Americano instead!");
                ICoffeeMaker coffee = new CoffeeMakerProxy("americano");
                coffee.prepareCoffee();
                coffeeMaker.prepareAmericano();
        }

        System.out.print("Want something more? If yes, write the type of coffee (latte, cappuccino, americano)");
        String coffeeTypeInput2 = br.readLine();
        CoffeeType coffeeItem2 = (CoffeeType) CoffeeHistory.addCoffeeToHistory(coffeeTypeInput2);

    }
}