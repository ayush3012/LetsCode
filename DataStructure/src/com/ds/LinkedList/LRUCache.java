package com.ds.linkedlist;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {

	Deque<Integer> cache;
	Set<Integer> presence;
	final int cache_size;

	LRUCache(int capacity)
	{
		cache=new LinkedList<>();
		presence=new HashSet<>();
		cache_size=capacity;
	}
	public void request(int page)
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

	public void updatedCache()
	{
		Iterator<Integer> itr=cache.iterator();
		while(itr.hasNext())
		{
			int page=itr.next();
			System.out.print(page+" ");
		}
	}
	public static void main(String[] args) {

		LRUCache cache = new LRUCache(4);
		cache.request(1);
		cache.request(2);
		cache.request(3);
		cache.request(1);
		cache.request(4);
		cache.request(5);
		cache.updatedCache();

	}

}
