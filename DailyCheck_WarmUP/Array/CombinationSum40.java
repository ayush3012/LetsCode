package DailyCheck_WarmUP.Array;

import java.util.*;

public class CombinationSum40 {

    static void combinationSum(int[] arr,int sum)
    {
        Arrays.sort(arr);           //this is important to remove duplicate entry
        Set<List<Integer>> res=new HashSet<>();

        backtrack(arr,sum,0,new ArrayList<>(),res);

        List<List<Integer>> al=new ArrayList<>();
        for(List<Integer> l:res)
            al.add(l);
        al.forEach(i-> System.out.println(i));
    }
    static void backtrack(int[] arr,int sum,int ind,List<Integer> comb,Set<List<Integer>> res)
    {
        if(sum==0)
        {
            res.add(new ArrayList<>(comb));
            return;
        }
        if(sum<0)
            return;
        for(int i=ind;i<arr.length;i++)
        {
            if(i>ind && arr[i-1]==arr[i])  //this condition is important to remove duplicate entry
                continue;                 // in same recursion level we are skipping duplicates
            comb.add(arr[i]);
            backtrack(arr,sum-arr[i],i+1,comb,res);
            comb.remove(comb.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] arr={2,5,2,1,2};int target=5;   //{1,2,2,2,5}

        combinationSum(arr,target);
    }
}
