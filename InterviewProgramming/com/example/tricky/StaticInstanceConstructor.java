package InterviewProgramming.com.example.tricky;

class A{

    static {
        System.out.print("1");
    }
    {
        System.out.print("2");
    }
    A()
    {
        System.out.print("3");
    }
}
public class StaticInstanceConstructor extends A{
    static {
        System.out.print("4");
    }

    {
        System.out.print("5");
    }

    StaticInstanceConstructor()
    {
        System.out.print("6");
    }
    public static void main(String[] args) {

        new StaticInstanceConstructor();

        new StaticInstanceConstructor();
    }
}
