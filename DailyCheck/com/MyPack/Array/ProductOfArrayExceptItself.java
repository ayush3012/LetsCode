package DailyCheck.com.MyPack.Array;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

    static void product(int[] arr)
    {
        int n=arr.length;
        int[] result=new int[n];
        result[0]=1;
        for(int i=1;i<n;i++)
            result[i]=result[i-1]*arr[i-1];
        int suffix=1;
        for(int i=n-1;i>=0;i--)
        {
            result[i]=result[i]*suffix;
            suffix=suffix*arr[i] ;
        }
        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {

        int[] arr={1,3,6,4,0,-1};

        product(arr);
    }
}
