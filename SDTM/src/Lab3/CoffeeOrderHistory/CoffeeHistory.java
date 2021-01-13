package CoffeeOrderHistory;

import java.util.HashMap;

public class CoffeeHistory {
    private static final HashMap orderedCoffees = new HashMap();

    public static CoffeeType addCoffeeToHistory(String coffeeType) {
        CoffeeType existingCoffee = (CoffeeType)orderedCoffees.get(coffeeType);
        if(existingCoffee == null) {
            CoffeeType newCoffee = new CoffeeType(coffeeType);
            orderedCoffees.put(coffeeType, newCoffee);
            System.out.println("Adding to order history: " + coffeeType);
            System.out.println("History length:" + orderedCoffees.size());
            return newCoffee;
        }

        System.out.println("Such coffee has already been created, returning you the same");
        return existingCoffee;
    }
}