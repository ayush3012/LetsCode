package JavaCode;

public class NumberSmallerThanCurrent {
	
	public static int[] smallerNumbersThanCurrent(int[] nums)
	{
		int[] res=new int[nums.length];
		for(int i=0;i<nums.length;i++)
		{
			int count=0;
			for(int j=0;j<nums.length;j++)
			{
				if(i!=j && nums[i]>nums[j])
					count++;
			}
			res[i]=count;
		}
		return res;
	}

	public static void main(String[] args) {
		
		int[] nums = {8,1,2,2,3};
		
		int[] res=new int[nums.length];
		
		res=smallerNumbersThanCurrent(nums);
		
		for(int i=0;i<res.length;i++)
			System.out.print(res[i]+" ");
		
	}

}
