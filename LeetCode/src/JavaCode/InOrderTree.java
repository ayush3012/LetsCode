package JavaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
}
public class InOrderTree {
	
	public static List<Integer> InOrder(Node root)
	{
		Stack<Node> stk=new Stack<>();
		List<Integer> al=new ArrayList<>();
		Node curr=root;
		while(curr!=null || stk.size()>0)
		{
			while(curr!=null)
			{
				stk.push(curr);
				curr=curr.left;
			}
			curr=stk.pop();
			al.add(curr.data);
			curr=curr.right;
		}
		return al;
	}

	public static void main(String[] args) {

	}

}
