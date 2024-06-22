package com.mypack.BinaryTree;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
		this.left=null;
		this.right=null;
	}

}
public class CreateTree {
	static Node root;

	static {
		root=new Node(25);
		root.left=new Node(15);
		root.right=new Node(50);
		root.left.left=new Node(10);
		root.left.right=new Node(22);
		root.right.left=new Node(35);
		root.right.right=new Node(70);
		root.left.left.left=new Node(4);
		root.left.left.right=new Node(12);
		root.left.right.left=new Node(18);
		root.left.right.right=new Node(24);
		root.right.left.left=new Node(31);
		root.right.left.right=new Node(44);
		root.right.right.left=new Node(66);
		root.right.right.right=new Node(90);
	}


}
