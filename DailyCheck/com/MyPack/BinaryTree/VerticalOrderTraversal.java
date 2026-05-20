package DailyCheck.com.MyPack.BinaryTree;

import java.util.*;
class Pair{
    Node n;
    int vd;
    Pair(Node n,int vd)
    {
        this.n=n;
        this.vd=vd;
    }
}
public class VerticalOrderTraversal extends CreateTree{

    static void VerticalOrder(Node root)
    {
        Map<Integer,List<Integer>> hm=new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        int mn=0;
        int mx=0;
        while (!q.isEmpty())
        {
            Pair p=q.poll();

            mn=Math.min(mn,p.vd);
            mx=Math.max(mx,p.vd);

            hm.putIfAbsent(p.vd,new ArrayList<>());
            hm.get(p.vd).add(p.n.data);

            if(p.n.left!=null)
                q.offer(new Pair(p.n.left,p.vd-1));
            if(p.n.right!=null)
                q.offer(new Pair(p.n.right,p.vd+1));
        }

        List<List<Integer>> res=new ArrayList<>();
        for(int i=mn;i<=mx;i++)
            res.add(hm.get(i));

        res.forEach(i-> System.out.println(i));

    }

    public static void main(String[] args)
    {
        VerticalOrder(root);
    }
}
