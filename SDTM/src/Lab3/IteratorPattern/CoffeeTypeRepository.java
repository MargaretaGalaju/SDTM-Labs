package Lab3;

public class CoffeeTypeRepository implements Sector {
    public String[] coffees = {"Espresso", "Americano", "Cappuccino", "Machiatto", "Latte"};

    @Override
    public Iterator getIterator() {
        return new CoffeeTypeIterator();
    }

    private class CoffeeTypeIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if(index < coffees.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) {
                return coffees[index++];
            }
            return null;
        }
    }
}