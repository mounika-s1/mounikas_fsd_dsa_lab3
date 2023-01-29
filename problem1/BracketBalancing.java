package com.gl.dsa.problem1;

import java.util.Stack;

public class BracketBalancing {

	public static void main(String[] args) {
		String bracketExpression = "[{(a+b)*(c+d)}--{(a+b)*(c+d)}]";
		boolean result;
		result = checkingBracketBalancing(bracketExpression);
		if (result)
			System.out.println("The entered string contain Balanced Brackets...");
		else
			System.out.println("The entered string do not contain Balanced Brackets");
	}

	private static boolean checkingBracketBalancing(String bracketExpression) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < bracketExpression.length(); i++) {
			char character = bracketExpression.charAt(i);
			if (character == '(' || character == '{' || character == '[') {
				stack.push(character);
			} else if (character == ')' || character == '{' || character == ']') {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty() ? true : false;
	}

}
