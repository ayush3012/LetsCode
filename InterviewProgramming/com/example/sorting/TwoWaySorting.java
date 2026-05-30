package InterviewProgramming.com.example.sorting;


import java.util.Arrays;

//sort array as even in ascending and odd in descending
public class TwoWaySorting {

    //this approach only works with positive elements
    static void sort_positive(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            if((arr[i] & 1)!=0)            // check if odd
                arr[i]*=-1;                // make it negative
        }
        Arrays.sort(arr);                  // this will sort as all negative in left half and even in right half
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
                arr[i]*=-1;                //make positive again
        }
        for(int a:arr)
            System.out.print(a+" ");
    }

    static void sort_HandleAll(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int selected =i;
            for(int j=i+1;j<arr.length;j++)
            {
                boolean selOdd= isOdd(arr[selected]);
                boolean currOdd= isOdd(arr[j]);

                if(selOdd && !currOdd)
                    selected=j;
                else if(!selOdd && !currOdd)
                {
                    if(arr[j]<arr[selected])
                        selected=j;
                }
                else if(selOdd && currOdd)
                {
                    if(arr[j]>arr[selected])
                        selected=j;
                }
                int temp=arr[i];
                arr[i]=arr[selected];
                arr[selected]=temp;
            }
        }
        for(int a:arr)
            System.out.print(a+" ");
    }

    static boolean isOdd(int a)
    {
        return (a & 1)!=0;
    }
    public static void main(String[] args) {

        int[] arr= {9,4,7,1,3,2,8};

        sort_positive(arr);

        System.out.println();

        int[] arr2= {9,4,7,1,3,2,8,-5,-2,-7,10,-4};

        sort_HandleAll(arr2);
    }
}
