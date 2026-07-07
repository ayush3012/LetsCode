package DailyCheck.com.MyPack.String;

//you are given string containing only character a,b,c
//you can replace any two adjacent different character with third one
// ab or ba->c
//ac or ca->b
// bc or cb->a
// perform these reduction in any order untill no more reduction possible
//return minimum possible length of final string
public class StringReduction {

    static String stringReduction(String s)
    {
        int a=0,b=0,c=0;
        for(char x:s.toCharArray())
        {
            if(x=='a') a++;
            if(x=='b') b++;
            if(x=='c') c++;
        }
        if(a==s.length() || b==s.length() || c==s.length())
          return ""+s.length();

        boolean A=a%2==0;
        boolean B=b%2==0;
        boolean C=c%2==0;

        if(A==B && B==C)
           return ""+2;
        return ""+1;
    }
    public static void main(String[] args) {
        String s="abcabc";

        System.out.println(stringReduction(s));
    }
}
