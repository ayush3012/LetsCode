package DailyCheck.com.MyPack.BinaryTree;

import java.util.Stack;

public class KthSmallestElement230 extends CreateTree{

    static int kthSmallestElement(Node root,int k)
    {
        Stack<Node> stk=new Stack<>();
        Node curr=root;
        while (!stk.isEmpty() || curr!=null)
        {
            while (curr!=null)
            {
                stk.push(curr);
                curr=curr.left;
            }
            curr=stk.pop();
            k--;
            if(k==0)
                return curr.data;
            curr=curr.right;
        }
        return -1;
    }
    public static void main(String[] args) {

        System.out.println(kthSmallestElement(root,3));
    }
}
