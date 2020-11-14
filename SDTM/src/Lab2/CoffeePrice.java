package Lab2;

abstract class CoffeePrice{
    protected double price;
    abstract void getCoffeePrice();

    public void calculateBill(int units){
        System.out.println(units*price);
    }
}