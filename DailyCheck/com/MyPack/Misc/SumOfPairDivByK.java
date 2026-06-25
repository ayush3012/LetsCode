package DailyCheck.com.MyPack.Misc;

public class SumOfPairDivByK {

    static void code(int[] arr,int k)
    {
        int count=0;
        int[] freq=new int[k];
        for(int a:arr)
        {
            int rem=a%k;

            int compl=(k-rem)%k;
            count+=freq[compl];

            freq[rem]++;
        }
        System.out.println(count);//If need to print pair then two loops will be applied;
    }
    public static void main(String[] args) {

        int[] arr={2,2,3,5,4,8};int k=4;

        code(arr,k);
    }
}
