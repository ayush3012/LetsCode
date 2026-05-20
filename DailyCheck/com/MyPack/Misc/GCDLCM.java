package DailyCheck.com.MyPack.Misc;

/*
* GCD=HCF ->greatest common divisor
* LCM-> lowest common multiple= a*b/gcd(a,b)
* */
public class GCDLCM {

    static int gcd(int a,int b)
    {
        a=Math.abs(a);
        b=Math.abs(b);
        while (b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    static int LCM(int a,int b)
    {
        int hcf=gcd(a,b);

        return Math.abs(a*b)/hcf;
    }
    public static void main(String[] args)
    {
        int a=15;
        int b=20;

        System.out.println("GCD of a:"+a+" and b:"+b+" is: :"+gcd(a,b));

        System.out.println("LCM of a:"+a+" and b:"+b+" is: :"+LCM(a,b));

    }
}
