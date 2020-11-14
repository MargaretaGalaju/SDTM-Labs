import java.io.*;
class GenerateBill{
    public static void main(String args[])throws IOException{
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("What type of coffee do you want?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String coffeeTypeInput = br.readLine();

        CoffeeBuilderPattern.Coffee coffeeType = new CoffeeBuilderPattern.Coffee.Builder(coffeeTypeInput).milk(true).sugar(false).size("Large").build();

        System.out.print("Where do you want to drink it?");
        String place = br.readLine();

        System.out.print("How many coffees do you want?");
        int units = Integer.parseInt(br.readLine());
        CoffeePrice price = planFactory.getCoffeePrice(place);

        System.out.print("Bill amount for " + units +" coffees " + coffeeType + " served in/at "+ place +" is: ");
        price.getCoffeePrice();
        price.calculateBill(units);
    }
}