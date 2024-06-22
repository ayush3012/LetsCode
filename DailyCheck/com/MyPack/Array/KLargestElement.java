package com.mypack.Array;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElement {

	public static void KLarge(int[] arr,int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<k;i++)
			pq.add(arr[i]);
		for(int i=k;i<arr.length;i++)
		{
			if(pq.peek()<arr[i])
			{
				pq.poll();
				pq.add(arr[i]);
			}
		}
		Iterator<Integer> itr=pq.iterator();
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
	}
	public static void main(String[] args) {
		
		int[] arr= { 1, 23, 12, 9, 30, 2, 50 };
		
        int k=3;
		KLarge(arr, k);
	}

}
