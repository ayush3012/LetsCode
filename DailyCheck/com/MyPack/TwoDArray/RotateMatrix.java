package DailyCheck.com.MyPack.TwoDArray;

import java.util.Arrays;

public class RotateMatrix {

    static void rotateClockwise(int[][] matrix)
    {
        //This is transpose logic
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i+1;j<matrix.length;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        System.out.println("This is Transpose of matrix:");
        for(int[] res:matrix)
            System.out.println(Arrays.toString(res));

        //Now reverse the matrix
        for(int i=0;i<matrix.length;i++)
        {
            int left=0,right=matrix.length-1;
            while (left<right)
            {
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;right--;
            }
        }
        System.out.println("This is the final 90 degree clockwise rotation of matrix:");
        for(int[] res:matrix)
            System.out.println(Arrays.toString(res));
    }

    static void rotateAntiClockwise(int[][] matrix)
    {
        //First transpose
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i+1;j< matrix.length;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        System.out.println("This is the transpose matrix:");
        for(int[] res:matrix)
            System.out.println(Arrays.toString(res));

        //now reverse
        for(int i=0;i< matrix.length;i++)
        {
            int left=0,right=matrix.length-1;
            while (left<right)
            {
                int[] temp=matrix[left];
                matrix[left]=matrix[right];
                matrix[right]=temp;
                left++;right--;
            }
        }

        System.out.println("This is the final 90 degree Anticlockwise rotation of matrix:");
        for(int[] res:matrix)
            System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {

        int[][] matrix={{1,2,3},
                        {4,5,6},
                        {7,8,9}};

        rotateClockwise(matrix);

        rotateAntiClockwise(matrix);
    }
}
