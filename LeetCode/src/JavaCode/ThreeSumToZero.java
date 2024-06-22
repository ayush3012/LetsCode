package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumToZero {
	
	public static List<List<Integer>> ZeroSum(int[] arr)
	{
		Arrays.sort(arr);
		Set<List<Integer>> hs=new HashSet<>();
		for(int i=0;i<arr.length-2;i++)
		{
			if(i>0 && arr[i]==arr[i-1])
				continue;
			int l=i+1;
			int h=arr.length-1;
			while(l<h)
			{
				if(arr[l]+arr[h]==-arr[i])
					hs.add(Arrays.asList(arr[l++],arr[h--],arr[i]));
				else if(arr[l]+arr[h]>-arr[i])
					h--;
				else
					l++;
			}
		}
		return new ArrayList<>(hs);
	}

	public static void main(String[] args) {
		
		int[] arr = {-1,0,1,2,-1,-4};
		List<List<Integer>> al=ZeroSum(arr);
		for(List<Integer> a:al)
			System.out.println(a);
	}

}
