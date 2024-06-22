package JavaCode;

//Given a sorted array of distinct integers and a target value, return the index if the 
//target is found. If not, return the index where it would be if it were inserted in order.
public class SearchInsertPosition {
	
	public static int searchInsertPosition(int[] arr,int target)
	{
		int index=0;
		int i=0;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]==target)
				index=i;
			else if(i<arr.length-1 && arr[i]<target && arr[i+1]>target)
				index=i+1;
		}
		if(arr[i-1]<target)
			index=i;
		return index;
		
	}
	
	public static void main(String[] args)
	{
		int[] nums = {1,3,5,6};
		//int[] nums = {1};
		int target = 7;
		System.out.println(searchInsertPosition(nums, target));
	}

}
