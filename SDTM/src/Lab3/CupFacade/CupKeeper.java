package CupFacade;

public class CupKeeper {
    private ICup smallCup;
    private ICup mediumCup;
    private ICup largeCup;
    
    public CupKeeper() {
        smallCup = new SmallCup();
        mediumCup = new MediumCup();
        largeCup = new LargeCup();
    }
    
    public void findLargeCup() {
        largeCup.findCup();
    }
    
    public void findMediumCup() {
        mediumCup.findCup();
    }
    
    public void findSmallCup() {
        smallCup.findCup();
    }
}