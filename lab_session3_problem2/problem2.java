package com.lab_session3_problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int value;
	Node left;
	Node right;

	Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class problem2 {
	static Node root = null;

	static Node insert(Node root, int digit) {
		Node newNode = new Node(digit, null, null);
		if (root == null) {
			root = newNode;
			return root;
		}
		Node temp = root;
		Node temp1 = null;
		while (temp != null) {
			temp1 = temp;
			if (temp.value >= digit) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp1.value >= digit)
			temp1.left = newNode;
		else
			temp1.right = newNode;
		return root;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size, sum = 0;
		try {
			System.out.println("Enter the size of the tree : ");
			size = scanner.nextInt();

			System.out.println("Enter the values : ");
			for (int i = 0; i < size; i++) {
				System.out.println("Enter the value " + (i + 1) + " : ");
				int digit = scanner.nextInt();
				root = problem2.insert(root, digit);
			}
			System.out.println("Enter the sum : ");
			sum = scanner.nextInt();
		} catch (Exception ex) {
			System.out.println("Invalid input");
			return;
		}

		List<Integer> list = new ArrayList<>();
		list = treeToList(root, list);
		pairCheck(list, sum);
	}

	public static List<Integer> treeToList(Node root, List<Integer> arr) {
		if (root != null) {
			treeToList(root.left, arr);
			arr.add(root.value);
			treeToList(root.right, arr);
		}
		return arr;
	}

	public static void pairCheck(List<Integer> arr, int sum) {
		int start = 0;
		int end = arr.size() - 1;
		while (start < end) {
			if ((arr.get(start) + arr.get(end)) == sum) {
				System.out.println("Pair is (" + arr.get(start) + "," + arr.get(end) + ")");
				return;
			}
			if ((arr.get(start) + arr.get(end)) > sum) {
				end--;
			}
			if ((arr.get(start) + arr.get(end)) < sum) {
				start++;
			}
		}
		System.out.println("no nodes are found");
	}

}
