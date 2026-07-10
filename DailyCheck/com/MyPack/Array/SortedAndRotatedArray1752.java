package DailyCheck.com.MyPack.Array;

public class SortedAndRotatedArray1752 {

    static boolean check(int[] arr)
    {
        int drop=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>arr[(i+1)%arr.length])
                drop++;
        }
        return drop<=1;
    }
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};

        System.out.println(check(arr));
    }
}
