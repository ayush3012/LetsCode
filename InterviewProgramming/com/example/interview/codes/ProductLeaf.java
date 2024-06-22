package com.interview.codes;
class treenode{
	int data;
	treenode left;
	treenode right;
	treenode(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class ProductLeaf {
	static int product=1;
	public static  void  product(treenode node)
	{
		/*
		 * if(node.left==null) return ; if(node.right==null) return ;
		 */
		if(node.left==null && node.right==null)
		{
			product*=node.data;
			System.out.println(product);
			return ;
		}
		product(node.left);

		product(node.right);
	}

	public static void main(String[] args) {
		treenode node=new treenode(5);
		node.left=new treenode(7);
		node.right=new treenode(9);
		product(node);
	}

}
