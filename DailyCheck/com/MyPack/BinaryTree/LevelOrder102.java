package DailyCheck.com.MyPack.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102 extends CreateTree{

    static void lvl(Node root)
    {
        List<List<Integer>> al=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            int n=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                Node temp=q.poll();
                l.add(temp.data);
                if(temp.left!=null)
                    q.add(temp.left);
                if (temp.right!=null)
                    q.add(temp.right);
            }
            al.add(l);
        }
        al.forEach(i-> System.out.println(i));
    }
    public static void main(String[] args) {

    }
}
