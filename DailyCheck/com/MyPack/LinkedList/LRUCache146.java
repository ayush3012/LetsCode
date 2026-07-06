package DailyCheck.com.MyPack.LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache146(int capacity)
    {
        super(capacity,0.75f,true);  // this line is important
        this.capacity=capacity;
    }

    public int get(int key)
    {
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value)
    {
        super.put(key,value);
    }

    //this method ensure when size of lhm exceeds capacity, ir removes eldest entry
    //eldest entry is determined by access order true,whenever, put or get operation happens that comes in
    //back and and least frequently comes in front so that we can remove manually also.
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest)
    {
        return size()>capacity;
    }
}
