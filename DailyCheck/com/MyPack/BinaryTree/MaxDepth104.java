package DailyCheck.com.MyPack.BinaryTree;


public class MaxDepth104 extends CreateTree{

    static int maxDepth(Node root)
    {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static void main(String[] args) {

        System.out.println(maxDepth(root));
    }
}
