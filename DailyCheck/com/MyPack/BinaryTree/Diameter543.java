package DailyCheck.com.MyPack.BinaryTree;

public class Diameter543 extends CreateTree{

    static int diameter=0;

    public static int height(Node root)
    {
        if(root==null)
            return 0;
        diameter=Math.max(diameter,height(root.left)+height(root.right));
        return 1+Math.max(height(root.left),height(root.right));
    }
    public static int diameter(Node root)
    {
        height(root);
        return diameter;
    }

    public static void main(String[] args) {

        System.out.println(diameter(root));
    }
}
