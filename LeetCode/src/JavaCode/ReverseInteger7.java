package LeetCode.src.JavaCode;

public class ReverseInteger7 {

    public static int reverse(int x) {
        int num=0;
        while (x!=0)
        {
            int digit=x%10;
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && digit>7))
                return 0;
            if(num<Integer.MIN_VALUE/10 || (num==Integer.MIN_VALUE/10 && digit<-8))
                return 0;
            num=num*10+digit;
            x=x/10;
        }
        return num;
    }

    public int reverse_leetcode(int x) {
        long rev=0;
        while(x!=0){
            int digit=x%10;
            rev=rev*10+digit;
            if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE){
                return 0;
            }
            x=x/10;
        }
        return (int)rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
}
