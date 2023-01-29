package com.gl.dsa.problem2;

import java.util.HashSet;
import java.util.Set;

public class FindSumPair {
	static class Node {
		int data;
		Node leftNode, rightNode;

		public Node(int data) {
			this.data = data;
			leftNode = rightNode = null;
		}
	}

	static Node createNode(int nodeData) {
		Node newNode = new Node(nodeData);
		return newNode;
	}

	public Node insert(Node root, int key) {
		if (root == null)
			return createNode(key);
		if (key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	public static void main(String[] args) {
		Node root = null;
		FindSumPair findPS = new FindSumPair();
		root = findPS.insert(root, 40);
		root = findPS.insert(root, 20);
		root = findPS.insert(root, 60);
		root = findPS.insert(root, 10);
		root = findPS.insert(root, 30);
		root = findPS.insert(root, 50);
		root = findPS.insert(root, 70);
		int targetSum = 130;
		findPS.findPairwithGivenSum(root, targetSum);
	}

	public void findPairwithGivenSum(Node root, int targetSum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPairUtil(root, targetSum, set))
			System.out.println("Pairs do not exist for the given sum" + "\n");
	}

	public boolean findPairUtil(Node root, int targetSum, HashSet<Integer> set) {
		if (root == null)
			return false;
		if (findPairUtil(root.leftNode, targetSum, set))
			return true;

		int diff = targetSum - root.data;

		if (set.contains(diff)) {
			System.out.println("Pair exist(" + diff + "," + root.data + ") " + "to the sum of " + targetSum);
			return true;
		} else
			set.add(root.data);

		return findPairUtil(root.rightNode, targetSum, set);

	}

}
