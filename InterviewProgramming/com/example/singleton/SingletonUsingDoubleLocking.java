package InterviewProgramming.com.example.singleton;

class Singleton{
    private static volatile Singleton obj=null; // volatile is important otherwise other thread may create partial object

    private Singleton(){}

    public static Singleton getInstance()
    {
        if(obj==null)
        {
            synchronized(Singleton.class)  // first entered thread will lock this and again check if object is still
            {                              // not created then create it. then second thread which was waiting will return
                if(obj==null)              // that object
                {
                    obj=new Singleton();
                }
            }
        }
        return obj;
    }
}
public class SingletonUsingDoubleLocking
{
}
