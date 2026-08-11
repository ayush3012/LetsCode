package DailyCheck_WarmUP.Array;

import java.util.ArrayList;
import java.util.List;

public class Permutation46 {

    static void backtrack(int[] nums, List<Integer> comb,List<List<Integer>> res,boolean[] vis)
    {
        if(comb.size()== nums.length)
        {
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int i=0;i< nums.length;i++)
        {
            if(vis[i])
                continue;
            vis[i]=true;
            comb.add(nums[i]);
            backtrack(nums,comb,res,vis);
            comb.remove(comb.size()-1);
            vis[i]=false;
        }
    }
    static void permute(int[] nums)
    {
        List<List<Integer>> res=new ArrayList<>();

        boolean[] vis=new boolean[nums.length];

        backtrack(nums,new ArrayList<>(),res,vis);

        res.forEach(i-> System.out.println(i));
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};

        permute(nums);
    }
}
