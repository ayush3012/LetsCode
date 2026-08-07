package DailyCheck_WarmUP.Array;

import java.util.Arrays;

public class BoatToSavePeople881 {

    static void minBoat(int[] people,int limit)
    {
        Arrays.sort(people);
        int left=0,right= people.length-1;
        int boat=0;
        while (left<=right)
        {
            if(people[left]+people[right]<=limit)
                left++;
            right--;
            boat++;
        }
        System.out.println(boat);
    }
    public static void main(String[] args) {
        //int[] people = {3,2,2,1};int limit = 3;

        //int[] people = {1,2};int limit = 3;

        int[] people = {3,5,3,4};int limit = 5;

        minBoat(people,limit);
    }
}
