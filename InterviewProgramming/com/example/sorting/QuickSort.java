package InterviewProgramming.com.example.sorting;

import java.util.Arrays;

public class QuickSort {

    static void swap(int[] arr,int l,int h)
    {
        int temp=arr[l];
        arr[l]=arr[h];
        arr[h]=temp;
    }

    static void quickSortImpl(int[] arr,int l,int h)
    {
        if(l>=h) return;

        int i=l-1;
        int pivot=arr[h];
        for(int j=l;j<h;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);

        int pivotIdx=i+1;
        quickSortImpl(arr,l,pivotIdx-1);
        quickSortImpl(arr,pivotIdx+1,h);
    }
    public static void main(String[] args) {

        int[] arr=new int[10];

        for(int i=0;i<10;i++)
            arr[i]=(int)(Math.random()*10);

        System.out.println(Arrays.toString(arr));

        quickSortImpl(arr,0, arr.length-1);

        System.out.println(Arrays.toString(arr));

    }
}
