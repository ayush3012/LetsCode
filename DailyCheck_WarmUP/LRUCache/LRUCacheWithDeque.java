package DailyCheck_WarmUP.LRUCache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheWithDeque<K> {

    Deque<K> cache=new LinkedList<>();
    Set<K> presence=new HashSet<>();
    static final int capacity=4;

    public void add(K page)
    {
        if(presence.add(page))
        {
            if(cache.size()==capacity)
            {
                K rl=cache.removeFirst();
                presence.remove(rl);
            }
        }else cache.removeLast();
        cache.add(page);
        presence.add(page);
    }
    public void display()
    {
        for(K a:cache)
            System.out.print(a+" ");
        System.out.println();
    }

    public static void main(String[] args) {

        LRUCacheWithDeque<Integer> cacheWithDeque=new LRUCacheWithDeque<>();
        cacheWithDeque.add(1);cacheWithDeque.display();
        cacheWithDeque.add(2);cacheWithDeque.display();
        cacheWithDeque.add(3);cacheWithDeque.display();
        cacheWithDeque.add(4);cacheWithDeque.display();
        cacheWithDeque.add(5);cacheWithDeque.display();
        cacheWithDeque.add(6);cacheWithDeque.display();
    }
}
