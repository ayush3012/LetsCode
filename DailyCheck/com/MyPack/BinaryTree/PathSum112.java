package DailyCheck.com.MyPack.BinaryTree;

import java.util.Stack;

public class PathSum112 extends CreateTree{

    static boolean hasPathSum(Node root,int target)
    {
        if(root==null) return false;
        if(root.left==null && root.right==null)
            return root.data==target;
        int remaining=target-root.data;
        return hasPathSum(root.left,remaining) || hasPathSum(root.right,remaining);
    }

    static boolean pathSum(Node root,int target)
    {
        Stack<Pairs> stk=new Stack<>();
        stk.push(new Pairs(root,root.data));
        while (!stk.isEmpty())
        {
            Pairs p=stk.pop();
            int sum=p.data;
            Node n=p.node;
            if(sum==target)
                return true;
            if(n.left!=null)
                stk.push(new Pairs(n.left,sum+n.left.data));
            if(n.right!=null)
                stk.push(new Pairs(n.right,sum+n.right.data));
        }
        return false;
    }
    public static void main(String[] args) {

        System.out.println(hasPathSum(root,80));

        System.out.println(pathSum(root,80));
    }
}
class Pairs{
    int data;
    Node node;
    Pairs(Node node,int data)
    {
        this.node=node;
        this.data=data;
    }
}