package InterviewProgramming.com.example.designpattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    public void update(String message);
}

class User implements Observer{
    private final String name;

    User(String name)
    {
        this.name=name;
    }

    @Override
    public void update(String message)
    {
        System.out.println(name+" received notification :"+message);
    }
}
public class ObserverDesignPattern {

    private List<Observer> subscriber=new ArrayList<>();

    void subscribe(User user)
    {
        subscriber.add(user);
    }

    void notifySubscriber(String message)
    {
        subscriber.forEach(s->s.update(message));
    }

    public static void main(String[] args) {
        ObserverDesignPattern ob=new ObserverDesignPattern();

        ob.subscribe(new User("Ayush"));

        ob.subscribe(new User("Tanuj"));

        ob.notifySubscriber("Subscribe to Netflix!");
    }
}
