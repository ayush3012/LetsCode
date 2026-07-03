package DailyCheck.com.MyPack.LinkedList;

public class IntersectionOf2List160 extends BasicOperation{

    static Node findIntersection(Node A,Node B)
    {
        if(A==null || B==null) return null;

        Node a=A;
        Node b=B;
        while(a!=b)
        {
            a=a==null?b:a.next;
            b=b==null?a:b.next;
        }
        return a;
    }
    public static void main(String[] args) {

    }
}
