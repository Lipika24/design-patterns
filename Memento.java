package Behavioral_Design_Patterns;
import java.util.*;
class Memento1 
{
    private String state;
    public Memento1(String state)
    {
        this.state = state;
    }
    public String getState() 
    {
        return state;
    }
}

class Originator 
{
    private String state;
    public void setState(String state) 
    {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }
    public Memento1 save() 
    {
        System.out.println("Originator: Saving to Memento.");
        return new Memento1(state);
    }
    public void restore(Memento1 m) 
    {
        state = m.getState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}

class Caretaker 
{
    private ArrayList<Memento1> mementos = new ArrayList<>();
    public void addMemento(Memento1 m)
    {
        mementos.add(m);
    }
    public Memento1 getMemento() 
    {
        return mementos.get(1);
    }
}

public class Memento 
{
    public static void main(String[] args) 
    {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("State1");
        originator.setState("State2");
        caretaker.addMemento( originator.save() );
        originator.setState("State3");
        caretaker.addMemento( originator.save() );
        originator.setState("State4");
        originator.restore( caretaker.getMemento() );
    }
}
