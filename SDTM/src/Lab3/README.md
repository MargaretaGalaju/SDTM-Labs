# Topic: *Behavioral Design Patterns*
### Author: *Galaju Margareta*
------
## Objectives :
__1. Study and understand the Behavioral Design Patterns;__

__2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system;__

__3. Implement some additional functionalities using behavioral design patterns;__

## Theory :
In software engineering, behavioral design patterns have the purpose of identifying common communication patterns between different software entities. By doing so, these patterns increase flexibility in carrying out this communication.

Some examples from this category of design patterns are :

* Chain of Responsibility
* Command
* Interpreter
* Iterator
* Mediator
* Observer
* Strategy

## Implementation :
In this project I've implemented Behavioral Design Patterns using the idea from the previous labs: coffee preparation. 
Here also the main object is the _**Coffee**_. 

__1. Iterator__
The Iterator pattern is used to access the members of collections all the while hiding the underlying implementation. I made a simple iterator to print out the names of our coffees.
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

__2. Mediator__ 

The Mediator pattern acts as a bridge and, as the name implies, the mediator between different objects which communicate in any way.
In large-scale applications, direct communication means tight-coupling which makes it hard to test, maintain and scale.
This is a fairly simple implementation, and probably the most notorious one is a chat between two individuals. In our case, it's a one side chat, where the chatbot gives details to the client. 


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

Our User class defines a sendMessage() method. This method calls upon the static method from the Chat class with this instance of the user and a String as the arguments.

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