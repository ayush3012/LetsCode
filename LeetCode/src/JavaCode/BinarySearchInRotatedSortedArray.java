package JavaCode;

public class BinarySearchInRotatedSortedArray {
	
	public static int search(int[] arr,int k)
	{
		int l=0;
		int h=arr.length-1;
		while(l<=h)
		{
			int mid=(l+h)/2;
			if(arr[mid]==k) return mid;
			if(arr[l]<=arr[mid])
			{
				if(k>=arr[l] && k<=arr[mid])
					h=mid-1;
				else
					l=mid+1;
			}
			else
			{
				if(k>=arr[mid] && k<=arr[h])
					l=mid+1;
				else
					h=mid-1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int[] arr= {4,5,6,7,0,1,2};
		int t=7;
		
        System.out.println(search(arr, t));
	}

}
