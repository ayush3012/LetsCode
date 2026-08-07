package DailyCheck_WarmUP.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* | Feature                 | **Subarray**         | **Subsequence**                      | **Subset**                      |
| ----------------------- | -------------------- | ------------------------------------ | ------------------------------- |
| **Contiguous?**         | ✅ Yes                | ❌ No                                 | ❌ No                            |
| **Order matters?**      | ✅ Yes                | ✅ Yes (must preserve original order) | ❌ No                            |
| **Example (`[1,2,3]`)** | ✅ `[1,2]`, ❌ `[1,3]` | ✅ `[1,3]`, ❌ `[2,1]`                 | `{1,2}` = `{2,1}` (same subset) |
*
* Subarray = Continuous elements.
Subsequence = Skip allowed, but order must stay the same.
Subset = Any elements, order doesn't matter.

* */
public class AllSubArrayOfArray {

	// below code is generating subarray (must be contiguous)
	public static void generateAllSubArray(int[] nums)
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
		result.forEach(i-> System.out.println(Arrays.toString(i)));
	}

	//below code is generating all subsequence not subarray->pay attention
	//if array has unique element then this code also works for subset but with duplicate it will fail
	static void subsequence(int[] nums,int ind,List<Integer> comb,List<List<Integer>> res)
	{
		if(nums.length==ind)
		{
			res.add(new ArrayList<>(comb));
			return;
		}
		comb.add(nums[ind]);
		subsequence(nums,ind+1,comb,res);
		comb.remove(comb.size()-1);
		subsequence(nums,ind+1,comb,res);
	}
	//below code is perfect for subset
	static void allSubset(int[] nums)
	{
		Arrays.sort(nums);

		List<List<Integer>> res=new ArrayList<>();

		solve(nums,0,new ArrayList<>(),res);

		res.forEach(i-> System.out.println(i));
	}

	private static void solve(int[] nums,int ind,List<Integer> comb,List<List<Integer>> res)
	{
		res.add(new ArrayList<>(comb));
		for(int i=ind;i<nums.length;i++)
		{
			if(i>ind && nums[i-1]==nums[i])
				continue;
			comb.add(nums[i]);
			solve(nums,i+1,comb,res);
			comb.remove(comb.size()-1);
		}
	}
	public static void main(String[] args) throws Exception {

		int[] nums = {1,2,1};

		System.out.println("===SUBARRAY=====");

		generateAllSubArray(nums);

		System.out.println("===SUBSEQUENCE=====");
		List<List<Integer>> res=new ArrayList<>();

		subsequence(nums,0,new ArrayList<>(),res);

		res.forEach(i-> System.out.println(i));

		System.out.println("===SUBSET=====");

		allSubset(nums);
		
	}



}
