package JavaCode;

/*Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.*/
public class MergeSortedArray88 {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
          while(n>0) nums1[m+n-1]=m!=0?(nums1[m-1]>nums2[n-1]?nums1[--m]:nums2[--n]):nums2[--n];
        	
    }

	public static void main(String[] args) {
		
		int[] num1= {1,2,3,0,0,0};int m=3;int[] num2= {2,5,6};int n=3;
		
		//int[] num1= {0};int m=0;int[] num2= {1};int n=1;
		
		new MergeSortedArray88().merge(num1, m, num2, n);
		
		for(int i:num1)
			System.out.print(i+" ");

	}

}
