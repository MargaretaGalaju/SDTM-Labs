package CoffeeStatusProxy;

public class CupImpl implements ICoffee {
    private String coffeeType;

    public CupImpl(String coffeeType){
        this.coffeeType = coffeeType;
        startPreparingCoffee(coffeeType);
    }

    public CupImpl() {

    }

    @Override
    public void prepareCoffee() {
        System.out.println("YOUR Coffee is ready!");
    }

    private void startPreparingCoffee(String coffeeType){
        System.out.println(coffeeType + " is being prepared...... ");
    }
}