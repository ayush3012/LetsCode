package DailyCheck.com.MyPack.BinaryTree;

public class ValidBST98 extends CreateTree{

    static boolean isBST(Node root)
    {
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    static boolean isBST(Node root,long min,long max)
    {
        if(root==null)
            return true;
        if(root.data<=min || root.data>=max)
            return false;
        return isBST(root.left,min,root.data) && isBST(root.right,root.data,max);
    }
    public static void main(String[] args) {

    }
}
