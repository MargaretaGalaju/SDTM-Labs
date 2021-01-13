package CupFacade;

class LargeCup implements ICup {
    @Override
    public void findCup() {
        System.out.println("Looking for a Large Cup");
    }
}

class MediumCup implements ICup {
    @Override
    public void findCup() {
        System.out.println("Looking for a Medium Cup");
    }
}

class SmallCup implements ICup {
    @Override
    public void findCup() {
        System.out.println("Looking for a Small Cup");
    }
}
