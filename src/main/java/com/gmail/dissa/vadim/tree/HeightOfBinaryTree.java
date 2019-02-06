package com.gmail.dissa.vadim.tree;

import java.util.Scanner;

/*
 * Height of a Binary Tree
 * Function Description
 * Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.
 * getHeight or height has the following parameter(s):
 * root: a reference to the root of a binary tree.
 * Note -The Height of binary tree with single node is taken as zero.
*/

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class HeightOfBinaryTree {
	public static int height(Node root) {
		if (root == null) {
			return -1;
		} else {

			int left = height(root.left);
			int right = height(root.right);

			if (left > right)
				return (left + 1);
			else
				return (right + 1);
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		int height = height(root);
		System.out.println(height);
	}
}
