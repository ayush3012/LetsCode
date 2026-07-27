package InterviewProgramming.com.example.designpattern;

/**
 * This is behavioral design pattern used to choose strategy at run time.
 *
 * In interview they can ask: which design pattern you should choose when you want
 * to pay using upi,debit card, credit card.
 * -> so it is about choosing payment strategy or behaviour at run time.
 * */
interface paymentStrategy{
    void pay(int amount);
}
public class StrategyDesignPattern {

    public static void main(String[] args) {

        paymentStrategy upi=i-> System.out.println("paid amount: "+i+" using UPI");

        paymentStrategy card=i-> System.out.println("paid amount: "+i+" using card");

        upi.pay(500);
        card.pay(200);
    }
}
