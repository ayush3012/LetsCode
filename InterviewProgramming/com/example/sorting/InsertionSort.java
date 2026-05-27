package InterviewProgramming.com.example.sorting;

import java.util.Arrays;

public class InsertionSort {

    static void sort(int[] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && key<arr[j])
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void main(String[] args) {

        int[] arr= {9,4,7,1,3,2,8};

        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
