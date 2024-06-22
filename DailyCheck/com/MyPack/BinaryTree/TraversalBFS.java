package com.mypack.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TraversalBFS extends CreateTree{
	
	public static void LevelOrderTraversal(Node root)
	{
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node tmp=q.poll();
			System.out.print(tmp.data+" ");
			if(tmp.left!=null)
				q.add(tmp.left);
			if(tmp.right!=null)
				q.add(tmp.right);
		}
	}

	public static int getHeight(Node root)
	{
		if(root==null)
			return 0;
		int l= getHeight(root.left);
		int r=getHeight(root.right);
		return Math.max(l,r)+1;
	}
	public static void printGivenLevel(Node root,int k,boolean flag)
	{
		if(root==null)
			return;
		if(k==1)
			System.out.print(root.data+" ");
		else
		{
			if(flag)
			{
				printGivenLevel(root.left, k-1, flag);
				printGivenLevel(root.right, k-1, flag);
			}
			else
			{
				printGivenLevel(root.right, k-1, flag);
				printGivenLevel(root.left, k-1, flag);
			}
		}
	}
	public static void spiralTraversal(Node root)
	{
		boolean flag=true;
		for(int i=1;i<=getHeight(root);i++)
		{
			printGivenLevel(root, i, flag);
			flag=!flag;
		}
	}
	public static void main(String[] args) {
		
		LevelOrderTraversal(root);System.out.println();
		
		printGivenLevel(root, 4, true); System.out.println();
		
		spiralTraversal(root);
	}

}
