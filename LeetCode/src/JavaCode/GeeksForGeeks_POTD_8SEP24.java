package JavaCode;

public class GeeksForGeeks_POTD_8SEP24 {  // my solution  tle exceeds

	static int minJumps(int[] arr) {
        // your code here
		int i=0;
		int count=0;
		int ind=0;
		while(i<arr.length-ind)
		{
			if(arr[i]==0)
				return -1;
			if(arr[i]>=arr.length)
				return count+1;
			ind=findMax(arr, i, arr[i]);
			count++;
			i=arr[ind];
		}
		return count+1;
    }
	static int findMax(int[] arr,int s,int e)
	{
		int ind=s;
		int max=arr[s];
		for(int i=s;i<=e;i++)
			if(max<arr[i])
				{
				   max=arr[i];
				   ind=i;
				}
		return ind;
	}
	
	public static void main(String[] args)
	{
		//int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		//int[] arr = {1, 4, 3, 2, 6, 7};
		
		int[] arr = {0, 10, 20};
		System.out.println(minJumps(arr));
	}
}
