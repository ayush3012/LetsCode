package DailyCheck.com.MyPack.BinaryTree;

public class SameTree100 extends CreateTree{

    static boolean isSame(Node p,Node q)
    {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        return p.data==q.data && isSame(p.left,q.left) && isSame(p.right,q.right);
    }
    public static void main(String[] args) {

        System.out.println(isSame(root,root));
    }
}
