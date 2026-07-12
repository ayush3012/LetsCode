package DailyCheck.com.MyPack.String;

public class SuperPalindrome906 {

    public int superpalindromesInRange(String left, String right) {
        int ans = 9 >= Long.parseLong(left) && 9 <= Long.parseLong(right) ? 1 : 0;
        for (int i = 1; i < 19684; i++) {
            String num = Integer.toString(i, 3);
            if (isPalindrome(num)) {
                long square = Long.parseLong(num) * Long.parseLong(num);
                if (square > Long.parseLong(right)) return ans;
                if (square >= Long.parseLong(left) && isPalindrome(Long.toString(square))) ans++;
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s) {
        return s!=null && s.equals(new StringBuffer(s).reverse().toString());
    }

    static long create(int a,boolean flag)
    {
        long ans=a;
        if(flag)
            a=a/10;
        while (a>0)
        {
            int d=a%10;
            ans=ans*10+d;
            a=a/10;
        }
       return ans;
    }

    static void superPalindrome(String left,String right)
    {
        int count=0;
        Long l=Long.parseLong(left);
        Long r=Long.parseLong(right);
        for(int i=1;i<100000;i++)   // think why we took 100000?
        {
            long o=create(i,false);
            long e=create(i,true);
            long sq=o*o;
            if(sq<=r)
            {
                if(sq>=l && isPalindrome(""+sq))
                    count++;
            }
            sq=e*e;
            if(sq<=r)
            {
                if(sq>=l && isPalindrome(""+sq))
                    count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {

        superPalindrome("4","1000");
    }
}
