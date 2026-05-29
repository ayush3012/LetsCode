package DailyCheck.com.MyPack.Array;

public class SubArrayMaxSumOfLengthK {

    static void code(int[] arr,int k)
    {
        int window=0;
        for(int i=0;i<k;i++)
            window+=arr[i];
        int max=window;
        for(int i=k;i<arr.length;i++)
        {
            window+=arr[i]-arr[i-k];
            max=Math.max(max,window);
        }
        System.out.println("maximum sum of subarray of length "+k+" is : "+max);
    }
    public static void main(String[] args)
    {
        int[] arr={2,1,5,1,3,2};
        int k=3;

        code(arr,k);
    }
}
