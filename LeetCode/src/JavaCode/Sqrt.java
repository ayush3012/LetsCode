package JavaCode;

public class Sqrt {
	
	private static int sqrt(int x)
	{
		if(x<2)
			return x;
		int l=1;
		int r=x/2;
		while(l<=r)
		{
			int mid=(l+r)/2;
			if((long)mid*mid>x)
				r=mid-1;
			else
				l=mid+1;
		}
		return r;
	}
	
	public static void main(String[] args)
	{
		System.out.println(sqrt(26));
	}

}
