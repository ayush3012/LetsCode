package JavaCode;

import java.util.Arrays;
/**Input: candies = 7, num_people = 4
Output: [1,2,3,1]
*/

public class DistributedCandies1103 {

	public int[] distributeCandies(int candies, int num_people) {

		int[] arr=new int[num_people];
		int sum=0;
		int a=1;
		int i=0;
		while(sum+a<=candies)
		{
			sum+=a;
			arr[i%num_people]=arr[i++%num_people]+a++;
		}
		if(sum+a>=candies)
			arr[i%num_people]=arr[i%num_people]+(candies-sum);
		return arr;
	}

	public static void main(String[] args) {
		int candies = 7;int num_people = 4;

		//int candies = 10;int num_people = 3;

		//int candies = 60;int num_people = 4;

		Arrays.stream(new DistributedCandies1103().distributeCandies(candies, num_people)).forEach(i->System.out.print(i+" "));


	}

}
