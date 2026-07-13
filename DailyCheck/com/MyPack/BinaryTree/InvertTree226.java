package DailyCheck.com.MyPack.BinaryTree;

public class InvertTree226 extends CreateTree{

    static Node invert(Node root)
    {
        if(root==null) return null;
        Node left=invert(root.left);
        Node right=invert(root.right);

        root.left=right;
        root.right=left;

        return root;
    }
    public static void main(String[] args) {

        Node r=invert(root);
        TraversalDFS.inorderUsingRecursion(r);
    }
}
