package stacks.utils;

import stacks.LinkedStack;
import stacks.Stack;

public class ParenthesisMatching {

	
	public static boolean isMatched(String expression)
	{
		final String opening = "{[(";
		final String closing = "}])";
		
		Stack<Character> buffer = new LinkedStack<Character>();
		
		for(char c: expression.toCharArray())
		{
			if(opening.indexOf(c)!= -1)
			{
				buffer.push(c);
			}else if(closing.indexOf(c)!=-1)
			{
				if(buffer.isEmpty())
				{
					return false;
				}
				
				if(closing.indexOf(c)!= opening.indexOf(buffer.pop()))
				{
					return false;
				}
			}
		}
		
		return buffer.isEmpty(); //were all opening delimiters matched?
		
		
	}
	
	
	public static void main(String[] args) {
		String expression ="[(5+x)-(y+z)]";
		
		System.out.println("Valid Expression :: "+isMatched(expression));

	}

}
