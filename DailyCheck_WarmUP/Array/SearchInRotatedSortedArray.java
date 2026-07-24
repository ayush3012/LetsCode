package DailyCheck_WarmUP.Array;

public class SearchInRotatedSortedArray {

	public static int EnhancedBinarySearch(int[] arr,int k)
	{
		int l=0;
		int h=arr.length-1;
		while(l<=h)
		{
			int mid=(l+h)/2;
			if(arr[mid]==k)
				return mid;
			if(arr[l]<=arr[mid])
			{
				if(arr[l]<=k && k<=arr[mid])
					h=mid-1;
				else
					l=mid+1;
			}
			else
			{
				if(arr[mid]<=k && k<=arr[h])
					l=mid+1;
				else
					h=mid-1;
			}
		}
		return -1;
	}

	public static int EnhancedSearchWithDuplicates(int[] nums,int target)
	{
		int l=0,h=nums.length-1;
		while (l<=h)
		{
			int mid=l+(h-l)/2;
			if(nums[mid]==target)
				return mid;
			if (l<=h && (nums[l]==nums[mid]) && (nums[mid]==nums[h]))
			{
				l++;
				h--;
			}
			else if(nums[l]<=nums[mid])
			{
				if((l<=mid) && (nums[l]<=target && target<=nums[mid]))
					h=mid-1;
				else l=mid+1;
			}else{
				if((mid<=h) && (nums[mid]<=target && target<=nums[h]))
					l=mid+1;
				else h=mid-1;
			}
		}
		return -1;
	}

	static void minimum(int[] arr)
	{
		int l=0,h= arr.length-1;
		while (l<=h)
		{
			int mid=l+(h-l)/2;
			if(arr[mid]<=arr[h])
				h=mid;
			else l=mid+1;
		}
		System.out.println(arr[l]);
	}
	public static void main(String[] args) {
		
		int[] arr = {4,5,6,7,8,9,2,3};

		System.out.println(EnhancedBinarySearch(arr, 8));

		int[] arr2={2,5,6,0,0,1,2};int target=0;

		System.out.println(EnhancedSearchWithDuplicates(arr2,target));

		minimum(arr);
	}

}
