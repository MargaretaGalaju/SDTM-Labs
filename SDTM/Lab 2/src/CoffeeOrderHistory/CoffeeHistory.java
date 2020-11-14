public class CoffeeOrderHistory {
    private static final HashMap orderedCoffees = new HashMap();

    public static addCoffeeToHistory(String coffeeType) {
        CoffeeType existingCoffee = (CoffeeType)orderedCoffees.get(coffeeType);
        if(existingCoffee == null) {
            CoffeeType newCoffee = new AttendeeImpl(coffeeType);
            orderedCoffees.put(coffeeType, newCoffee);
            System.out.println("Creating a new coffee: " + coffeeType);
            return newCoffee;
        }

        System.out.println("Such coffee has already been created, returing you the same");
        return existingCoffee;
    }
}