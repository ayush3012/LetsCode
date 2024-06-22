package JavaCode;

public class ValidPerfectSquare {
	
	public static boolean isPerfectSquare(int num)
	{
		int l=1;
		int h=num;
		while(l<h)
		{
			int mid=(l+h)/2;
			if(mid*mid>=num)
				h=mid;
			else
				l=mid+1;
		}
		return l*l==num;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));
	}

}
