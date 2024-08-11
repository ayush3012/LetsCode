package JavaCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FirstLastPositionOfElement34 {

	public int[] searchRange(int[] nums, int target) {

		int s=0;int e=nums.length-1;
		int[] arr=new int[] {-1,-1};
		if(nums.length==1 && nums[0]==target)
			return new int[] {0,0};
		if(nums.length==1 && nums[0]!=target)
			return new int[] {-1,-1};
		while(s<=e)
		{
			int mid=(s+e)/2;
			if(nums[mid]==target)
			{
				while(mid>=0 && nums[mid]==target)
					arr[0]=mid--;
				while(++mid<nums.length && nums[mid]==target)
					arr[1]=mid;
				return arr;
			}
			else if(nums[mid]<target)
				s=mid+1;
			else 
				e=mid-1;
		}
		return arr;
	}
	//below code works but complexity reduced (22.05) above is 100%
		public int[] searchRange_anotherApproach(int[] nums, int target) {
			Map<Integer,TreeSet<Integer>> hm=new HashMap<>();
			for(int i=0;i<nums.length;i++)
			{
				TreeSet<Integer> ts;
				if(hm.containsKey(nums[i]))
					ts=hm.get(nums[i]);
				else
					ts=new TreeSet<>();
				ts.add(i);
				hm.put(nums[i], ts);
			}
			return hm.containsKey(target)?new int[] {hm.get(target).first(),hm.get(target).last()}:new int[] {-1,-1};
		}
	public static void main(String[] args) {
		
		//int[] nums = {5,7,7,8,8,10};int target = 8;
		
				//int[] nums = {5,7,7,8,8,10};int target = 6;
				
				//int[] nums = {};int target = 0;
				//int[] nums = {1};int target = 1;
				int[] nums = {2,2};int target = 2;
				System.out.println(new FirstLastPositionOfElement34().searchRange(nums, target)[0]+" "+new FirstLastPositionOfElement34().searchRange(nums, target)[1]);
			
	}

}
