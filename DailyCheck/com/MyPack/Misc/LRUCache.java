package com.mypack.Misc;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
	
	static Deque<Integer> cache=new LinkedList<>();
	static Set<Integer> presence=new HashSet<>();
	static final int cache_size=4;
	
	public static void Request(int page)
	{
		if(!presence.contains(page))
		{
			if(cache.size()==cache_size)
			{
				int rd=cache.removeFirst();
				presence.remove(rd);
			}
		}
		else
		{
			cache.remove(page);
		}
		cache.add(page);
		presence.add(page);
	}

	public static void showCache()
	{
		Iterator<Integer> itr=cache.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
	}
	public static void main(String[] args) {
		
		Request(1);
		Request(2);
		Request(3);
		Request(1);
		Request(4);
		Request(5);
		
		showCache();
	}

}
