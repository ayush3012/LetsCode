package JavaCode;
//Given an integer array nums and an integer val, remove all occurrences of val 
//in nums in-place. The relative order of the elements may be changed.
public class RemoveElement {
	
public static int removeElement(int[] nums, int val) {
        
        int s=0;
        int e=nums.length-1;
        int count=0;
        for(int i=0;i<nums.length;i++)
          if(nums[i]==val)
             count++;
        while(s<e)
        {
            if(nums[s]!=val) 
                s++;
             if(nums[e]==val)
               e--;
              if(s<e && nums[s]==val && nums[e]!=val)
              {
                  int k=nums[s];
                  nums[s]=nums[e];
                  nums[e]=k;
                  s++;e--;
              }     
        }
        return nums.length-count;
    }
	public static void main(String[] args)
	{
		int[] arr= {3,2,2,3};
		int val=3;
		System.out.println(removeElement(arr,val));
	}

}
