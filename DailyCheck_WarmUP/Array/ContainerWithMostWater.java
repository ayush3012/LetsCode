package DailyCheck_WarmUP.Array;

public class ContainerWithMostWater {

    static void mostWater(int[] arr)
    {
        int l=0,r=arr.length-1;
        int max=0;
        while(l<r)
        {
            max=Math.max(max,(r-l)*Math.min(arr[l],arr[r]));
            if(arr[l]<arr[r])
                l++;
            else r--;
        }
        System.out.println("most water contained is: "+max);
    }
    public static void main(String[] args) {

        int[] arr={1,8,6,2,5,4,8,3,7};

        mostWater(arr);
    }
}
