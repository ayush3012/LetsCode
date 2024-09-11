package com.mypack.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumNumberOfConferenceRoom {
	
	static class Meeting{
		int start;
		int end;
		Meeting(int start,int end)
		{
			this.start=start;
			this.end=end;
		}
	}
	
	public static int minMeetingRoom(List<Meeting> meeting)
	{
		if(meeting == null || meeting.size()==0)
			return 0;
		meeting.sort(Comparator.comparingInt(i->i.start));
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		minHeap.add(meeting.get(0).end);
		for(int i=1;i<meeting.size();i++)
		{
			if(meeting.get(i).start>=minHeap.peek())
				 minHeap.poll();
			minHeap.add(meeting.get(i).end);
		}
		return minHeap.size();
	}

	public static void main(String[] args) {
		
		List<Meeting> meetings=new ArrayList<>();
		meetings.add(new Meeting(0,30));
		meetings.add(new Meeting(5,10));
		meetings.add(new Meeting(15,20));
		
		System.out.print("Minimum number of conference room required is: "+minMeetingRoom(meetings));

	}

}
