package CoffeeStatusProxy;

public class CupProxy extends CupImpl {
    private CupImpl coffeeMakerImpl;
    private String coffeeType;

    public CupProxy(String coffeeType){
        super();
        this.coffeeType = coffeeType;
    }

    @Override
    public void prepareCoffee() {
        if(coffeeMakerImpl == null){
            coffeeMakerImpl = new CupImpl(coffeeType);
        }
        coffeeMakerImpl.prepareCoffee();
    }
}
