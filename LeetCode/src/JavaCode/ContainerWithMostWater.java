package JavaCode;

public class ContainerWithMostWater {

	public static int mostWater(int[] arr)
	{
		int l=0;
		int r=arr.length-1;
		int ar=0;
		while(l<r)
		{
			ar=Math.max(ar,Math.min(arr[l],arr[r])*(r-l));
			if(arr[l]<arr[r])
				l++;
			else
				r--;
		}
		return ar;
	}
	public static void main(String[] args) {
		
		int[] arr= {1,1};
		
		System.out.println(mostWater(arr));
	}

}
