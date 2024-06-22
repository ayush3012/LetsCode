package com.mypack.BinaryTree;

import java.util.Stack;

public class TraversalDFS extends CreateTree {
	
	public static void preorderUsingStack(Node root)
	{
		Stack<Node> stk=new Stack<>();
	    stk.push(root);
	    while(!stk.isEmpty())
	    {
	    	Node tmp=stk.pop();
	    	System.out.print(tmp.data+" ");
	    	if(tmp.right!=null)
	    		stk.push(tmp.right);
	    	if(tmp.left!=null)
	    		stk.push(tmp.left);
	    }
	}

	public static void preorderUsingRecursion(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorderUsingRecursion(root.left);
		preorderUsingRecursion(root.right);
	}
	public static void inorderUsingStack(Node root)
	{
		Stack<Node> stk=new Stack<>();
		Node curr=root;
		while(curr!=null || !stk.isEmpty())
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
	public static void inorderUsingRecursion(Node root)
	{
		if(root==null)
			return;
		inorderUsingRecursion(root.left);
		System.out.print(root.data+" ");
		inorderUsingRecursion(root.right);
	}
	
	public static void postorderUsingStack(Node root)
	{
		Stack<Node> stk1=new Stack<>();
		Stack<Node> stk2=new Stack<>();
		stk1.push(root);
		while(!stk1.isEmpty())
		{
			Node tmp=stk1.pop();
			stk2.push(tmp);
			if(tmp.left!=null)
				stk1.push(tmp.left);
			if(tmp.right!=null)
				stk1.push(tmp.right);
		}
		while(!stk2.isEmpty())
		{
			Node tmp=stk2.pop();
			System.out.print(tmp.data+" ");
		}
	}
	public static void postorderUsingRecursion(Node root)
	{
		if(root==null)
			return;
		postorderUsingRecursion(root.left);
		postorderUsingRecursion(root.right);
		System.out.print(root.data+" ");
	}
	public static void main(String[] args) {
		
		preorderUsingStack(root); System.out.println();
		
		preorderUsingRecursion(root);System.out.println();
		
		inorderUsingStack(root);System.out.println();
		
		inorderUsingRecursion(root);System.out.println();
		
		postorderUsingStack(root); System.out.println();
		
		postorderUsingRecursion(root);
		
	}

}
