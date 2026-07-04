package DailyCheck.com.MyPack.Misc;

public class SubstringWithMore1Than0 {

    static class Fenwick{
        int[] arr;

        Fenwick(int n)
        {
            arr=new int[n+2];
        }

        void update(int index,int val)
        {
            while (index<arr.length)
            {
                arr[index]+=val;
                index+=index & (-index);
            }
        }

        int query(int index)
        {
            int sum=0;
            while (index>0)
            {
                sum+=arr[index];
                index-=index & (-index);
            }
            return sum;
        }
    }

     static void countSubString(String s)
     {
         int offset=s.length()+1;
         Fenwick f=new Fenwick(2*s.length()+5);

         int prefix=0;
         int ans=0;

         f.update(offset,1);

         for (char c:s.toCharArray())
         {
             if(c=='1')
                 prefix++;
             else prefix--;

             ans+=f.query(prefix+offset-1);
             f.update(prefix+offset,1);
         }
         System.out.println(ans);
     }
    public static void main(String[] args) {
        String s="00010";

        countSubString(s);
    }
}
/*
my approach passed 110/135 test case and make TLE for failed
* static int a=0;
    public boolean count(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
         if(s.charAt(i)=='1')
           count++;
         return count>s.length()/2;
    }

    public int countSubstring(String s) {
        // code here
        a=0;
        for(int i=0;i<s.length();i++)
          for(int j=i;j<=s.length();j++)
            if(count(s.substring(i,j)))
               a++;
      return a;
    }
* */