package DailyCheck_WarmUP.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation47 {

    static void backtrack(int[] nums,List<Integer> comb,Set<List<Integer>> res,boolean[] vis)
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
        Set<List<Integer>> res=new HashSet<>();

        boolean[] vis=new boolean[nums.length];

        backtrack(nums,new ArrayList<>(),res,vis);

        res.forEach(i-> System.out.println(i));
    }
    public static void main(String[] args) {
        int[] nums={1,1,2};

        permute(nums);
    }
}
