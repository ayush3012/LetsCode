package DailyCheck_WarmUP.Array;

public class GasStation134 {

    static void canCompleteCircuit(int[] gas,int[] cost)
    {
        int total=0;
        int current=0;
        int start=0;
        for(int i=0;i< gas.length;i++)
        {
            int diff=gas[i]-cost[i];
            total+=diff;
            current+=diff;
            if(current<0)
            {
                current=0;
                start=i+1;
            }
        }
        System.out.println(total>=0?start:-1);
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int sgas=0,scost=0,ind=0;
        for(int a:gas) sgas+=a;
        for(int a:cost) scost+=a;
        if(scost>sgas)
            return -1;
        int total=0;
        for(int i=0;i<gas.length;i++)
        {
            total+=gas[i]-cost[i];
            if(total<0)
            {
                ind=i+1;
                total=0;
            }
        }
        return ind;
    }
    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};int[] cost = {3,4,5,1,2};

        canCompleteCircuit(gas,cost);

    }
}
