package Lab3;

import Lab3.CoffeeMakerFacade.CoffeeMakerFacade;
import Lab3.CoffeeMakerFacade.ICoffeeMaker;
import Lab3.CoffeeOrderHistory.CoffeeHistory;
import Lab3.CoffeeOrderHistory.CoffeeType;
import Lab3.CoffeeStatusProxy.CoffeeMakerProxy;
import Lab3.IteratorPattern.EmployeeRepository;
import Lab3.MediatorPattern.User;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Do you want to get details about our coffee shop? Type 'yes' if you do");

        // Mediator Pattern
        String clientAnswer = br.readLine();

        if (clientAnswer === 'yes') {
            User coffeeBot = new User("CoffeeBot");

            coffeeBot.sendMessage("There's a reason most coffee companies don't provide the date for when the coffee was roasted; the stuff you find " +
                    "on the shelf in the grocery store has probably been there for months. " +
                    "Coffee reaches its peak flavor just days after it has been roasted and " +
                    "should be consumed within a month of its roast date.");

            User helper = new User("Helper");
            helper.sendMessage("Something else?");
        }

        System.out.print("What type of coffee do you want? We have: ");

        // Iterator Pattern
        EmployeeRepository employeeRepository = new EmployeeRepository();

        for(Iterator iterator = employeeRepository.getIterator();
            iterator.hasNext();) {
            String coffee = (String)iterator.next();
            System.out.println("- " + coffee);
        }

        GetPlanFactory planFactory = new GetPlanFactory();

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