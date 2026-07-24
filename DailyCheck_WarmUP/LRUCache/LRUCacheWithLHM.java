package DailyCheck_WarmUP.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLHM<K,V> extends LinkedHashMap<K,V> {

     int capacity;

    LRUCacheWithLHM(int capacity)
    {
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    @Override
    public V put(K key,V value)
    {
        return super.put(key,value);
    }

    @Override
    public V get(Object key)
    {
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> e)
    {
        return size()>capacity;
    }

    public static void main(String[] args) {

        LRUCacheWithLHM<String,Integer> cache=new LRUCacheWithLHM<>(4);

        cache.put("ayush",1);
        cache.put("abhishek",2);
        cache.put("sameer",3);
        cache.put("sanjay",4);

        for(Map.Entry<String,Integer> e:cache.entrySet())
            System.out.println(e.getKey()+" "+e.getValue());

        cache.put("ayush",1);

        System.out.println("=========");
        for(Map.Entry<String,Integer> e:cache.entrySet())
            System.out.println(e.getKey()+" "+e.getValue());
    }
}
