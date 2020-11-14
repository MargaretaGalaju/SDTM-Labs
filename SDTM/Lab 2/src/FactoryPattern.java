import java.io.*;
class GenerateBill{
    private static final HashMap orderedCoffees = new HashMap();

    public static void main(String args[])throws IOException{
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("What type of coffee do you want? (Expected values: latte, cappucino, americano)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String coffeeTypeInput = br.readLine();
        CoffeeType coffeeType = (CoffeeType) CoffeeOrderHistory.addCoffeeToHistory(coffeeTypeInput);

        CoffeeBuilderPattern.Coffee coffeeType = new CoffeeBuilderPattern.Coffee.Builder(coffeeTypeInput).milk(true).sugar(false).size("Large").build();

        System.out.print("Where do you want to drink it?");
        String place = br.readLine();

        System.out.print("How many coffees do you want?");
        int units = Integer.parseInt(br.readLine());
        CoffeePrice price = planFactory.getCoffeePrice(place);

        System.out.print("Bill amount for " + units +" coffees " + coffeeType + " served in/at "+ place +" is: ");
        price.getCoffeePrice();
        price.calculateBill(units);

        CoffeeMaker coffeeMaker = new CoffeeMaker();

        switch (coffeeTypeInput.toLowerCase()) {
            case 'latte':
                ICoffeeMaker coffee = new CoffeeMakerProxy("latte");
                coffee.prepareCoffee();
                coffeeMaker.prepareLatte();
            case 'cappuccino':
                ICoffeeMaker coffee = new CoffeeMakerProxy("cappuccino");
                coffee.prepareCoffee();
                coffeeMaker.prepareCappuccino();
            case 'americano':
                ICoffeeMaker coffee = new CoffeeMakerProxy("americano");
                coffee.prepareCoffee();
                coffeeMaker.prepareAmericano();
            default:
                System.out.println('We don\'t have such type of coffee, we\'ll make you an Americano instead!');
                ICoffeeMaker coffee = new CoffeeMakerProxy("americano");
                coffee.prepareCoffee();
                coffeeMaker.prepareAmericano();
        }

        System.out.print("Want something more? If yes, write the type of coffee (latte, cappucino, americano)");
        String coffeeTypeInput2 = br.readLine();
        CoffeeType coffeeType2 = (CoffeeType) CoffeeOrderHistory.addCoffeeToHistory(coffeeTypeInput2);

    }


    public static Attendee getAttendee(String name) {
        AttendeeImpl attendeeImpl = (AttendeeImpl)attendees.get(name);
        if(attendeeImpl == null) {
            attendeeImpl = new AttendeeImpl(name);
            attendees.put(name, attendeeImpl);
            System.out.println("Creating a new attendee: " + name);
        }
        return attendeeImpl;
    }
}