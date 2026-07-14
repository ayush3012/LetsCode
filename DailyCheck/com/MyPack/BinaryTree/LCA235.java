package DailyCheck.com.MyPack.BinaryTree;

public class LCA235 extends CreateTree{

    static Node lowestCommonAncestor(Node root,Node p,Node q)
    {
        if(root==null) return null;
        if(root==p || root==q) return root;
        Node left=lowestCommonAncestor(root.left,p,q);
        Node right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        return left!=null?left:right;
    }
    public static void main(String[] args) {


    }
}
