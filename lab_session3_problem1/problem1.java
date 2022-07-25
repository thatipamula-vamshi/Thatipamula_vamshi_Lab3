package com.lab_session3_problem1;

import java.util.Scanner;
import java.util.Stack;

public class problem1 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the string : ");
			String string = scanner.nextLine();

			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);
				if (!(ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']')) {
					System.out.println("Invalid String");
					return;
				}
			}

			if (areBracketsBalanced(string))
				System.out.println("The entered String has the Balanced Brackets");
			else
				System.out.println("The entered Strings does not contain Balanced Brackets");
		}
	}

	static boolean areBracketsBalanced(String ex) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < ex.length(); i++) {
			char j = ex.charAt(i);
			if (j == '(' || j == '[' || j == '{') {
				stack.push(j);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (j) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}

}
