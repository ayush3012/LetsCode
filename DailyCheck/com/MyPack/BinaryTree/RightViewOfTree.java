package DailyCheck.com.MyPack.BinaryTree;


import java.util.*;

public class RightViewOfTree extends CreateTree {

    static void RightView(Node n) {
        List<Integer> al = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i <size; i++) {
                Node tmp = q.poll();

                if (i == size - 1)
                    al.add(tmp.data);

                if (tmp.left != null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
        }

        al.forEach(i-> System.out.print(i+" "));
    }

    public static void main(String[] args) {

        RightView(root);
    }
}
