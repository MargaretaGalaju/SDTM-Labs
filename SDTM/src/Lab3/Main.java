import CoffeeStatusProxy.ICoffee;
import CupFacade.CupKeeper;
import CupFacade.ICup;
import CoffeeOrderHistory.CoffeeHistory;
import CoffeeOrderHistory.CoffeeType;
import CoffeeStatusProxy.CupProxy;
import IteratorPattern.CoffeeTypeRepository;
import IteratorPattern.Iterator;
import MediatorPattern.User;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome in our coffee shop!");

        System.out.print("What type of coffee do you want? We have: ");

        // Iterator Pattern
        CoffeeTypeRepository employeeRepository = new CoffeeTypeRepository();

        for(Iterator iterator = employeeRepository.getIterator();
            iterator.hasNext();) {
            String coffee = (String)iterator.next();
            System.out.println("- " + coffee);
        }

        GetPlanFactory planFactory = new GetPlanFactory();

        String coffeeTypeInput = br.readLine();

        //Flyweight
        CoffeeType coffeeItem = (CoffeeType) CoffeeHistory.addCoffeeToHistory(coffeeTypeInput);

        System.out.print("Choose coffee size: Small, Medium, Large? \n");
        String coffeeSize = br.readLine();

        CoffeeBuilderPattern.Coffee coffeeType = new CoffeeBuilderPattern.Coffee.Builder(coffeeTypeInput).milk(true).sugar(false).size(coffeeSize).build();

        System.out.print("Where do you want to drink it? \n");
        String place = br.readLine();

        System.out.print("How many coffees do you want? \n");
        int units = Integer.parseInt(br.readLine());
        CoffeePrice price = planFactory.getCoffeePrice(place);

        System.out.print("Bill amount for " + units +" coffee(s) " + coffeeType + " served in/at "+ place +" is: ");
        price.getCoffeePrice();
        price.calculateBill(units);

        //Facade
        CupKeeper coffeeMaker = new CupKeeper();

        switch (coffeeSize.toLowerCase()) {
            case "large":
                coffeeMaker.findLargeCup();
                break;
            case "medium":
                coffeeMaker.findMediumCup();
                break;
            default:
                coffeeMaker.findSmallCup();
        }

        //Proxy
        switch (coffeeTypeInput.toLowerCase()) {
            case "latte":
                ICoffee latte = new CupProxy("latte");
                latte.prepareCoffee();
                break;
            case "cappuccino":
                ICoffee cappuccino = new CupProxy("cappuccino");
                cappuccino.prepareCoffee();
                break;
            case "americano":
                ICoffee americano = new CupProxy("americano");
                americano.prepareCoffee();
                break;
            default:
                System.out.println("We don't have such type of coffee, we'll make you an Americano instead!");
                ICoffee coffee = new CupProxy("americano");
                coffee.prepareCoffee();
        }

        System.out.print("Do you want to get details about our coffee shop? Type 'yes' if you do  \n");

        // Mediator Pattern
        String clientAnswer = br.readLine();
        if (clientAnswer.equals("yes")) {
            User coffeeBot = new User("CoffeeBot");

            coffeeBot.sendMessage("There's a reason most coffee companies don't provide the date for when the coffee was roasted; the stuff you find " +
                    "on the shelf in the grocery store has probably been there for months. " +
                    "Coffee reaches its peak flavor just days after it has been roasted and " +
                    "should be consumed within a month of its roast date.");

            User helper = new User("Helper");
            helper.sendMessage("Something else?");
        }



        System.out.print("\n Do you want one more coffee? If yes, write the type of coffee (latte, cappuccino, americano)");
        String coffeeTypeInput2 = br.readLine();
        CoffeeType coffeeItem2 = (CoffeeType) CoffeeHistory.addCoffeeToHistory(coffeeTypeInput2);
    }
}