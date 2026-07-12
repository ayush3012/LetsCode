package DailyCheck_WarmUP.Array;

import java.util.Arrays;

public class XORQuery1310 {

    static void xor(int[] arr,int[][] queries)
    {
        int[] pre=new int[arr.length];
        int[] ans=new int[queries.length];
        pre[0]=arr[0];
        int j=0;
        for(int i=1;i<arr.length;i++)
            pre[i]=pre[i-1]^arr[i];
        for(int[] temp:queries)
        {
            ans[j++]=temp[0]==0?pre[temp[1]]:pre[temp[0]-1]^pre[temp[1]];
        }
        System.out.println(Arrays.toString(ans));
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,8};int[][] queries = {{0,1},{1,2},{0,3},{3,3}};

        xor(arr,queries);
    }
}
