package com.ds.BinaryTree;

import java.util.Stack;

class Node{
	int data;
	Node left,right;
	Node(int d)
	{
		this.data=d;
		this.left=null;
		this.right=null;
	}
}
public class BinaryTree {

	Node root;
	public BinaryTree(int k)
	{
		root=new Node(k);
	}
	BinaryTree(){
		root=null;
	}
	void InOrderRecur(Node r)
	{
		if(r==null)
			return;
		InOrderRecur(r.left);
		System.out.print(r.data+" ");
		InOrderRecur(r.right);
	}
	void InOrderStk(Node r)
	{
		Stack<Node> stk=new Stack<>();
		Node curr=r;
		while(curr!=null || stk.size()>0)
		{
			while(curr!=null)
			{
				stk.push(curr);
				curr=curr.left;
			}
			curr=stk.pop();
			System.out.print(curr.data+" ");
			curr=curr.right;
		}
	}
	public void PreOrderRec(Node r)
	{
		if(r==null)
			return;
		System.out.print(r.data+" ");
		PreOrderRec(r.left);
		PreOrderRec(r.right);
	}
	public void PreOrderStk(Node r)
	{
		Stack<Node> stk=new Stack<>();
		Node curr=r;
		while(curr!=null || stk.size()>0)
		{
			while(curr!=null)
			{
				System.out.print(curr.data+" ");
				if(curr.right!=null)
				   stk.push(curr.right);
				curr=curr.left;
			}
			if(stk.size()>0)
				curr=stk.pop();
		}
	}
	public void PostOrderRec(Node r)
	{
		if(r==null)
			return;
		PostOrderRec(r.left);
		PostOrderRec(r.right);
		System.out.print(r.data+" ");
	}
	public void PostOrderStk(Node r)
	{
		Stack<Node> stk1=new Stack<>();
		Stack<Node> stk2=new Stack<>();
		stk1.push(r);
		while(!stk1.isEmpty())
		{
			Node temp=stk1.pop();
			stk2.push(temp);
			if(temp.left!=null)
				stk1.push(temp.left);
			if(temp.right!=null)
				stk1.push(temp.right);
		}
		while(!stk2.isEmpty())
		{
			Node temp=stk2.pop();
			System.out.print(temp.data+" ");
		}
	}
	public static void main(String[] args) 
	{
		BinaryTree tree=new BinaryTree();
		tree.root=new Node(25);
		tree.root.left=new Node(15);
		tree.root.right=new Node(50);
		tree.root.left.left=new Node(10);
		tree.root.left.right=new Node(22);
		tree.root.right.left=new Node(35);
		tree.root.right.right=new Node(70);
		tree.root.left.left.left=new Node(4);
		tree.root.left.left.right=new Node(12);
		tree.root.left.right.left=new Node(18);
		tree.root.left.right.right=new Node(24);
		tree.root.right.left.left=new Node(31);
		tree.root.right.left.right=new Node(44);
		tree.root.right.right.left=new Node(66);
		tree.root.right.right.right=new Node(90);
		tree.InOrderRecur(tree.root);
		System.out.println();
		tree.InOrderStk(tree.root);
		System.out.println();
		tree.PreOrderRec(tree.root);
		System.out.println();
		tree.PreOrderStk(tree.root);
		System.out.println();
		tree.PostOrderRec(tree.root);
		System.out.println();
		tree.PostOrderStk(tree.root);
	}

}
