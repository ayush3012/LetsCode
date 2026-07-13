package DailyCheck.com.MyPack.BinaryTree;

public class Symmetrical101 extends CreateTree{

    static boolean isMirror(Node n,Node m)
    {
        if(n==null && m==null)
            return true;
        if(n==null || m==null)
            return false;
        return n.data==m.data && isMirror(n.left,m.right) && isMirror(n.right,m.left);
    }

    static boolean isSymmetrical(Node root)
    {
        return isMirror(root.left,root.right);
    }
    public static void main(String[] args) {

        System.out.println(isSymmetrical(root));
    }
}
