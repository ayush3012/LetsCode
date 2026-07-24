package DailyCheck_WarmUP.LRUCache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheWithDeque {

    static Deque<Integer> cache=new LinkedList<>();
    static Set<Integer> presence=new HashSet<>();
    static final int capacity=4;

    static void add(int page)
    {
        if(presence.add(page))
        {
            if(cache.size()==capacity)
            {
                int rl=cache.removeFirst();
                presence.remove(rl);
            }
        }else cache.removeLast();
        cache.add(page);
        presence.add(page);
    }
    static void display()
    {
        for(int a:cache)
            System.out.print(a+" ");
        System.out.println();
    }

    public static void main(String[] args) {

        add(1);display();
        add(2);display();
        add(3);display();
        add(4);display();
        add(5);display();
        add(6);display();
    }
}
