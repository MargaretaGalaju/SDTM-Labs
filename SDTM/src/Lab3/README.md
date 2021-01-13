# Topic: *Design Patterns*
### Author: *Galaju Margareta*
------
## Objectives :
__1. Study the Creational Design Pattern, Structural Design Patterns, Behavioral Design Pattern__

__2. Implement several of them in a project__

## Theory :
In Software Engineering, we must use the design patterns during the analysis and requirement phase of SDLC(Software Development Life Cycle).
Design patterns ease the analysis and requirement phase of SDLC by providing information based on prior hands-on experiences.

There are mainly three types of design patterns, which are further divided into their sub-parts:
Some examples of this kind of design patterns and whic I used in my laboratories are :

__1. Creational Design Pattern__
* Factory
* Builder

__2. Structural Design Patterns__
* Proxy
* Facade
* Flyweight

__3. Behavioral Design Pattern__
* Mediator
* Iterator

## Implementation :
In this project I've implemented a virtual coffee shop.
Here the main object is the _**Coffee**_.
Some functionalities my coffee shop do are:
* User can choose the coffee type, where he wants to drink it
* System calculates a bill for the type of coffee the user chooses
* The coffee is added to a history

__1. Facade__
The Facade pattern provides a simple and top-level interface for the client and allows it to access the system, without knowing any of the system logic and inner-workings.

This is how the interface looks like:
```
public interface ICup {
    void findCup();
}
```

And concrete classes that implement it:
```
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

```

By using this interface, the client doesn't concern themselves with the logic behind preparing the coffee.

__2. Proxy__

By using this _**Proxy**_ class, the client uses the interface it defines, to access the original class.
This ensures that the client can't do anything out of order with the original class since all of his requests pass through our proxy class.
```

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

```

__3. Flyweight__
By creating a pool of common Strings and assigning multiple reference variables to the ones with the same content,
and only creating new Strings when no match is found made a huge impact on the performance of Java.

This is the point of the Flyweight pattern. To return a new object only if a matching object doesn't already exist:

```
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
```

__4. Iterator__
The Iterator pattern is used to access the members of collections all the while hiding the underlying implementation.
I made a simple iterator to print out the names of our coffees.
All of our coffees have their own sector in which they prepared. So being prepared under a sector also includes an iterator for all of them.

```
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
```

__5. Mediator__

The Mediator pattern acts as a bridge and, as the name implies, the mediator between different objects which communicate in any way.
In large-scale applications, direct communication means tight-coupling which makes it hard to test, maintain and scale.
This is a fairly simple implementation, and probably the most notorious one is a chat between two individuals.
In our case, it's a one side chat, where the chatbot gives details to the client.

A User object wishes to communicate with another, so they use a mediator platform between them to do so - a Chat:
```
public class Chat {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + "[" + user.getName() + "]: " + message);
    }
}
```

This class contains only one method and, accepting a User and a String, it formats the parameters and shows the message.

```
public class User {
    private String name;
    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   
    public void sendMessage(String message) {
        Chat.showMessage(this, message);
    }
}
```

Our User class defines a sendMessage() method. This method calls upon the static method from the Chat class with this
instance of the user and a String as the arguments.

To illustrate the point of this pattern:

```
    User coffeeBot = new User("CoffeeBot");
    
    coffeeBot.sendMessage("There's a reason most coffee companies don't provide the date for when the coffee was roasted; the stuff you find " +
            "on the shelf in the grocery store has probably been there for months. " +
            "Coffee reaches its peak flavor just days after it has been roasted and " +
            "should be consumed within a month of its roast date.");
    
    User helper = new User("Helper");
    helper.sendMessage("Something else?");
```