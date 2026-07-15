package DailyCheck.com.MyPack.BinaryTree;

public class PathSum112 extends CreateTree{

    static boolean hasPathSum(Node root,int target)
    {
        if(root==null) return false;
        if(root.left==null && root.right==null)
            return root.data==target;
        int remaining=target-root.data;
        return hasPathSum(root.left,remaining) || hasPathSum(root.right,remaining);
    }

    public static void main(String[] args) {

        System.out.println(hasPathSum(root,80));
    }
}
