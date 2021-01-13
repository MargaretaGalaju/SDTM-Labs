public class GetPlanFactory{
    public CoffeePrice getCoffeePrice(String coffeeType){
        if (coffeeType == null){
            return null;
        }
        if(coffeeType.equalsIgnoreCase("home")) {
            return new HomeMadeCoffee();
        }
        else if(coffeeType.equalsIgnoreCase("fastFood")){
            return new FastFoodRestaurant();
        }
        else if(coffeeType.equalsIgnoreCase("elite")) {
            return new EliteRestaurant();
        }
        return null;
    }
}