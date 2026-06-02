package InterviewProgramming.com.example.sorting;

//This is use to sort 0,1,2
public class DutchNationalFlagAlgo {

    static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void Sort_DNF(int[] arr)
    {
        int left=0;
        int mid=0;
        int right=arr.length-1;
        while (mid<=right)
        {
            if(arr[mid]==0)
            {
                swap(arr,left,mid);
                left++;
                mid++;
            }else if(arr[mid]==1)
                mid++;
            else if(arr[mid]==2)
            {
                swap(arr,mid,right);
                right--;
            }
        }
        for(int a:arr)
            System.out.print(a+" ");
    }
    public static void main(String[] args) {

        int[] arr={0,1,2,0,1,2};

        Sort_DNF(arr);
    }
}
