package DailyCheck_WarmUP.Array;

import java.util.*;
public class Subset78 {

    static void backtrack(int[] nums,int ind,List<Integer> comb,List<List<Integer>> res)
    {
        res.add(new ArrayList<>(comb));
        for(int i=ind;i< nums.length;i++)
        {
            comb.add(nums[i]);
            backtrack(nums,i+1,comb,res);
            comb.remove(comb.size()-1);
        }
    }
    static List<List<Integer>> allSubset(int[] nums)
    {
        List<List<Integer>> res=new ArrayList<>();

        backtrack(nums,0,new ArrayList<>(),res);

        return res;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};

        allSubset(nums).forEach(System.out::println);
    }
}
