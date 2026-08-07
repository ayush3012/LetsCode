package DailyCheck_WarmUP.Array;

import java.util.ArrayList;
import java.util.List;

public class AllSubArrayOfArray {

	// below code is generating subarray
	public static List<int[]> generateAllSubArray(int[] nums)
	{
		List<int[]> result=new ArrayList<>();
		for(int i=0;i<nums.length;i++)
		{
			for(int j=i;j<nums.length;j++)
			{
				int[] subArray=new int[j-i+1];
				System.arraycopy(nums, i, subArray,0,j-i+1);
				result.add(subArray);
			}
		}
		return result;
	}

	//below code is generating all subset not subarray->pay attention
	static void solve(int[] nums,int ind,List<Integer> comb,List<List<Integer>> res)
	{
		if(nums.length==ind)
		{
			res.add(new ArrayList<>(comb));
			return;
		}
		comb.add(nums[ind]);
		solve(nums,ind+1,comb,res);
		comb.remove(comb.size()-1);
		solve(nums,ind+1,comb,res);
	}
	
	public static void main(String[] args) throws Exception {

		int[] nums = {1,2,1};
		
		for(int[] arr:generateAllSubArray(nums))
		{
			for(int i:arr)
			  System.out.print(i+" ");
			System.out.println();
		}
		
	}



}
